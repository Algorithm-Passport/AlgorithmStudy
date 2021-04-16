n = int(input())
arr = list(map(int, input().split()))

d = [0] * n

d[0] = arr[0]

for i in range(1, n):
  d[i] = arr[i]
  for j in range(0, i):
    if arr[i] > arr[j] and d[i] < d[j] + arr[i]:
      d[i] = d[j] + arr[i]

print(max(d))