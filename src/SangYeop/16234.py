from collections import deque
import math
n, l, r = map(int, input().split())
country = []
for i in range(n):
    country.append(list(map(int,input().split())))

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(i,j):
  q = deque()
  q.append((i,j))
  visited[i][j] = True
  arr = [(i,j)]
  population = country[i][j]

  while q:
    x, y = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or ny < 0 or nx >= n or ny >= n:
        continue
      if visited[nx][ny]:
        continue
      if l <= abs(country[nx][ny]-country[x][y]) <= r:
        arr.append((nx,ny))
        visited[nx][ny] = True
        q.append((nx,ny))
        population += country[nx][ny]
  for x,y in arr:
    country[x][y] = math.floor(population/len(arr))
  
  return len(arr)

day = 0
while True:
  visited = [[False]*n for _ in range(n)]
  isTrue = False

  for i in range(n):
    for j in range(n):
      if not visited[i][j]:
        if bfs(i,j) > 1:
          isTrue = True
  if not isTrue:
    break
  day += 1

print(day)

