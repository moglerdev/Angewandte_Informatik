cmake_minimum_required(VERSION 3.22)

project(AIN2_Sysprog_07_filesize C)
set(CMAKE_C_STANDARD 11)
add_executable(AIN2_Sysprog_07_filesize src/aufgabe07/filesize.c)


project(AIN2_Sysprog_07_filecopy C)
set(CMAKE_C_STANDARD 11)
add_executable(AIN2_Sysprog_07_filecopy src/aufgabe07/filecopy.c)

project(AIN2_Sysprog_sandbox CXX)
set(CMAKE_CXX_STANDARD 11)
add_executable(AIN2_Sysprog_sandbox sandbox/rule_of.cpp)
