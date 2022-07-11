#include "HeapData.h"

// Constructor // HeapData obj = new HeapData();
HeapData::HeapData() {
    this->data = new char[DATA_SIZE];
    std::cout << "X Constructor" << std::endl;
}

// -------------------------------------------------
// RULE OF FIVE (RULE OF THREE)

// Copy-Constructor // HeapData obj2 = obj;
HeapData::HeapData(const HeapData& other) {
    std::cout << "X Copy-Constructor" << std::endl;
    data = new char[DATA_SIZE];
    memcpy(this->data, other.data, DATA_SIZE);
}
// Copy-Assignment
HeapData& HeapData::operator=(const HeapData& other) {
    std::cout << "X Copy-Assignment" << std::endl;
    if (this != &other) {
        this->data = new char[DATA_SIZE];
        memcpy(this->data, other.data, DATA_SIZE);
    }
    return *this;
}

// Destructor
HeapData::~HeapData() {
    std::cout << "X Destructor" << std::endl;
    delete[] data;
}

// (END RULE OF THREE)
// -------------------------------------------------

// Move-Constructor // HeapData
HeapData::HeapData(HeapData&& other) noexcept {
    std::cout << "X Move-Constructor" << std::endl;
    this->data = other.data;
    other.data = nullptr;
}

// Move Assignment
HeapData& HeapData::operator=(HeapData&& other) noexcept {
    std::cout << "X Move Assignment" << std::endl;
    this->data = other.data;
    other.data = nullptr;

    return *this;
}


// END RULE OF FIVE
// -------------------------------------------------

// Move Assignment
const char* HeapData::getData() const {
    return this->data;
}