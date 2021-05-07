import sys
import time

start = time.time()

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

S = sys.stdin.readline().rstrip()

ans = 0
cnt = 0
i = 0
while i < M-2:
    if S[i] == 'I' and S[i+1] == 'O' and S[i+2] == "I":
        cnt += 1
        if cnt == N:
            ans += 1
            cnt -= 1
        i += 1
    else:
        cnt = 0
    i += 1
print(ans)
