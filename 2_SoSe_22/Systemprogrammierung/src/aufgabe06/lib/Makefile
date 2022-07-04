# Aufgabe6/lib/Makefile
# ------------------------
# soll eine Bibliothek mit den Übersetzungseinheiten benotung, fachnote
# und fachnoten_liste erstellen, wobei der Bibliothekstyp mittels einer Variablen wählbar ist:
#
# make             # statische Bibliothek libaufgabe6.a erstellen
# make LIBTYPE=a   # statische Bibliothek libaufgabe6.a erstellen
# make LIBTYPE=so  # dynamischeBibliothek libaufgabe6.so erstellen
#
# Das Makefile soll folgende Regeln enthalten:
# > eine Musterregel für das Übersetzen der C-Quellen
# > Pseudoziele all und clean
# > eine explizite Regel zum Erstellen der statischen Bibliothek
# > eine explizite Regel zum Erstellen der dynamischen Bibliothek
# > eine explizite Regel zum Erstellen der Datei depend
#
# Das Makefile soll die Abhängigkeitsregeln für die beiden Objektdateien
# mit dem C++-Compiler automatisch erzeugen (depend-Regel) und per include einbinden.
#
# Das Makefile soll überall Variablen gemäß den in der Vorlesung besprochenen
# Stilregeln verwenden, d.h. alle Kommandos werden über Variablen aufgerufen
# und für alle Dateinamen gibt es Hilfsvariablen. Dabei sollen alle verwendeten
# Variablen im Makefile explizit gesetzt werden, selbst wenn sie vordefiniert sind,
 # d.h. make -R   ohne vordefinierte Variablen soll funktionieren.
#
# Hinweise:
# > stellen Sie Ihren Editor so ein, dass er Tabulatorzeichen nicht durch Leerzeichen ersetzt
# > bei C++ verwendet man statt der Variablen CC und CFLAGS die Variablen CXX und CXXFLAGS
# > geben Sie bei der all-Regel als zu erstellendes Ziel lib$(LIBNAME).$(LIBTYPE) an
#
# Testen Sie das Makefile mit den obigen Aufrufen und prüfen Sie die entstandenen
# Bibliotheken wie bei den Shell-Skripts. Testen Sie insbesondere, ob das Makefile
# bei Änderung einer Quelldatei genau die erforderlichen Kommandos zur Aktualisierung
# der Bibliothek ausführen, nicht mehr und nicht weniger.
# Die Änderung einer Datei können Sie mit dem Kommando touch vortäuschen:
#
#  touch Dateiname
# Informieren Sie sich mit man touch über das Kommando.

CXX = g++ -c #-fno-elide-constructors
STD=c++11

CXXFLAGS = -Wall -Wextra -Werror -Weffc++ -Wold-style-cast -std=$(STD) -pedantic

CPPCHECK = cppcheck --enable=warning,style --std=$(STD)

LIBTYPE = a
LIBNAME = aufgabe06
LIB_COMBO = lib$(LIBNAME).$(LIBTYPE)
LIB_NAMES = \
	libaufgabe06.a \
	libaufgabe06.so

BUILD_STATIC = ar rvs
BUILD_DYNAMIC = g++ -shared
RM = rm -f

OBJECTS = \
    benotung.o \
    fachnote.o \
    fachnoten_liste.o
SOURCES = $(OBJECTS:.o=.cpp)
HEADERS = $(OBJECTS:.o=.h)

.PHONY: all clean cppcheck

all: lib$(LIBNAME).$(LIBTYPE)

lib$(LIBNAME).a: $(OBJECTS)
	$(BUILD_STATIC) $@ $^

lib$(LIBNAME).so: $(OBJECTS)
	$(BUILD_DYNAMIC) $^ -o $@

clean:
	$(RM) $(OBJECTS) $(LIB_NAMES) depend

depend: $(SOURCES) $(HEADERS)
	$(CXX) $(CPPFLAGS) -MM $(SOURCES) > $@

cppcheck: $(OBJECTS:.o=.cpp)
	$(CPPCHECK) $^

astyle: $(SOURCES) $(HEADERS)
	$(ASTYLE) $^

%.o: %.cpp
	$(CXX) $(CPPFLAGS) $(CXXFLAGS) -c $<

include depend