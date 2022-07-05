CC = gcc -g
CFLAGS = -Wall -Wextra -Werror -std=$(STD) -pedantic
CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
STD = c11

TARGET = gruss_test.out

.PHONY: all clean cppcheck

all: $(TARGET)

clean:
	rm -f $(TARGET) $(TARGET:.out=.o) $(OBJECTS)

$(TARGET): $(TARGET:.out=.o) $(OBJECTS)
	$(CC) $(LDFLAGS) -o $@ $^

cppcheck: $(TARGET:.out=.c) $(OBJECTS:.o=.c)
	$(CPPCHECK) $^
