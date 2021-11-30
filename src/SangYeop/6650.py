import sys

def solution(s, t):
    
    s = list(s)

    for word in t:
      if(s[0]==word):
        s.pop(0)
        if (len(s)==0):
          break

    if(len(s)==0): return 'Yes'
    else: return 'No'


if __name__ == '__main__':
    while True:
        line = sys.stdin.readline().strip()
        if not line:
            break

        s, t = line.split()
        answer = solution(s, t)
        print(answer)