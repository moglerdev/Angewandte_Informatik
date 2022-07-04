#!/bin/bash
make clean all
./scoreboard < notenspiegel-in.txt > out.txt
echo "------------------------------------------------"
cat out.txt
echo "------------------------------------------------"
diff -Z notenspiegel-out.txt out.txt
