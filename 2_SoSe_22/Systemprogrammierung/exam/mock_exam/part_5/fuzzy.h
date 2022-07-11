


class fuzzy final 
{
public:
    fuzzy() = default;

    explicit fuzzy(double);
    fuzzy(bool);
    fuzzy operator!() const;
    friend fuzzy operator&&(const fuzzy&, const fuzzy&);
    friend fuzzy operator||(const fuzzy&, const fuzzy&);

    // a) [Rule of Five]
    // Destructor
    ~fuzzy() = default;
    // Copy Constructor und Assignment
    fuzzy(const fuzzy&) = default;
    fuzzy& operator=(const fuzzy&) = default;
    // Move Constructor und Assignment
    fuzzy(fuzzy&&) = default;
    fuzzy& operator=(fuzzy&&) = default;

    // c)
    fuzzy& operator<<(const char*);

private:
    double truth;
};

int main() {

    // d)
    fuzzy* a = new fuzzy[4];

    delete[] a;
}


