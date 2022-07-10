#include <cstring>
#include <iostream>

#define DATA_SIZE 32

class HeapData final
{
private:
    char* data;

public:
    // Constructor // HeapData obj = new HeapData();
    HeapData() {
        this->data = new char[DATA_SIZE];
    }

    // -------------------------------------------------
    // RULE OF FIVE (RULE OF THREE)

    // Copy-Constructor // HeapData obj2 = obj;
    HeapData(const HeapData& other) {
        data = new char[DATA_SIZE];
        memcpy(this->data, other.data, DATA_SIZE);
    }
    // Copy-Assignment
    HeapData& operator=(const HeapData& other) {
        if (this == &other) {
            this->data = new char[DATA_SIZE];
            memcpy(this->data, other.data, DATA_SIZE);
        }
        return *this;
    }

    // Destructor
    virtual ~HeapData() {
        delete[] data;
    }

    // (END RULE OF THREE)
    // -------------------------------------------------

    // Move-Constructor // HeapData
    HeapData(HeapData&& other) noexcept {
        this->data = other.data;
        other.data = nullptr;
    }

    // Move Assignment
    HeapData& operator=(HeapData&& other) noexcept {
        this->data = other.data;
        other.data = nullptr;

        return *this;
    }

    // END RULE OF FIVE
    // -------------------------------------------------
};

int main(const int argc, const char** argv) {
    auto obj = new HeapData();

    auto obj_a_copy = obj;
    std::cout << "Object Assignment";
    auto obj_a_move = &obj;

    auto obj_c_copy{obj};
    auto obj_c_move{&obj};

    return 0;
}