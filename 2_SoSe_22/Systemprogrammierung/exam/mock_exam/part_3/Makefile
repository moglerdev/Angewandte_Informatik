
CC = gcc -g -fno-stack-protector -Wwrite-strings
CFLAGS = -Wall -Wextra -std=$(STD) -pedantic
CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
STD = c11

TARGET = wuerfel_test

OBJECTS = \
	quadrat.o \
	wuerfel.o

.PHONY: all clean cppcheck

all: $(TARGET)

clean:
	$(RM) $(TARGET) $(TARGET).o $(OBJECTS)

$(TARGET): $(TARGET).o $(OBJECTS)
	$(CC) $(LDFLAGS) -o $@ $^

cppcheck: $(HEADERS) $(OBJECTS:.o=.c)
	$(CPPCHECK) $<

%.o: %.c
	$(CC) $(CFLAGS) -c $<

depend: $(OBJECTS:.o=.c) $(OBJECTS:.o=.h)
	$(CC) $(CFLAGS) -MM $(OBJECTS:.o=.c) > $@

include depend
