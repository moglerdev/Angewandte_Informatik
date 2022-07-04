# Aufgabe 7

## Aufgabenstellung

- [Aufgabenblatt07.pdf](../../docs/Aufgabenblatt07.pdf)

## Ergebnis

### System

| #           | Name / Size / Type                                     |
|-------------|--------------------------------------------------------|
| Motherboard | Gigabyte Technology Co., Ltd. X470 AORUS GAMING 7 WIFI |
| Memory      | 16.0 GiB                                               |
| Processor   | AMD® Ryzen 7 2700x eight-core processor × 16           |
| OS          | Ubuntu 22.04 LTS ; 64 bit                              |

### Table

| Verfahren                       | 100.000<br />zufällige Spielkarten | 200.000<br />zufällige Spielkarten | 100.000<br />sortierte Spielkarten | 200.000<br />sortierte Spielkarten |
| ------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| Hybrides QuickSort              | 29.4455 ms                         | 27.4923 ms                         | 343.1834 ms                        | 400.4929 ms                        |
| Hybrides QuickSort mit 3-Median | 24.8153 ms                         | 19.3667 ms                         | 12.8154 ms                         | 18.5624 ms                         |
| Array.sort                      | 26.5775 ms                         | 102.8842 ms                        | 4.7188 ms                          | 3.5733 ms                          |

