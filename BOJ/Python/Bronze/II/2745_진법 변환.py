Input_String, Input_Num = input().split()

String_List = list(Input_String)
String_List.reverse()
Num_Sum = 0

for i in range(len(String_List)) :

    if 65 <= ord(String_List[i]) <= 90 :
        val = (ord(String_List[i]) - 65) + 10
    else :
        val = (ord(String_List[i]) - 48)

    Num_Sum += (int(Input_Num) ** i) * val

print(Num_Sum)