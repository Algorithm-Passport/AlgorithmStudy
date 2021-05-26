import sys
from collections import deque, Counter
from itertools import chain

input = sys.stdin.readline

N,M,T = [int(i) for i in input().split()]
data  = [[]]

for i in range(N):
    data.append(deque([int(_) for _ in input().split()]))

def rolling(x, d, k):
    global data
    if d == 0: # 시계 방향
        for i in range(1, N+1):
            if i%x == 0:
                data[i].rotate(k)
    if d == 1: # 반시계 방향
        for i in range(1, N+1):
            if i%x == 0:
                data[i].rotate(-k)
def clear(y,x):
    global data
    global clearlist
    dx = [-1,1,0,0] # 원 내부 이웃
    dy = [0,0,-1,1] # 원 바깥 이웃
    
    current = data[y][x]
    if current == 0:
        return
    # 동서남북
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if ny <= 0 or ny > N:
            continue
        if nx != -1:
            if data[ny][nx%M] == current:
                clearlist.append((ny,nx%M))
        else:
            if data[ny][nx] == current:
                clearlist.append((ny,nx))
            

def avg_set(avg):
    global data
    for i in range(1,N+1):
        for j in range(M):
            if data[i][j] != 0 and data[i][j] > avg:
                data[i][j] -= 1
            elif data[i][j] != 0 and data[i][j] < avg:
                data[i][j] += 1    
        

for _ in range(T):
    x,d,k     = [int(i) for i in input().split()]
    clearlist = []
    rolling(x,d,k)
    
    for c in range(1,N+1):
        for m in range(M):
            clear(c,m)

    if clearlist:
        while clearlist:
            circle, idx = clearlist.pop()
            data[circle][idx] = 0
    else:
        tmp = list(chain(*data))
        bunmo = len(tmp)-Counter(tmp)[0]
        if bunmo != 0:
            avg = sum(tmp)/bunmo
            avg_set(avg)
        else:
            pass
print(sum(chain(*data)))
    
