Count_Num = int(input())

for i in range(Count_Num):
    n1, n2 = map(int, input().split())
    print("Case #{}: {} + {} = {}".format(i+1, n1, n2, n1 + n2))