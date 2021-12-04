from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
q = deque([])

for _ in range(N):
  word = input().split()
  order = word[0]
  # print(order)
  # print(word[1])
  if(order == 'push_front'):
    q.appendleft(int(word[1]))
  elif(order == 'push_back'):
    q.append(int(word[1]))
  elif(order == 'pop_front'):
    if(len(q)==0):
      print(-1)
    else:
      n = q.popleft()
      print(n)
  elif(order == 'pop_back'):
    if(len(q)==0):
      print(-1)
    else:
      n = q.pop()
      print(n)
  elif(order == 'size'):
    print(len(q))
  elif(order == 'empty'):
    if(len(q)==0):
      print(1)
    else:
      print(0)
  elif(order == 'front'):
    if(len(q)==0):
      print(-1)
    else:
      print(q[0])
  elif(order == 'back'):
    if(len(q)==0):
      print(-1)
    else:
      print(q[-1])