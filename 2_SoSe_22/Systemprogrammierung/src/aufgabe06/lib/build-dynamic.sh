#!/bin/bash
# Dynamische Bibliothek
# ---------------------
# Schreiben Sie im Unterverzeichnis lib ein Shell-Script build-dynamic.sh,
# das für die drei Übersetzungseinheiten wie zuvor mit dem g++ Objketdateien
# erzeugt und diese drei Objektdateien benotung.o, fachnote.o und fachnoten_liste.o
# dann in einer dynamischen Bibliothek libaufgabe6.so zusammenfasst.
# Das Skript soll die verwendeten Befehle auf der Konsole ausgeben
# und es soll sich beenden, sobald ein Kommando einen Fehlercode zurückgibt.
#
# Hinweis: Auf den Laborrechnern müssen Sie zum Erzeugen der Objektdateien
# den g++ mit der Option -fpic aufrufen. Sonst lässt sich die dynamische
# Bibliothek nicht bauen. pic steht für position independent code.
# Achten Sie außerdem wie zuvor auf die empfohlenen Optionen zur Qualitätssicherung.
#
# Führen Sie das Shell-Script aus und prüfen Sie, ob die erzeugte Bibliothek
# eine dynamische Bibliothek ist und Funktionen ihrer Übersetzungseinheiten enthält:
#
#  ./build-dynamic.sh
#  file libaufgabe6.so
#  nm -gC libaufgabe6.so | grep 'benotung\|fachnote\|fachnoten_liste'
#
# Lesen Sie nach, was die verwendeten Linux-Kommandos tun: man file, man nm, man grep

objects=( "fachnote" "fachnoten_liste" "benotung" )
files=""
for s in "${objects[@]}"
do
  files="$files$s.cpp "
done

compile_cmd="g++ -shared -fPIC $files -o libaufgabe6.so"
echo "$compile_cmd"
eval "$compile_cmd"
if [ $? -ne 0 ] ; then
  echo "build failed"
  exit 1
fi
#files=$(echo "$files" | sed -e 's/.cpp/.o/g')


