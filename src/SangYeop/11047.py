import sys
input = sys.stdin.readline
n,k = map(int, input().split())
arr = []

for _ in range(n):
  arr.append(int(input()))
cnt = 0

for i in range(n-1,-1,-1):
  if arr[i] > k:
    continue
  else:
    while k >= arr[i]:
      k -= arr[i]
      cnt += 1
print(cnt)
