
#ifndef __HASH_H__
#define __HASH_H__

#include <openssl/sha.h>
#include <string.h>

extern int hash_string(const unsigned char* str, const unsigned char* buffer, unsigned char* (*_sha)(const unsigned char*, size_t, unsigned char*), size_t digest_length) {
    unsigned char hash[digest_length];
    _sha(str, strlen((char*)str), hash);

    for(int i = 0; i < digest_length; ++i) {
        if (sprintf((char*)&(buffer[i*2]), "%02x", hash[i]) < 0) {
            return -1;
        }
    }
    
    return 0;
}

extern int hash_sha1(const unsigned char* str, const unsigned char* buffer) {
    return hash_string(str, buffer, SHA1, SHA_DIGEST_LENGTH);
}

#endif // __HASH_H__