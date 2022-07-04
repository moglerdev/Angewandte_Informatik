
CC = gcc -g -fno-stack-protector -Wwrite-strings
CFLAGS = -Wall -Wextra -Werror -std=$(STD) -pedantic
CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
STD = c11

TARGET = aufgabe3

OBJECTS = \
	quadrat.o \
	wuerfel.o

HEADERS = $(OBJECTS:.o=.h)

.PHONY: all clean cppcheck

all: $(TARGET)

clean:
	$(RM) $(TARGET) $(TARGET).o $(OBJECTS)

$(TARGET): $(TARGET).o $(OBJECTS)
	$(CC) $(LDFLAGS) -o $@ $^

cppcheck: $(HEADERS)$(OBJECTS:.o=.c)
	$(CPPCHECK) $<

