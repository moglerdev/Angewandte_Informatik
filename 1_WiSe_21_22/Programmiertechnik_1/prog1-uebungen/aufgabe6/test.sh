#!/bin/bash

cd ../

ant -Dpackage=aufgabe6 compile

echo ""
echo ""
echo "-------------------------------------------------"
echo "aufgabe6/aufgabe6-in.txt"
echo "-------------------------------------------------"
java -ea aufgabe6.HtmlTranscriptOfRecords Christopher Mogler < aufgabe6/aufgabe6-in.txt
echo ""
echo "-------------------------------------------------"
echo "aufgabe6/aufgabe6-in-bonus.txt"
echo "-------------------------------------------------"
java -ea aufgabe6.HtmlTranscriptOfRecords Martin Luther < aufgabe6/aufgabe6-in-bonus.txt
echo ""
echo "-------------------------------------------------"
echo "aufgabe6/aufgabe6-in-error.txt"
echo "-------------------------------------------------"
java -ea aufgabe6.HtmlTranscriptOfRecords Hello World < aufgabe6/aufgabe6-in-error.txt
echo "-------------------------------------------------"

echo "FERTIG!"
