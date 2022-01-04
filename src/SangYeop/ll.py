import sys
from collections import deque

n = int(sys.stdin.readline())

for _ in range(n):
  word = sys.stdin.readline().strip()
  left = deque()
  right = []
  for w in word:
    if w == '<':
      if left:
        right.append(left.pop())
    elif w == '>':
      if right:
        left.append(right.pop())
    elif w == '-':
      if left:
        left.pop()
    else:
      left.append(w)
  left.extend(reversed(right))
  print(''.join(left))