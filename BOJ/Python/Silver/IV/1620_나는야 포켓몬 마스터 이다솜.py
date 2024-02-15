import sys

inputList1 = {}
inputList2 = {}
n, k = map(int, sys.stdin.readline().rstrip().split())

j = 1
for i in range(n) :
    poketMone = sys.stdin.readline().rstrip()
    inputList1[poketMone] = str(j)
    inputList2[str(j)] = poketMone
    j += 1

inputList3 = [sys.stdin.readline().rstrip() for _ in range(k)]

for i in inputList3 :
    if i in inputList1 :
        print(int(inputList1[i]))
    elif i in inputList2 :
        print(inputList2[i])
