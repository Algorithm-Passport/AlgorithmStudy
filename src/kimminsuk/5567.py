import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

arr = [[int(i) for i in sys.stdin.readline().split()] for _ in range(m)]
arr.sort()
p = [0 for _ in range(n+1)]
res = 0

for k in arr:
    if k[0] == 1 and p[k[1]] == 0:
        res+=1
        p[k[1]] +=1
        continue
    if (p[k[0]] == 1 and p[k[1]] == 0):
        p[k[1]] += 2
        res += 1
    elif (p[k[1]] == 1 and p[k[0]] == 0):
        p[k[0]] += 2
        res +=1
print(res)
