//string.hpp
#ifndef HTWG_STRING_H
#define HTWG_STRING_H

#include <iostream>

namespace HTWG {
	class string final {
	private:
		std::size_t n;
		char *s;
	public:
		string();
		string(const char*);
		string(const string&);
		string(string &&);
		~string();

		string& operator=(const string&);
		string& operator=(string tring&);
		string& operator+=(const string&);
		friend bool operator<(const string&, const string&);
		std::size_t length() const;
		const char* c_str() const;
	}
}

