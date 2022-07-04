#!/bin/bash

cd ../

ant -Dpackage=aufgabe5 compile

echo ""
echo ""
echo "NORMAL"
echo "-------------------------------------------------"
java aufgabe5.Notenspiegel < aufgabe5/aufgabe5-in.txt
echo "-------------------------------------------------"

echo "" 
echo ""
echo "BONUS"
echo "-------------------------------------------------"
java aufgabe5.Notenspiegel < aufgabe5/aufgabe5-bonus.txt
echo "-------------------------------------------------"
cd aufgabe5/

echo "FERTIG!"