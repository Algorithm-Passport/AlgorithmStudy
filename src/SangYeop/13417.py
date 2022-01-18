from sys import stdin
from collections import deque
n = int(stdin.readline())

for _ in range(n):
  m = int(stdin.readline())
  arr = stdin.readline().split()
  result = deque([arr[0]])
  for i in range(1,len(arr)):
    left = result[0]
    if arr[i]<=left:
      result.appendleft(arr[i])
    else:
      result.append(arr[i])
  print(''.join(result))
