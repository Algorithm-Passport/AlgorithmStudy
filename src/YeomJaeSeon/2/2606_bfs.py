# bfs

from collections import deque

comNum = int(input())
couples = int(input())

arr = []
for _ in range(couples):
  arr.append(list(map(int, input().split())))

graph = [[]]

for i in range(1, comNum + 1):
  insertArr = []
  for info in arr:
    if info[0] == i:
      insertArr.append(info[1])
    elif info[1] == i:
      insertArr.append(info[0])
  insertArr.sort()
  graph.append(insertArr)

visited = [False] * (comNum + 1)

def bfs(graph, startNode):
  queue = deque()
  queue.append(startNode)
  visited[startNode] = True

  while queue:
    v = queue.popleft()
    for i in graph[v]:
      if visited[i] == False:
        queue.append(i)
        visited[i] = True


bfs(graph, 1) # 1번부터 bfs로 그래프탐색

cnt = 0
for i in range(2, len(visited)):
  if visited[i] == True:
    cnt += 1

print(cnt)  # 본인컴 빼야함
