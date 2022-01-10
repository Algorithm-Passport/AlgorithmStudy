from collections import Counter

arr = list(map(str, input().strip()))
arr.sort()
palindrome = Counter(arr)

cnt = 0
center = ''

for i in palindrome:
  if palindrome[i]%2!=0:
    cnt += 1
    center += i
    arr.remove(i)
  
  if cnt > 1:
    break

if cnt > 1:
  print("I'm Sorry Hansoo")
else:
  res = ''
  for i in range(0,len(arr),2):
    res += arr[i]
  
  print(res + center + res[::-1])

