n,m = map(int,input().split())

arr = []

def BT():
  if len(arr)==m:
    print(' '.join(map(str,arr)))
    return
  for i in range(1,n+1):
    if i not in arr:
      arr.append(i)
      BT()
      arr.pop()

BT()