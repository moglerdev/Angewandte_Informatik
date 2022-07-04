# Aufgabe 07

## Q&A

```
Wie verhält sich filecopy?
Kopiert die angegebene Datei erfolgreich.

wenn die Quelldatei nicht existiert?
Es wird eine Fehlermedlung ausgegeben das die Quelle nicht geöffnet werden kann, da nicht vorhanden.
wenn Sie kein Leserecht auf der Quelldatei haben?
Es kommt eine Fehlermelsung das die Quelle nicht geöffnet werden kann.
wenn die Zieldatei bereits existiert?
Es kommt eine Fehlermeldung, dass das Ziel nicht erzeugt werden kann.
wenn Sie kein Schreibrecht im Zielverzeichnis haben?
Es kommt eine Fehlermeldung, dass das Ziel nicht erzeugt werden kann.

Deutschsprachige Fehlermeldungen sind nicht möglich, da das Sprachpaket nicht installiert ist.
```

## Protokoll

### Filesize

```
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ make
gcc -I.  -MM filecopy.c filesize.c > depend
gcc   filecopy.o   -o filecopy
gcc   filesize.o   -o filesize
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ ./filesize xxx *
Quelle xxx kann nicht geoeffnet werden (errno 2: No such file or directory)
depend: 46 Byte(s)
filecopy: 16552 Byte(s)
filecopy.c: 3972 Byte(s)
filecopy.o: 4800 Byte(s)
filesize: 20440 Byte(s)
filesize.c: 2535 Byte(s)
filesize.o: 8888 Byte(s)
img.png: 259053 Byte(s)
Makefile: 460 Byte(s)
protokoll-aufgabe7.txt: 8806 Byte(s)

Beendet...
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ ls -l xxx *
ls: cannot access 'xxx': No such file or directory
-rw-rw-r-- 1 mogler mogler     46 Jun 23 15:37 depend
-rwxrwxr-x 1 mogler mogler  16552 Jun 23 15:37 filecopy
-rw-rw-r-- 1 mogler mogler   3972 Jun 23 15:34 filecopy.c
-rw-rw-r-- 1 mogler mogler   4800 Jun 23 15:36 filecopy.o
-rwxrwxr-x 1 mogler mogler  20440 Jun 23 15:37 filesize
-rw-rw-r-- 1 mogler mogler   2535 Jun 23 15:17 filesize.c
-rw-rw-r-- 1 mogler mogler   8888 Jun 23 15:17 filesize.o
-rw-rw-r-- 1 mogler mogler 259053 Jun 23 13:45 img.png
-rw-rw-r-- 1 mogler mogler    460 Jul  1  2021 Makefile
-rw-rw-r-- 1 mogler mogler   8806 Jul  2  2021 protokoll-aufgabe7.txt
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ export LC_MESSSAGES=C
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ ./filesize xxx *
Quelle xxx kann nicht geoeffnet werden (errno 2: No such file or directory)
depend: 46 Byte(s)
filecopy: 16552 Byte(s)
filecopy.c: 3972 Byte(s)
filecopy.o: 4800 Byte(s)
filesize: 20440 Byte(s)
filesize.c: 2535 Byte(s)
filesize.o: 8888 Byte(s)
img.png: 259053 Byte(s)
Makefile: 460 Byte(s)
protokoll-aufgabe7.txt: 8806 Byte(s)

Beendet...
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ ls -l xxx *
ls: cannot access 'xxx': No such file or directory
-rw-rw-r-- 1 mogler mogler     46 Jun 23 15:37 depend
-rwxrwxr-x 1 mogler mogler  16552 Jun 23 15:37 filecopy
-rw-rw-r-- 1 mogler mogler   3972 Jun 23 15:34 filecopy.c
-rw-rw-r-- 1 mogler mogler   4800 Jun 23 15:36 filecopy.o
-rwxrwxr-x 1 mogler mogler  20440 Jun 23 15:37 filesize
-rw-rw-r-- 1 mogler mogler   2535 Jun 23 15:17 filesize.c
-rw-rw-r-- 1 mogler mogler   8888 Jun 23 15:17 filesize.o
-rw-rw-r-- 1 mogler mogler 259053 Jun 23 13:45 img.png
-rw-rw-r-- 1 mogler mogler    460 Jul  1  2021 Makefile
-rw-rw-r-- 1 mogler mogler   8806 Jul  2  2021 protokoll-aufgabe7.txt
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$
```

### Filecopy

```
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ ./filecopy filecopy.c filecopy-kopie.c
Kopieren erfolgreich!
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ ./filecopy filecopy.c filecopy-kopie.c
Ziel filecopy-kopie.c kann nicht erzeugt werden (errno 17: File exists)
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ diff filecopy.
filecopy.c  filecopy.o  
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ diff filecopy.c filecopy-kopie.c 
mogler@mogler-ubuntu:~/repos/HTWG/AIN2_Sysprog/src/aufgabe07$ ./filecopy asdasodasod asdasdasd
Quelle asdasodasod kann nicht geoeffnet werden (errno 2: No such file or directory)

mogler@mogler-ubuntu:~$ export LC_MESSAGES=C
mogler@mogler-ubuntu:~$ cd 
mogler@mogler-ubuntu:~$ mkdir tmp
mogler@mogler-ubuntu:~$ cd tmp/
mogler@mogler-ubuntu:~/tmp$ cp ~/repos/HTWG/AIN2_Sysprog/src/aufgabe07/filecopy ./
mogler@mogler-ubuntu:~/tmp$ cp ~/repos/HTWG/AIN2_Sysprog/src/aufgabe07/img.png ./
mogler@mogler-ubuntu:~/tmp$ ls -l
total 276
-rwxrwxr-x 1 mogler mogler  16552 Jun 23 15:49 filecopy
-rw-rw-r-- 1 mogler mogler 259053 Jun 23 15:50 img.png
mogler@mogler-ubuntu:~/tmp$ 
mogler@mogler-ubuntu:~/tmp$ chmod -r img.png 
mogler@mogler-ubuntu:~/tmp$ ./filecopy img.png sad
Quelle img.png kann nicht geoeffnet werden (errno 13: Permission denied)
mogler@mogler-ubuntu:~/tmp$ chmod +r img.png 
mogler@mogler-ubuntu:~/tmp$ ./filecopy img.png sad
Kopieren erfolgreich!
mogler@mogler-ubuntu:~/tmp$ chmod -w ../tmp/
mogler@mogler-ubuntu:~/tmp$ ./filecopy img.png sasadasd
Ziel sasadasd kann nicht erzeugt werden (errno 13: Permission denied)
mogler@mogler-ubuntu:~/tmp$ chmod +w ../tmp/
mogler@mogler-ubuntu:~/tmp$ ./filecopy img.png sasadasdsdasd
Kopieren erfolgreich!
mogler@mogler-ubuntu:~/tmp$
```