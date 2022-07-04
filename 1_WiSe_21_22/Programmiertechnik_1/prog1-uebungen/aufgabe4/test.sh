#!/bin/bash

cd ../

ant -Dpackage=aufgabe4 compile


java aufgabe4.Klausurergebnis < aufgabe4/aufgabe4-in1.txt > aufgabe4/out1.txt
java aufgabe4.Klausurergebnis < aufgabe4/aufgabe4-in2.txt > aufgabe4/out2.txt
java aufgabe4.Klausurergebnis < aufgabe4/aufgabe4-in3.txt > aufgabe4/out3.txt

cd aufgabe4/

diff -w aufgabe4-out1.txt out1.txt > diff1.txt
diff -w aufgabe4-out2.txt out2.txt > diff2.txt
diff -w aufgabe4-out3.txt out3.txt > diff3.txt

echo "fertisch"