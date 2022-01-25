import sys

N = int(sys.stdin.readline())

for _ in range(N):

  T = sys.stdin.readline()

  def solution(T):
    stack = [0]
    if(T[0]=='A'):T=T
    else: T = T[1:len(T)]
    
    for t in T:
      if(t=='A'): stack.append('A')
      elif(stack[-1]=='A'):
        if(t=='F'): stack.append('F')
        else: 
          print('Good')
          return 
      elif(stack[-1]=='F'):
        if(t=='F'): continue
        if(t=='C'): stack.append('C')
        else: 
          print('Good')
          return 
      elif(stack[-1]=='C'):
        if(t=='C'): continue
        if(t=='B'or'D'or'E'): stack.append(t)
      else: 
        print('Good')
        return 
    print('Infected!')
  solution(T)

# ##############
import sys

T = int(sys.stdin.readline())
rule = ['A', 'B', 'C', 'D', 'E', 'F', '']
for _ in range(T):
    s = sys.stdin.readline().rstrip()
    i = 0
    stack = []
    for c in s:
        if stack:
            if stack[-1] == c:
                continue
        stack.append(c)
    short = ''.join(stack)
    if 'A' not in short:
        print('Good')
    else:
        start = short.index('A')
        if short[start:start+3] != 'AFC':
            print('Good')
        else:
            left = short[:start]
            right = short[start+3:]
            if left in rule and right in rule:
                print("Infected!")
            else:
                print('Good')