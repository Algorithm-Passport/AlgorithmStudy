n = int(input())
arr = [0]
for _ in range(n):
  arr.append(int(input()))

if n==1:
  print(arr[1])
else:

  d = [0]*(n+1)
  d[1] = arr[1]
  d[2] = arr[1]+arr[2]

  for i in range(3, n+1):
    d[i] = max(d[i-3]+arr[i-1]+arr[i],d[i-2]+arr[i])

  print(d[n])

# 연속된 세계단이슈 => 미리 값을 저장해서 해결
# 마지막 계단 이슈 => 마지막 것을 출력하면 가능 
# index맞추기
# n==1일때!
