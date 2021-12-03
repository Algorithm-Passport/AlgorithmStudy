import sys

N = int(sys.stdin.readline())
stack = []
for _ in range(N):
  input = sys.stdin.readline().split()
  W = input[0]

  if(W=='push'): 
    n = input[1]
    stack.append(n)
  elif(W=='pop'): 
    if(len(stack)==0):
      print(-1)
    else:
      p = stack.pop()
      print(p)
  elif(W=='size'):
    print(len(stack))
  elif(W=='empty'):
    if(len(stack)==0):
      print(1)
    else:
      print(0)
  elif(W=='top'):
    if(len(stack)==0):
      print(-1)
    else:
      top = stack[-1]
      print(top)
