/*
 * intlist.cpp
 *
 * Beispielprogramm eingebettete Klassen.
 * Variante mit const_iterator und Iterator-Hilfstypen fuer std-Algorithmen.
 *
 * Autor: H.Drachenfels
 * Erstellt am: 11.11.2019
 */
#include "intlist.h"

//----------------------------------------------------- Klasse intlist::element
class intlist::element final
{
    element *next;
    int n;

    element(element *e, int m)
            : next(e), n(m)
    { }

    friend class intlist;
    friend class intlist::iterator;
};

//----------------------------------------- Member-Funktionen intlist::iterator
intlist::iterator::iterator(element *e)
        : current(e)
{ }

bool intlist::iterator::operator!=(const iterator& i) const
{
    return this->current != i.current;
}

int& intlist::iterator::operator*() const
{
    return this->current->n;
}

intlist::iterator& intlist::iterator::operator++()
{
    this->current = this->current->next;
    return *this;
}

//----------------------------------- Member-Funktionen intlist::const_iterator
intlist::const_iterator::const_iterator(const element *e)
        : current(e)
{ }

bool intlist::const_iterator::operator!=(const const_iterator& i) const
{
    return this->current != i.current;
}

const int& intlist::const_iterator::operator*() const
{
    return this->current->n;
}

intlist::const_iterator& intlist::const_iterator::operator++()
{
    this->current = this->current->next;
    return *this;
}

//--------------------------------------------------- Member-Funktionen intlist
intlist::intlist() : head(nullptr)
{ }

intlist::~intlist()
{
    element *e = this->head;
    while (e != nullptr)
    {
        element *x = e;
        e = e->next;
        delete x;
    }
}

intlist& intlist::insert(int n)
{
    this->head = new element(this->head, n);
    return *this;
}

intlist::iterator intlist::begin()
{
    return intlist::iterator(this->head);
}

intlist::iterator intlist::end()
{
    return intlist::iterator(nullptr);
}

intlist::const_iterator intlist::begin() const
{
    return intlist::const_iterator(this->head);
}

intlist::const_iterator intlist::end() const
{
    return intlist::const_iterator(nullptr);
}

intlist::const_iterator intlist::cbegin() const
{
    return intlist::const_iterator(this->head);
}

intlist::const_iterator intlist::cend() const
{
    return intlist::const_iterator(nullptr);
}
