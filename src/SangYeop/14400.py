import sys
input = sys.stdin.readline

n = int(input())
x,y = [],[]

for _ in range(n):
  a,b = map(int, input().split())
  x.append(a)
  y.append(b)

x.sort()
y.sort()

a,b = x[n//2],y[n//2]

d = 0
for i in range(n):
  d += abs(a-x[i]) + abs(b-y[i])
print(d)