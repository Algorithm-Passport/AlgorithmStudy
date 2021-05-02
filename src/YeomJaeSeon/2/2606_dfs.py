# dfs - 깊이 우선탐색(stack - 재귀함수)

comNum = int(input())
couples = int(input())

arr = []
for _ in range(couples):
  arr.append(list(map(int, input().split())))

graph =[[]] # 인접 리스트 방식으로 그래프표현

for i in range(1, comNum + 1):
  insertArr = []
  for j in arr:
    if j[0] == i:
      insertArr.append(j[1])
    elif j[1] == i:
      insertArr.append(j[0])
  # insertArr.sort()
  graph.append(insertArr)

visited = [False] * (comNum + 1)

def dfs(startComNum):
  visited[startComNum] = True
  for i in graph[startComNum]:
    if visited[i] == False:
      dfs(i)
# dfs로 그래프 탐색 시작 (1번 컴퓨터부터)
dfs(1)

cnt = 0
for i in visited:
  if i == True:
    cnt += 1
print(cnt - 1)