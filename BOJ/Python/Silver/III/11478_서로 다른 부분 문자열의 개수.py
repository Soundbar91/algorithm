import sys

inputStr = sys.stdin.readline().strip()
outputSet = set()

for i in range(len(inputStr)) :
    for j in range(i, len(inputStr)) :
        outputSet.add(inputStr[i:j + 1])
        
print(len(outputSet))
