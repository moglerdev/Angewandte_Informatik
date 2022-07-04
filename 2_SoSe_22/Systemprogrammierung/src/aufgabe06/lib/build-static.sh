#!/bin/bash
# Statische Bibliothek
# ---------------------
# Schreiben Sie im Unterverzeichnis lib ein Shell-Script build-static.sh,
# das für die drei Übersetzungseinheiten Objketdateien erzeugt und diese
# drei Objektdateien benotung.o, fachnote.o und fachnoten_liste.o dann in
# einer statischen Bibliothek libaufgabe6.a zusammenfasst. Das Skript soll
# die verwendeten Befehle auf der Konsole ausgeben und es soll sich beenden,
# sobald ein Kommando einen Fehlercode zurückgibt.
#
# Verwenden Sie im Skript den g++ mit den empfohlenen Optionen zur Qualitätssicherung.
#
# Führen Sie das Shell-Script aus und prüfen Sie,
# ob die erzeugte Bibliothek alle drei Übersetzungseinheiten enthält:
#
#  ./build-static.sh
#  ar t libaufgabe6.a
#
# Lesen Sie nach, was die Option t bei ar bewirkt: man ar
#
# Hinweis: sh verlangt Linux-Zeilenwechsel in Skriptdateien.
# Windows-Zeilenwechsel führen zu Fehlermeldungen.

objects=( "fachnote" "fachnoten_liste" "benotung" )
files=""
for s in "${objects[@]}"
do
  files="$files$s.cpp "
  compile_cmd="g++ -c $s.cpp"
  echo "$compile_cmd"
  eval "$compile_cmd"
  if [ $? -ne 0 ] ; then
    echo "build failed"
    exit 1
  fi
done
files=$(echo "$files" | sed -e 's/.cpp/.o/g')

combine_static_lib_cmd="ar rvs libaufgabe6.a $files"
echo "$combine_static_lib_cmd"
eval "$compile_cmd"
if [ $? -ne 0 ] ; then
  echo "build failed"
  exit 1
fi
echo "build successful"