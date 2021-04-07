n = int(input())
m = int(input())

graph = [[] for i in range(n + 1)]

arr = []
for i in range(m):
  newArr = list(map(int, input().split()))
  arr.append(newArr)

for i in range(m):
  for j in range(2):
    if j == 0:
      if arr[i][1] not in graph[arr[i][0]]:
        graph[arr[i][0]].append(arr[i][1])
    else:
      if arr[i][0] not in graph[arr[i][0]]:
        graph[arr[i][1]].append(arr[i][0])

result = []

myFriends = graph[1]

for i in range(len(myFriends)):
  if myFriends[i] not in result:
    result.append(myFriends[i])
  otherFriend = graph[myFriends[i]]
  for j in range(len(otherFriend)):
    if otherFriend[j] not in result:
      result.append(otherFriend[j])

print(len(result) - 1)