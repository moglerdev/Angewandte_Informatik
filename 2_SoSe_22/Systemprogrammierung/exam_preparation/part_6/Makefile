CXX = g++ -g -fno-elide-constructors
CXXFLAGS = -Wall -Wextra -Werror -Weffc++ -Wold-style-cast -std=$(STD) -pedantic
CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
STD = c++11

TARGET = gruss_test.out
OBJECTS = \
    gruss.o \
	
.PHONY: all clean cppcheck

all: $(TARGET)

clean:
	rm -f $(TARGET) $(TARGET:.out=.o) $(OBJECTS)

$(TARGET): $(TARGET:.out=.o) $(OBJECTS)
	$(CXX) $(LDFLAGS) -o $@ $^

cppcheck: $(TARGET:.out=.cpp) $(OBJECTS:.o=.cpp)
	$(CPPCHECK) $^

gruss_test.o: gruss_test.cpp gruss.h
gruss.o: gruss.cpp gruss.h