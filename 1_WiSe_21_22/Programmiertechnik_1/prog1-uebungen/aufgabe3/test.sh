#!/bin/bash

cd ./bonus

javac NotenstatistikBonus.java

java -cp ../../ aufgabe3.bonus.NotenstatistikBonus < ../aufgabe3-in1.txt > ../out1.txt
java -cp ../../ aufgabe3.bonus.NotenstatistikBonus < ../aufgabe3-in2.txt > ../out2.txt
java -cp ../../ aufgabe3.bonus.NotenstatistikBonus < ../aufgabe3-in3.txt > ../out3.txt

cd ../

diff -w aufgabe3-out1.txt out1.txt
diff -w aufgabe3-out2.txt out2.txt
diff -w aufgabe3-out3.txt out3.txt
