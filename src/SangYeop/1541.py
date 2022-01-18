arr = input().split('-')
sum = 0

for i in arr[0].split('+'):
  sum += int(i)

for i in arr[1:]:
  for j in i.split('+'):
    sum -= int(j)

print(sum)