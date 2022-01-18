import sys
input = sys.stdin.readline

while True:
  s = input().rstrip()
  if s == "*":
    break

  for n in range(1,len(s)-1):
    check = set()
    for i in range(len(s)-n):
      word = s[i]+s[i+n]
      if word in check:
        print(s,"is NOT surprising.")
        break
      else:
        check.add(word)
    else:
      continue
    break
  else:
    print(s,"is surprising.")
  
# 18-20번째 줄의 처리가 왜 저런식으로 되는지 잘 모르겠어
