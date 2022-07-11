CC = gcc -g
CFLAGS = -Wall -Wextra -Werror -std=$(STD) -pedantic
CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
STD = c11

TARGET = summe.out

.PHONY: all clean cppcheck

all: $(TARGET)

clean:
	rm -f $(TARGET) $(TARGET:.out=.o)

$(TARGET): $(TARGET:.out=.o)
	$(CC) $(LDFLAGS) -o $@ $^

cppcheck: $(TARGET:.out=.c) 
	$(CPPCHECK) $^
