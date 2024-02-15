Input_Num = eval(input())
list = []
i = 2

while (i < Input_Num + 1) :
    if Input_Num % i == 0 :
        Input_Num = Input_Num // i
        list.append(i)
    else : i += 1

for i in range(len(list)) : print(list[i])