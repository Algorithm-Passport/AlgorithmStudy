import sys
from collections import deque

input = sys.stdin.readline


T = int(input())

for i in range(T):
    N,M   = [int(_) for _ in input().split()]
    data  = deque([int(_) for _ in input().split()])
    idx   = deque(range(0,N))
    max_i = max(data) # 중요도 최대
    cnt   = 0 # 뽑아낸 거 횟수
    
    while data:
        now_idx, now_weight = idx.popleft(), data.popleft() # 인덱스, 중요도
        
        if now_weight >= max_i:
            if now_idx == M:
                print(cnt+1)
                break
            max_i = max(data)
            cnt  += 1
        else:
            data.append(now_weight)
            idx.append(now_idx)
            
        
