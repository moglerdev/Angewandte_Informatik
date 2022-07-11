#include <cstring>
#include <iostream>

#include "HeapData.h"

int main(const int argc, const char** argv) {
    std::cout << "Constructor" << std::endl;
    HeapData* obj = new HeapData();

    std::cout << "Copy-Constructor" << std::endl;
    HeapData* obj_c_copy( obj );
    std::cout << "Copy-Assignment" << std::endl;
    HeapData* obj_a_copy = obj;
    
    std::cout << "Move-Constructor" << std::endl;
    HeapData* obj_c_move = std::move(obj);
    std::cout << "Move Assignment" << std::endl;
    //HeapData* obj_a_move = &obj;

    std::cout << obj_c_move->getData() << std::endl;
    
    delete obj;
    delete obj_c_copy;
    delete obj_a_copy;
    std::cout << "End" << std::endl;

    return 0;
}