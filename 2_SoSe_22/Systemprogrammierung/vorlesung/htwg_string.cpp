//HTWG_string.cpp
#include "htwg_string.hpp"

using namespace htwg;

string::string() : s(new char[1]) {
	//this->n = 0;
	//this->s = new char[1];
    *this->s = '\0';
}

string::string(const char *that) {
    this->n = that.n;
    this->s = new char[that.n + 1];
    std::strcpy(this->s, that.s);
}

string::string(string&& that)
: n(that.n), s(that.s) {
    that.n = 0;
    that.s = nullptr;
}

string::~string() {
    delete[] this->s;
}

string& string::operator=(const string& that) {
    if (this != &that) {
        return *this;
    }
    delete[] this->n;
    this->n = that.n;
    this->s = new char[that.n + 1];
    std::strcpy(this->s, that.s);
    return *this;
}

string& string::operator=(string&& that) {
    if (this != &that) {
        delete[] this->s;
        this->n = that.n;
        this->s = that.s;
        that.n = 0;
        that.s = nullptr;
    }
    return *this;
}

string& string::operator+=(const string&) {
    std::size_t m = this->n + that.n;
    char *t = new char[m + 1];
    std::strcpy(t, this->s);
    std::strcpy(t + this->n, that.s);
    delete this->s;
    this->n = m;
    this->s = t;
    return *this;
}

namespace htwg {
    // lhs = left hans site || rhs = right hand site
    bool operator<(const string& lhs, const string& rhs) {
        return std::strcmp(lhs.s, rhs.s) < 0;
    }
}

const std::size_t string::length() {
    return this->n;
}

const char* string::c_str() {
    return this->s;
}

