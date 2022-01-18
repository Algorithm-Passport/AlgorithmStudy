n = int(input())
m = int(input())
k = input()

p = 'I'+'OI'*n
cnt = 0

for i in range(m):
  if k[i]=='I':
    if k[i:i+2*n+1] == p:
      cnt+=1
print(cnt)
# 이게 50점짜리인 이유는 for문의 m과 인덱싱할 때 n값이 곱해지는 n*m의 시간복잡도를 가지기 때문이다. 이것보다 빠르게 할 수 있다.
# 패턴이 있는 문자열을 볼 때 이를 처리하는 방법이다. 

import sys
input = sys.stdin.readline

N = int(input().rstrip())
M = int(input().rstrip())
S = input().rstrip()

result = 0
pattern = 0
i = 1

while i < M-1:
  if S[i-1]=='I' and S[i]=='O' and S[i+1]=='I':
    pattern += 1
    if pattern == N:
      pattern -= 1
      result += 1
    i += 1
  else:
    pattern = 0
  i += 1

print(result)
# 문자열에 패턴이 있는 문제 이런식으로 푼다. 조금더 익숙해지는 것이 필요해 보여