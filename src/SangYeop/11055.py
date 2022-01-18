n = int(input())
arr = list(map(int,input().split()))
# 나의 앞에 작은 것들만 선택해서 더 한 것 중 가장 큰 것만 디피에 넣는 컨셉이다.
d = arr[:]

for i in range(1,n):
  for j in range(i):
    if arr[j] < arr[i]:
      d[i] = max(d[i],d[j]+arr[i])
print(max(d))


################################

import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int,input().split()))
dp = [0]*1001

for i in A:
    dp[i] = max(dp[:i])+i
print(max(dp))

# 와우! 이 풀이 엄청난걸???!!!
# 생각연습이 더 필요하다.