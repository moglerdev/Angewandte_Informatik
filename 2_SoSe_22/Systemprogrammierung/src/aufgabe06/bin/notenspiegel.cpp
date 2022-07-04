/*
 * notenspiegel.cpp
 *
 * Liest die Namen von Faechern mit den zugehoerigen Noten in eine
 * verkettete Liste ein und gibt dann einen Notenspiegel aus.
 *
 * Autor: H.Drachenfels
 * Version: 19.12.2019
 */
#include "../lib/benotung.h"
#include "../lib/fachnote.h"
#include "../lib/fachnoten_liste.h"
#include <iostream>
#include <iomanip>
#include <stdexcept>
#include <cstdio>
#include <string>
#include <numeric>
#include <algorithm>
#include <forward_list>

namespace
{
std::ostream& operator<<(std::ostream& os, const benotung& n);
void delete_fachnote(fachnote *);
}

int read_grade(int& note);

int main()
{
    fachnoten_liste liste(delete_fachnote); // leere Liste
    //std::forward_list<std::shared_ptr<fachnote>> liste;
    //--------------------------------------------- Notenspiegel einlesen
    std::cerr << "Fach und Note zwischen "
              << benotung::beste.int_value()
              << " und "
              << benotung::schlechteste.int_value()
              << " eingeben (Ende mit Strg-D):\n";

    while (true)
    {
        try
        {
            // Fach und Note einlesen:
            std::string fach;
            if (!(std::cin >> fach))
            {
                break;
            }

            int note;
            int res = read_grade(note);
            if (res == -1)
            {
                std::cerr << "Fach " << fach << " ohne Note ignoriert!\n";
                break;
            }
            else if (res == 0)
            {
                std::string s;
                std::cin >> s;
                std::cerr << "Eingabefehler: " << s << '\n';
                continue;
            }

            int note2;
            if (read_grade(note2) != 1)
            {
                // neue Fachnote in Notenliste eintragen:
                auto* f = new fachnote{fach, benotung{note}};
                liste.insert(f);
            }
            else
            {
                // neue Fachnote in Notenliste eintragen:
                auto* f = new fachnote{fach, benotung{note, note2}};
                liste.insert(f);
            }
        }
        catch (std::invalid_argument& x)
        {
            std::cerr << "Eingabefehler: " << x.what() << '\n';
            continue;
        }
    }

    //--------------------------------------------- Notenspiegel ausgeben
    std::size_t max_laenge = std::accumulate(liste.begin(), liste.end(), 0, [](size_t a, fachnote* b)
    {
        if (a < b->fach.length())
        {
            return b->fach.length();
        }
        return a;
    });

    std::cout << "\nNOTENSPIEGEL\n";
    for (const auto& f : liste)
    {
        std::cout << std::setw(static_cast<int>(max_laenge)) << std::left << f->fach << '\t'
                  << f->note << '\t';
        if (f->note == benotung::beste)
        {
            std::cout << "mit Bestnote bestanden\n";
        }
        else if (f->note.ist_bestanden())
        {
            std::cout << "bestanden\n";
        }
        else
        {
            std::cout << "nicht bestanden\n";
        }
    }
}

int read_grade(int& note)
{
    if (!(std::cin >> note))
    {
        if (std::cin.eof())
        {
            return -1;
        }
        std::cin.clear();
        return 0;
    }
    return 1;
}

namespace
{
std::ostream& operator<<(std::ostream& os, const benotung& n)
{
    int note = n.int_value();
    os << note / 10 << ',' << note % 10;
    return os;
}

void delete_fachnote(fachnote *f)
{
    delete f;
}
}

