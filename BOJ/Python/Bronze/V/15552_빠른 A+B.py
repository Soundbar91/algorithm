import sys

Num_Count = eval(input())
Num_Sum = []

for i in range(Num_Count) :
    n1, n2 = map(int, sys.stdin.readline().rstrip().split())
    Num_Sum.append(n1 + n2)

for i in range(Num_Count) : print(Num_Sum[i])