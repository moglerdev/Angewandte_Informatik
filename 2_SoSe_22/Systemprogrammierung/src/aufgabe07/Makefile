CC = gcc
STD = c11
CFLAGS = -W -Wall -std=$(STD) -pedantic -fpic
CPPFLAGS = -I.
RM = rm -f

TARGET1 = filecopy
TARGET2 = filesize
OBJECTS = filecopy.o filesize.o
SOURCES = $(OBJECTS:.o=.c)

%.o: %.c 
	$(CC) $(CPPFLAGS) $(CFLAGS) $< -c -o $@

.PHONY: all clean

all: $(TARGET1) $(TARGET2)

clean: 
	$(RM) $(TARGET1) $(TARGET2) $(OBJECTS) depend
	

depend: $(SOURCES)
	 $(CC) $(CPPFLAGS) $(LDFLAGS) -MM $(SOURCES) > $@
	

include depend