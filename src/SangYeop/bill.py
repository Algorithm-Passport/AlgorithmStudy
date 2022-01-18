n,m = map(int,input().split())

# 화폐 넣기
arr = []
for _ in range(n):
  arr.append(int(input()))

# dp테이블 만들기
d = [10001]*(m+1)
d[0] = 0 #이것의 의미는???? 아하 이것도 사용될 수 있기 때문에. 예를들어 arr에 2,3 이 있으면 2,3을 만드는 가지수를 생성할때, 0을 만드는 가지수에서 +1을 해야 해

for i in range(n):
  for j in range(arr[i],m+1):
    if d[j-arr[i]] != 10001:
      d[j] = min(d[j], d[j-arr[i]]+1)

if d[m]==10001:
  print(-1)
else:
  print(d[m])
