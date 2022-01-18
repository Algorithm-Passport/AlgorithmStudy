from collections import deque
n,m  = map(int,input().split())
board = []
for _ in range(n):
  board.append(list(map(int,input().split())))

dx = [-1,1,0,0]
dy = [0,0,-1,1]
q = deque()
result = []

def bfs(x,y):
  q.append((x,y))
  board[x][y] = 0
  cnt = 1
  while q:
    x,y = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx and nx < n and 0 <= ny and ny < m and board[nx][ny]==1:
        cnt += 1
        board[nx][ny] = 0
        q.append((nx,ny))
  return cnt

# if n==1 and m==1:
#   result.append(board[0])
# else:
#   for i in range(n):
#     for j in range(m):
#       if board[i][j]==1:
#         result.append(bfs(i,j))
for i in range(n):
  for j in range(m):
    if board[i][j]==1:
      result.append(bfs(i,j))

if(len(result)==0):
  print(len(result)) 
  print(0)
else: 
  print(len(result)) 
  print(max(result))
# 예외처리