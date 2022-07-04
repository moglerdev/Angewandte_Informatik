//
// Created by mogler on 23.06.22.
//

/*
 * Erstellen Sie ein C-Programm filecopy, das als Kommandozeilenargumente zwei Dateinamen erwartet und die erstgenannte Datei in die
 * zweitgenannte kopiert.
 * Das Programm soll zur Größenbestimmung die POSIX-Funktion fstat verwenden, daraufhin mit malloc einen Puffer in Dateigröße allokieren,
 * die Quelldatei mit einem einzigen Aufruf der POSIX-Funktion read in den Puffer kopieren und schließlich den Puffer mit einem einzigen Aufruf
 * der POSIX-Funktion write in die Zieldatei schreiben (siehe man 2 fstat, man 2 read, man 2 write oder die POSIX-Dokumentation im
 * Internet).
 * Achten Sie auf eine korrekte und vollständige Fehlerbehandlung mit für den Benutzer aussagekräftigen Fehlermeldungen. Stellen Sie für die
 * Systemmeldungen die deutsche Sprache ein, um ein sprachliches Durcheinander zwischen Systemmeldungen und eigenen Fehlertexten zu
 * vermeiden:
 *
 * setlocale(LC_MESSAGES, "de_DE.UTF-8");
 *
 * Geben Sie eine Warnung aus, wenn die Plattform die deutschen Systemmeldungen nicht unterstützt.
 * Hinweise:
 * Verwenden Sie das Vorlesungsbeispiel copy.c als Vorlage und ersetzen Sie die byteweise Kopierschleife durch die genannten Aufrufe von
 * POSIX-Funktionen.
 * Beachten Sie auch hier, dass die POSIX-Funktionen mit Aliasnamen für ganzzahlige Datentypen definiert sind. Ihr Programm muss damit
 * richtig umgehen.
 */


#define _POSIX_C_SOURCE 1

#include <stdio.h>  // fprintf
#include <string.h> // strerror
#include <locale.h>
#include <fcntl.h>    // open, O_RDONLY, O_WRONLY, O_CREAT, O_EXCL
#include <sys/stat.h> // mode_t, S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH
#include <unistd.h>   // read, write
#include <errno.h>    // errno

#include <stdlib.h>

int main(const int argc, const char** argv)
{
    if (argc != 3)
    {
        printf("Sie müssen genau zwei Dateinamen angeben!\n");
        return -1;
    }

    setlocale(LC_MESSAGES, "de_DE.UTF-8");

    const char* master_file = argv[1];
    const char* slave_file = argv[2];

    struct stat stat_buffer;

    int in = open(master_file, O_RDONLY); // Dateindeskriptor Quelle
    if (in == -1)
    {
        fprintf(stderr,
                "Quelle %s kann nicht geoeffnet werden (errno %d: %s)\n",
                master_file, errno, strerror(errno));
        return 1;
    }

    if (fstat(in, &stat_buffer) != 0)
    {
        fprintf(stderr,
                "Quelle %s kann nicht geoeffnet werden (errno %d: %s)\n",
                argv[1], errno, strerror(errno));
        return 1;
    }

    const mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH; // rw-r--r--
    int out = open(slave_file, O_WRONLY | O_CREAT | O_EXCL, mode); // Dateiseskriptor Ziel
    if (out == -1)
    {
        fprintf(stderr,
                "Ziel %s kann nicht erzeugt werden (errno %d: %s)\n",
                argv[2], errno, strerror(errno));
        return 1;
    }

    char *img_buffer = malloc(stat_buffer.st_size);
    ssize_t statr = read(in, img_buffer, stat_buffer.st_size);

    if (statr == -1)
    {
        fprintf(stderr, "Lesefehler (errno %d : %s)\n", errno, strerror(errno));
        free(img_buffer);
        return 1;
    }
    else if (statr > stat_buffer.st_size)
    {
        fprintf(stderr, "Zu wenig Speicher zum erstellen des Programms");
        free(img_buffer);
        return 1;
    }

    ssize_t statw = write(out, img_buffer, stat_buffer.st_size);

    if (statw == -1)
    {
        fprintf(stderr, "Schreibfehler (errno %d : %s)\n", errno, strerror(errno));
        free(img_buffer);
        return 1;
    }
    else if (statw > stat_buffer.st_size)
    {
        fprintf(stderr, "Zu wenig Speicher zum erstellen des Programms");
        free(img_buffer);
        return 1;
    }
    else if (statw == 0)
    {
        fprintf(stderr, "Fehler beim Uebertragen der Datei");
        free(img_buffer);
        return 1;
    }

    printf("Kopieren erfolgreich!\n");
    free(img_buffer);
    close(in);
    close(out);

    return 0;
}