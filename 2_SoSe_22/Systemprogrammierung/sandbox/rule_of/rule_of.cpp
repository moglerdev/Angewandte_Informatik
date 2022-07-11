#include <cstring>
#include <iostream>

#include "HeapData.h"

int main(const int argc, const char** argv) {
    std::cout << "Constructor" << std::endl;
    HeapData obj;

    std::cout << "\nCopy-Constructor" << std::endl;
    HeapData obj_c_copy( obj );

    std::cout << "\nCopy-Assignment" << std::endl;
    obj_c_copy = obj;
    
    std::cout << "\nMove-Constructor" << std::endl;
    HeapData obj_c_move = std::move(obj);

    std::cout << "\nMove Assignment" << std::endl;
    //HeapData obj_a_move = &obj;

    //std::cout << obj_c_move->getData() << std::endl;
    
    std::cout << "\nEnd" << std::endl;

    return 0;
}