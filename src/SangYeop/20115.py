n = int(input())
arr = list(map(int, input().split()))
arr.sort(reverse=True)
m = arr[0]
for i in range(1,n):
  m += arr[i]/2

if m%10 == 0:
  print(int(m))
else:
  print(m)