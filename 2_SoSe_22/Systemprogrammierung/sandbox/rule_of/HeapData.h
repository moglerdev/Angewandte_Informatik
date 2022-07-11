#include <cstring>
#include <iostream>

constexpr auto DATA_SIZE = 32;

class HeapData final
{
private:
    char* data;

public:
    /// <summary>
    /// Constructor
    /// <para>HeapData obj = new HeapData();</para>
    /// </summary>
    HeapData();
   
    /// <summary>
    /// Rule 1 - Copy-Constructor
    /// <para>HeapData copyObj {obj};</para>
    /// </summary>
    /// <param name="other">Objekt von wo es kopiert wird</param>
    HeapData(const HeapData& other);

    /// <summary>
    /// Rule 2 - Copy-Assignment 
    /// <para>auto newObj = (HeapData) obj;</para>
    /// </summary>
    /// <param name="other">Objekt von wo es kopiert wird</param>
    /// <returns></returns>
    HeapData& operator=(const HeapData& other);
    
    /// <summary>
    /// Rule 3 - Destructor
    /// <para>delete obj;</para>
    /// <para>wird aufgerufen bevor das Objekt "zerstört" wird.</para>
    /// <para>Alle Kopierte Objekte müssen auch "zerstört" werden!</para>
    /// </summary>
    virtual ~HeapData();
    /// <summary>
    /// Rule 4 - Move-Constructor
    /// <para>HeapData newObj{ &obj };</para>
    /// </summary>
    /// <param name="other">Objekt was "gemoved" wird</param>
    /// <returns></returns>
    HeapData(HeapData&& other) noexcept;

    /// <summary>
    /// Rule 5 - Move-Assignment
    /// <para>auto newObj = &obj;</para>
    /// </summary>
    /// <param name="other">Objekt was "gemoved" wird</param>
    /// <returns>gibt das verschobene Objekt zurück</returns>
    HeapData& operator=(HeapData&& other) noexcept;

    const char* getData() const;
};