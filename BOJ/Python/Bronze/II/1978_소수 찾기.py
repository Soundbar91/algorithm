Input_Num = eval(input())
Input = list(map(int, input().split()))

for i in range(len(Input)) :
    if Input[i] == 1 : 
        Input_Num -= 1
    else :
        for j in range(2, Input[i]) :
            if Input[i] % j == 0 : 
                Input_Num -= 1
                break

print(Input_Num)