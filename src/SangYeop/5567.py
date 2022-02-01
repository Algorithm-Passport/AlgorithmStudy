import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
friend_list = dict()
result = set()

for i in range(1,n+1):
  friend_list[i] = []

for _ in range(m):
  a,b = map(int,input().split())
  friend_list[a].append(b)
  friend_list[b].append(a)

if len(friend_list[1])==0:
  print(0)
else:
  for i in friend_list[1]:
    result.add(i)
    for j in friend_list[i]:
      result.add(j)
  print(len(result)-1)