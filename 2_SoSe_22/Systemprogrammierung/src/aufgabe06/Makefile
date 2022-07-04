# Aufgabe6/Makefile
# ------------------
# ruft erst das Makefile im Unterverzeichnis lib und dann das Makefile
# im Unterverzeichnis bin rekursiv auf. In den Vorlesungsunterlagen finden
# Sie eine ausformulierte Vorlage für das rekursive Makefile.
# Rufen Sie zum Testen der Make-Rekursion im Verzeichnis
# Aufgabe6 folgende Befehle auf und prüfen Sie die Ergebnisse:
#
#  make clean
#  make -R all
#  bin/notenspiegel
#  make -R clean
#  make -R LIBTYPE=so
#  ldd bin/notenspiegel
#  LD_LIBRARY_PATH=lib ldd bin/notenspiegel
#  LD_LIBRARY_PATH=lib bin/notenspiegel
#
# Was hat es mit der Umgebungsvariablen LD_LIBRARY_PATH
# auf sich? Lesen Sie dazu Folie 4-25.
#
# Was könnte man in Ihren Makefiles alles weglassen,
# wenn man auf die make-Option -R verzichten würde?

PACKAGES= \
	lib/ \
	bin/

.PHONY: all clean

all clean:
	@ for p in $(PACKAGES); do \
		(cd $$p && $(MAKE) $@); \
	done