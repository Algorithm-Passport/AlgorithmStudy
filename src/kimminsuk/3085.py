import sys

N = int(sys.stdin.readline())
arr = []
ans = 0
for i in range(N):
    arr.append([i for i in sys.stdin.readline().strip()])

def solve():
    global N
    global arr
    max_x, max_y = 1,1
    
    # 행 기준으로 한 줄씩 돌림.
    for row in range(N):
        cnt_y = 1 #vertical
        cnt_x = 1 #horizon
        for col in range(N-1):
            # 행 검사
            if arr[row][col] == arr[row][col+1]:
                cnt_x +=1
            else:
                max_x = max(max_x, cnt_x)
                cnt_x = 1
            if arr[col][row] == arr[col+1][row]:
                cnt_y += 1
            else:
                max_y = max(max_y, cnt_y)
                cnt_y = 1
            
        max_x = max(max_x, cnt_x)
        max_y = max(max_y, cnt_y)
    return max(max_x, max_y)
        
    

for y in range(N):
    for x in range(N-1):
        # 위치바꾸기 - 가로
        arr[y][x], arr[y][x+1] = arr[y][x+1], arr[y][x]
        ans = max(ans, solve())
        arr[y][x], arr[y][x+1] = arr[y][x+1], arr[y][x]
        # 위치바꾸기 - 세로
        arr[x][y], arr[x+1][y] = arr[x+1][y], arr[x][y]
        ans = max(ans, solve())
        arr[x][y], arr[x+1][y] = arr[x+1][y], arr[x][y]
print(ans)
            
