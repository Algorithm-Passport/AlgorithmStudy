import sys
from collections import defaultdict

N,M = [int(i) for i in sys.stdin.readline().split()]

a = {}
b = {}
k = 0

for i in range(N):
    a[sys.stdin.readline().rstrip()] = 1
for m in range(M):
    tmp = sys.stdin.readline().rstrip()
    try:
        a[tmp]
        b[tmp] = 1
        k += 1
    except:
        pass


print(k)
for i in sorted(a):
    try:
        b[i]
        k+=1
        print(i)
    except:
        pass
