import math

from PIL import Image

print("Autoren: Jona Böcker, Lukas Butscher, Wiebke Prinz, Tobias Stöhr")

print("\nAufgabe 3.1.1:\n")

print("P(1) + P(2) = 0.08 + 0.16 = 0.24\n")

print("\nAufgabe 3.1.2:\n")

print("a) P(M|S) = P(M∩S)/P(M) = 0.62/0.75 =", 0.62 / 0.75,
      "\nb) P(S|M) = P(M∩S)/P(S) = 0.62/0.72 =", 0.62 / 0.72,
      "\nc) P(!M|S) = P(!M∩S)/P(S) = 0.10/0.72 =", 0.10 / 0.72)

print("\nAufgabe 3.2.1:\n")

print("P(10W) = 1 - (P(!L) * P(!E)) = 1 - (0.8 * 0.6) =", 1 - (0.8 * 0.6))

print("\nAufgabe 3.2.2:\n")

print("a) 2/5 =", 2 / 5,
      "\nb) 3/5 * 2/4 + 2/5 * 1/4 =", 3 / 5 * 2 / 4 + 2 / 5 * 1 / 4,
      "\nc)Baumdiagramm:")
im1 = Image.open("3.2.2c.png")
im1.show()

print("\nAufgabe 3.3:\n")

print("a)\tP(C) = 0.3",
      "\n\tP(N) = 0.5",
      "\n\tP(S) = 0.2",
      "\n\tP(V) = P(C) * P(V|C) + P(N) * P(V|N) + P(S) * P(V|S)"
      "\nb)\tP(V) = P(C) * P(V|C) + P(N) * P(V|N) + P(S) * P(V|S) =", 0.3 * 0.055 + 0.5 * 0.03 + 0.2 * 0.015,
      "\nc)\t1) P(S|V) = P(S∩V) / P(V) = 0.2 * 0.015 / 0.0345 =", 0.2 * 0.015 / 0.0345,
      "\n\t2) P(N|V) = P(N∩V) / P(V) = 0.5 * 0.03 / 0.0345 =", 0.5 * 0.03 / 0.0345,
      "\n\t3) P(C|V) = P(C∩V) / P(V) = 0.3 * 0.055 / 0.0345 =", 0.3 * 0.055 / 0.0345)

print("\nAufgabe 3.5:\n")

print("Vierfeldertafel:")
print("\t", "N\t", "!N\t", "\t")
print(" V\t", "0.45\t", "0.15\t", "0.6\t")
print("!V\t", "0.25\t", "0.15\t", "0.4\t")
print("\t", "0.7\t", "0.3\t", "1.0\t")

print("a) P(!N|!V) = P(!V∩!N)/P(!V) = 0.15/0.4 = ", round(0.15 / 0.4, 2))
print("b) P(N|V) = P(V∩N)/P(V) = 0.45/0.6 = ", 0.45 / 0.6)

print("\nAufgabe 3.7.1:\n")

print("a) 20! =", math.factorial(20),
      "\nb) 10!^2 =", math.factorial(10)**2,
      "\nc) 10*10!^2 =", 10*math.factorial(10)**2)

print("\nAufgabe 3.7.2:\n")

im2 = Image.open("3.7.2.png")
im2.show()

print("\nAufgabe 3.8.1:\n")

im3 = Image.open("3.8.1.png")
im3.show()
