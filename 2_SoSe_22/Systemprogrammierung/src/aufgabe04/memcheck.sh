#!/bin/bash
make clean all
valgrind ./scoreboard < notenspiegel-in-tooloong.txt
echo "------------------------------------------"
make cppcheck