

TAR_NAME = aufgabe1.tar.gz
TAR = tar cvzf
DIR = ../part_1/
OBJECTS = $(DIR)gruss.h 

.PHONY: all clean

part2: $(clean)
	$(TAR) $(TAR_NAME) $(OBJECTS)

clean:
	rm -f $(TAR_NAME)