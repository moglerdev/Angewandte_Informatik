
CC = gcc -g -fno-stack-protector -Wwrite-strings
CFLAGS = -Wall -Wextra -std=$(STD) -pedantic
CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
STD = c11

TARGET = part_7

OBJECTS = \

.PHONY: all clean cppcheck

all: $(TARGET)

run: clean all
	clear
	./$(TARGET)

clean:
	$(RM) $(TARGET) $(TARGET).o $(OBJECTS)

$(TARGET): $(TARGET).o $(OBJECTS)
	$(CC) $(LDFLAGS) -o $@ $^

%.o: %.c
	$(CC) $(CFLAGS) -c $<
