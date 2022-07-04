//
// Created by mogler on 26.05.22.
//

#ifndef INTLIST_H
#define INTLIST_H

#include <iterator>

class intlist final
{
private:
    class element;
    element *head;

public:
    intlist();
    ~intlist();
    // Entity-Klasse ohne Kopier- und Move-Semantik
    intlist(const intlist&) = delete;
    intlist& operator=(const intlist&) = delete;
    intlist(intlist&&) = delete;
    intlist& operator=(intlist&&) = delete;

    intlist& insert(int);

    class iterator final
    {
    private:
        element *current;
        explicit iterator(element*);
    public:
        bool operator!=(const iterator&) const;
        int& operator*() const;
        iterator& operator++();

        friend class intlist;

        typedef std::input_iterator_tag iterator_category;
        typedef int value_type;
        typedef std::ptrdiff_t difference_type;
        typedef int* pointer;
        typedef int& reference;
    };

    iterator begin();
    iterator end();

    class const_iterator final
    {
    private:
        const element *current;
        explicit const_iterator(const element*);
    public:
        bool operator!=(const const_iterator&) const;
        const int& operator*() const;
        const_iterator& operator++();

        friend class intlist;

        typedef std::input_iterator_tag iterator_category;
        typedef const int value_type;
        typedef std::ptrdiff_t difference_type;
        typedef const int* pointer;
        typedef const int& reference;
    };

    const_iterator begin() const;
    const_iterator end() const;
    const_iterator cbegin() const;
    const_iterator cend() const;
};

#endif
