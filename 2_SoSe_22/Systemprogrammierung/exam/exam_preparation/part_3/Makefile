CC = gcc -g
CFLAGS = -std=$(STD) -pedantic
CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
STD = c11

TARGET = heap_and_stack.out

.PHONY: all clean cppcheck

all: $(TARGET)

clean:
	rm -f $(TARGET) $(TARGET:.out=.o) $(OBJECTS)

$(TARGET): $(TARGET:.out=.o) $(OBJECTS)
	$(CC) $(LDFLAGS) -o $@ $^

cppcheck: $(TARGET:.out=.c) $(OBJECTS:.o=.c)
	$(CPPCHECK) $^
