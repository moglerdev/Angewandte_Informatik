CXX = g++ -fno-elide-constructors
CXXFLAGS = -Wall -Wold-style-cast -std=$(STD) -pedantic
CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
STD = c++11

TARGET = rule_of
OBJECTS = \
    HeapData.o \

.PHONY: all clean cppcheck

all: $(TARGET)

clean:
	rm -f $(TARGET) $(TARGET).o $(OBJECTS)

$(TARGET): $(TARGET).o $(OBJECTS)
	$(CXX) $(LDFLAGS) -o $@ $^

cppcheck: $(TARGET).cpp $(OBJECTS:.o=.cpp)
	$(CPPCHECK) $^

%.o: %.cpp
	$(CXX) $(CPPFLAGS) $(CXXFLAGS) -c $<

depend: $(SOURCES) $(HEADERS)
	$(CXX) $(CPPFLAGS) -MM $(SOURCES) > $@

include depend