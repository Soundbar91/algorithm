n = eval(input())
lst = []

for i in range(n) :
    Input = input()
    if Input in lst :
        n -= 1
    else : lst.append(Input)

for i in range(1, n) :
    key = lst[i]
    j = i - 1

    while j >= 0 and (len(lst[j]) > len(key) or (len(lst[j]) == len(key) and lst[j] > key)) :
        lst[j + 1] = lst[j]
        j -= 1

    lst[j + 1] = key

for ch in lst : print(ch)