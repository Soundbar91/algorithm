Num1 = eval(input())
Num2 = eval(input())
Sum = 0
Cnt = 0
list = []

for i in range(Num1, Num2 + 1) :
    if i == 1 : continue
    Sum += i

    for j in range(2, i) :
        if i % j == 0 : 
            Sum -= i
            Cnt = 1
            break
    
    if Cnt == 1 :
        Cnt = 0
        continue

    else : list.append(i)

if len(list) == 0 : print(-1)
else :
    print(Sum)
    print(min(list))