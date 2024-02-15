Input_Num = eval(input())
List = [int(input()) for _ in range(Input_Num)]

for i in range(1, len(List)) :
    for j in range(i - 1, -1, -1) :
        if List[i] < List[j] : 
            List[i], List[j] = List[j], List[i]
            i -= 1

for i in List :
    print(i)