n = int(input())
arr = []
for _ in range(n):
  arr.append(input().split())

in_company = []

for a in arr:
  if a[1]=='enter':
    in_company.append(a[0])
  else:
    in_company.remove(a[0])


a = sorted(in_company,reverse=True)

for b in a:
  print(b)
