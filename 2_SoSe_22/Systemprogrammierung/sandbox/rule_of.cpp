#include <cstring>

#define DATA_SIZE 32

class HeapData final
{
private:
    char* data;

public:
    // Constructor // HeapData obj = new HeapData();
    HeapData(/* args */) {
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
    HeapData& operator=(HeapData& other) {
        data = new char[DATA_SIZE];
        memcpy(this->data, other.data, DATA_SIZE);

        return *this;
    }

    // Destructor
    virtual ~HeapData() {

    }

    // (END RULE OF THREE)
    // -------------------------------------------------

    // Move-Constructor // HeapData
    HeapData(HeapData&& other) {
        this->data = other.data;
        other.data = nullptr;
    }

    // Move Assignment
    HeapData& operator=(HeapData&& other) {
        this->data = other.data;
        other.data = nullptr;

        return *this;
    }

    // END RULE OF FIVE
    // -------------------------------------------------
};

int main(const int argc, const char** argv) {

    return 0;
}