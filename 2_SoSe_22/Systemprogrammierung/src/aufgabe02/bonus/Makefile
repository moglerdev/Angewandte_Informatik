#
# Makefile
#
# Author: Christopher Mogler
# Created: 20.04.2022
#

CC = gcc -g
CFLAGS = -Wall -Wextra -Werror -Wvla -std=$(STD) -pedantic
CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
STD = c11

TARGET = bonus

.PHONY: all clean cppcheck

all: $(TARGET)

clean:
	$(RM) $(TARGET) $(TARGET).o

cppcheck: $(TARGET).c
	$(CPPCHECK) $<

