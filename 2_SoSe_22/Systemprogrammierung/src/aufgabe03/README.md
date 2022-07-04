# Aufgabe 03

> Warum ist das ein sinnvoller Wert?

Weil der größte Wert niemals größer sein kann, 
als der aufruf Parameter.

> Verhält sich das C-Programm bei allen Eingaben wie das Java-Programm?

Ja

> Meldet valgrind Fehler?

Nein

- stringsort.c
    ```
    ...
    ==35803==
    ==35803== HEAP SUMMARY:
    ==35803==     in use at exit: 0 bytes in 0 blocks
    ==35803==   total heap usage: 204 allocs, 204 frees, 9,441 bytes allocated
    ==35803==
    ==35803== All heap blocks were freed -- no leaks are possible
    ==35803==
    ==35803== For lists of detected and suppressed errors, rerun with: -s
    ==35803== ERROR SUMMARY: 0 errors from 0 contexts (suppressed: 0 from 0)
    ...
    ```
- stringsort-optimiert.c
    ```
    ==35803==
    ==35803== HEAP SUMMARY:
    ==35803==     in use at exit: 0 bytes in 0 blocks
    ==35803==   total heap usage: 204 allocs, 204 frees, 9,441 bytes allocated
    ==35803==
    ==35803== All heap blocks were freed -- no leaks are possible
    ==35803==
    ==35803== For lists of detected and suppressed errors, rerun with: -s
    ==35803== ERROR SUMMARY: 0 errors from 0 contexts (suppressed: 0 from 0)
    ```


> Meldet cppcheck Probleme?
 
Nein

> Ist das speicher-optimierte Programm schneller als das nicht optimierte?

Nein, weil das Array, also der Speicherbereich der Strings, bei großer Anzahl nicht mehr
als Ganzes in den Cache passt und dadurch der Cache nicht mehr performant arbeiten kann.
Der String Array (char double Pointer) ist so aufgebaut, dass die ersten Pointer auf
den Pointer des ersten chars verweist. So mit ist der Array viel kleiner und der Cache kann sich die einzelnen "Strings" in den Cache ziehen und somit viel effizienter arbeiten.