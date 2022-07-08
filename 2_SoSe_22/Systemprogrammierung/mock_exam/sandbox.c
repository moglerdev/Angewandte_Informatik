#include <openssl/sha.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

struct linked_pointer {
    struct linked_pointer* prev;
    size_t index;
    void* a_pointer;
};

struct linked_pointer* curr_sp = NULL;
size_t lp_cnt = 0;

void* allocate(size_t size) {
    void* result = malloc(size);
    if (result == NULL) {
        return NULL;
    }
    struct linked_pointer* tmp = malloc(sizeof(struct linked_pointer));
    tmp->prev = curr_sp;
    tmp->index = lp_cnt;
    tmp->a_pointer = result;
    
    ++lp_cnt;

    curr_sp = tmp;
    return result;
}

void free_space() {
    struct linked_pointer* sp = curr_sp;
    if (sp == NULL) {
        return;
    }

    do {
        free(sp->a_pointer);
        struct linked_pointer* prev = (struct linked_pointer*)sp->prev;
        free(sp);
        sp = prev;
    } while (sp != NULL);
}

int is_password(const char* password, const char* given_hash) {
    unsigned char hash[SHA_DIGEST_LENGTH];
    const char* t = SHA1(password, strlen(password), hash);
    if (strcmp(password, hash) == 0) {
        return 1;
    }
    return 0;
}

char* scrape_password(const char* combinations, const int max_length, const char* given_hash) {
    size_t len_comb = strlen(combinations);

    char* password = allocate(max_length);
    if (password == NULL) {
        printf("Could not allocate memory space!");
        return NULL;
    }

    for(int a = len_comb; a > 0; --a) {
        password[0] = combinations[a];
        double pro = ((len_comb - a) / (double)len_comb) * 100;
        printf("%.2f%% fertig\n", pro);
        fflush(stdout);
        for(int b = len_comb; b > 0; --b) {
            password[1] = combinations[b];
            for(int c = len_comb; c > 0; --c) {
                password[2] = combinations[c];
                for(int d = len_comb; d > 0; --d) {
                    password[3] = combinations[d];
                    for(int e = len_comb; e > 0; --e) {
                        password[4] = combinations[e];
                        if (is_password(password, given_hash) == 1) {
                            return password;
                        }
                    }
                }
            }
        }
    }
}

int64_t run() {
    static const char* hashed_password = "A045B7EFA463C6ED195C644163F4168952FBD34A";//"39228d06a988045c5caaa97bf0a6158893d51862";
    
    static const size_t length = 5;

    // 0x41 - 0x5A | A - Z
    // 0x61 - 0x7A | a - z
    // 0x30 - 0x39 | 0 - 9

    char* combinations = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        "abcdefghijklmnopqrstuvwxyz"
        "0123456789 ";

    const char* pw = scrape_password(combinations, length, hashed_password);
    if (pw == NULL) {
        printf("error");
        return -1;
    }

    printf("Gefunden: %s", pw);

    return 0;
}


int64_t main(void) {
    int64_t res = run();

    free_space();

    return res;
}