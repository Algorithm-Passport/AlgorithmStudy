import sys

input = sys.stdin.readline

n,m  = map(int,input().split())

listen = dict()
result = []
for i in range(n):
  x = input()
  listen[x] = i

for _ in range(m):
  see = input()
  if see in listen:
    result.append(see)

result.sort()
print(len(result))
print(''.join(result), end = '')