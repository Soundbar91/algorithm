import sys

n = eval(input())
set = set()

for i in range(n) :
    n, k = map(str, sys.stdin.readline().rstrip().split())
    if n in set :
        set.remove(n)
    else :
        set.add(n)
        
lst = sorted(list(set), reverse = True)
for i in lst :
    print(i)
