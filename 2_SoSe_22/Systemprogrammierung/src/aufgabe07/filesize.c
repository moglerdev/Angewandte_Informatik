//
// Created by mogler on 23.06.22.
//

/*
 * Erstellen Sie ein C-Programm filesize, das als Kommandozeilenargumente beliebig viele Dateinamen erwartet und für jede der Dateien die
 * Größe in Byte auf die Standardausgabe schreibt.
 * Bei einem Aufruf ohne Kommandozeilenargumente soll das Programm mit der POSIX-Funktion read byteweise von der Standardeingabe lesen
 * und dabei die Anzahl der Bytes zählen. Andernfalls soll das Programm für die angegebenen Dateien zur Größenbestimmung die POSIX-
 * Funktion stat verwenden. Siehe man 2 read und man 2 stat oder die POSIX-Dokumentation im Internet. Achten Sie auf eine korrekte
 * Fehlerbehandlung mit Ausgabe der zugehörigen Systemmeldung. Damit die Systemmeldung in der auf dem Rechner (bzw. der beim Aufruf
 * verwendeten Konsole) eingestellten Sprache erscheint, müssen Sie am Anfang des Programms folgenden Aufruf einfügen (siehe auch
 * man 3 setlocale):
 *
 * setlocale(LC_ALL, "");
 *
 * Hinweise:
 * Verwenden Sie das Vorlesungsbeispiel count.c als Vorlage. Ersetzen Sie im Fall der Standardeingabe den C-Bibliotheksaufruf fgetc durch
 * den Aufruf der POSIX-Funktion read und bei Dateien die ganze Lese-/Zähl-Schleife durch den Aufruf der POSIX-Funktion stat. Den C-
 * Bibliotheksaufruf fopen brauchen Sie nicht mehr (Warum?). Beachten Sie außerdem, dass POSIX für ganzahlige Datentypen in der Regel
 * Aliasnamen verwendet. Ihr Programm muss damit richtig umgehen.
 */

#include <errno.h>    // errno
#include <stdio.h>
#include <locale.h>
#include <stdint.h>
#include <unistd.h>
#include <sys/stat.h>
#include <string.h> // strerror

void print_size_of_file(int start, int len, const char** filenames);

int main(const int argc, const char** argv)
{
    setlocale(LC_ALL, "");

    if (argc < 2)
    {
        printf("\nBitte geben Sie einen Text: ");
        uintmax_t i = 0; // \0 = ''

        char buffer[1];
        while (read(STDIN_FILENO, &buffer, 1) > 0)
        {
            ++i;
        }
        printf("Ihre Eingabe verbraucht %ju Byte(s).", i);
    }
    else
    {
        print_size_of_file(1, argc, argv);
    }

    printf("\nBeendet...\n");

    return 0;
}


void print_size_of_file(const int start, const int len, const char** filenames)
{
    struct stat sb;

    for (int i = start; i < len; ++i)
    {
        if (stat(filenames[i], &sb) == -1)
        {
            fprintf(stderr,
                    "Quelle %s kann nicht geoeffnet werden (errno %d: %s)\n",
                    filenames[i], errno, strerror(errno));
            continue;
        }

        printf("%s: %ju Byte(s)\n", filenames[i], sb.st_size);
    }
}
