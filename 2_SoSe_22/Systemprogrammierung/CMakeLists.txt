cmake_minimum_required(VERSION 3.22)
project(AIN2_Sysprog CXX)

set(CMAKE_CXX_STANDARD 11)

add_executable(AIN2_Sysprog src/aufgabe05/notenspiegel.cpp src/aufgabe05/benotung.cpp src/aufgabe05/benotung.h src/aufgabe05/fachnote.cpp src/aufgabe05/fachnote.h src/aufgabe05/fachnoten_liste.cpp src/aufgabe05/fachnoten_liste.h)
