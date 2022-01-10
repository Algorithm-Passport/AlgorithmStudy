from collections import deque
m,n = map(int,input().split())
board = []
q = deque([])

for i in range(n):
  board.append(list(map(int, input().split())))

  for j in range(m):
    if board[i][j] == 1:
      q.append((i,j))

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs():
  while q:
    x,y = q.popleft()

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < n and 0 <= ny < m and board[nx][ny]==0:
        q.append((nx,ny))
        board[nx][ny] = board[x][y]+1

bfs()
result = 0
for i in board:
  for j in i:
    if j==0:
      print(-1)
      exit(0)
  result = max(result,max(i))
print(result-1)