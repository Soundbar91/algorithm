import sys

lst = {}

n = eval(input())
inputList1 = list(map(int, sys.stdin.readline().rstrip().split()))

for i in inputList1 :
    if i in lst :
        lst[i] += 1
    else :
        lst[i] = 1

n1 = eval(input())
inputList2 = list(map(int, sys.stdin.readline().rstrip().split()))

for i in inputList2 :
    if i in lst :
        print(lst[i])
    else :
        print(0)
