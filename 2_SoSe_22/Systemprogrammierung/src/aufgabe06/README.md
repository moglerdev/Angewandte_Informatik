# Aufgabe 06

## Verbesserungswünsche
```txt
lib/*.sh
Der Wildcard * ist problematisch. Besser die Quelldateien explizit aufzaehlen.

lib/Makefile:
Sie sollten das Uebersetzen nicht in das Bauen der Bibliotheken reinmixen.
Es ist dann nicht gewaehrleistet, dass make immer nur die minimal erforderlichen
Arbeitsschritte ausfuehrt. Bei Ihrer Loesung werden die Abhaengigkeitsregeln aus
depend gar nicht verwendet. Schreiben Sie fuer das Uebersetzen wie in der 
Aufgabenstellung verlangt eine Musterregel und geben Sie in den Regeln fuer die
Bibliotheken jeweils eine Abhaengigkeit von $(OBJECTS) an. Nutzen Sie dann im Kommando
die automatischen Variablen.

bin/Makefile:
Auch hier fehlt die Musterregel zum Uebersetzen.
TARGET ist abhaengig von der Bibliothek, damit bei neuer Bibliotethek auch das 
ausfuehrbare Programm neu gebaut wird.
HEADERS muss die .h-Dateien der Bibliothek enthalten, damit bei Schnittstellenaenderungen
neu gebaut wird.

bin/bonus.mak:
Sie brauchen eine Regel fuer das zu bauende Archiv, und die clean-Regel muss dieses
Archiv wieder wegwerfen.
```
