import sys

n = eval(input())
inputList = list(map(int, sys.stdin.readline().rstrip().split()))

inputList1 = sorted(list(set(inputList)))
outputList = dict(zip(inputList1, list(range(len(inputList)))))

for e in inputList :
    print(outputList[e])
