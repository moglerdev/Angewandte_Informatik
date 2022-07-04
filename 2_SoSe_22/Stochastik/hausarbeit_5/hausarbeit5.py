import pandas as pd
import statistics

l_x1 = [1, 1, 1, 1, 2, 3, 3, 3]
l_x2 = [1, 1, 1, 2, 2, 2, 3, 3]

test = [1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6]

v1 = statistics.variance(l_x1)
v2 = statistics.variance(test)

print("Variance for X1:", v1)
print("Variance for X2:", v2)

