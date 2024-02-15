Input_N, Input_M = map(int, input().split())
List = [input() for i in range(Input_N)]
Map_W_Cnt = 0
Map_B_Cnt = 0
Out_List = []

Map_W = [
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
]

Map_B = [
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
]

for i in range(Input_N - 7) :
    for j in range(Input_M - 7) :

        for k in range(8) :
            for w in range(8) :
                if List[i + k][j + w] != Map_B[k][w] : Map_B_Cnt += 1
                if List[i + k][j + w] != Map_W[k][w] : Map_W_Cnt += 1

        Out_List.append(min(Map_W_Cnt, Map_B_Cnt))
        Map_W_Cnt = 0
        Map_B_Cnt = 0

print(min(Out_List))