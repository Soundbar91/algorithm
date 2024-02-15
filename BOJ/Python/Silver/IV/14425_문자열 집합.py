import sys

n, k = map(int, sys.stdin.readline().rstrip().split())
inputList1 = [sys.stdin.readline().rstrip() for _ in range(n)]
inputList2 = [sys.stdin.readline().rstrip() for _ in range(k)]

inputList1 = sorted(inputList1)

def search(A, low, high, key) :
    if low > high : 
        return 0
    
    middle = (low + high) // 2
    
    if A[middle] == key :
        return 1
    elif A[middle] > key :
        return search(A, low, middle - 1, key)
    else :
        return search(A, middle + 1, high, key)
    
cnt = 0
for i in inputList2 :
    cnt += search(inputList1, 0, len(inputList1) - 1, i)
    
print(cnt)