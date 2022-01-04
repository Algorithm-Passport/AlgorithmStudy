from collections import deque

N, M, R = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

def rotate_list(n,m,r):
  q = deque()
  time = min(n,m) // 2
  width, height = m, n
  dx ,dy = 0, 0

  while time >= 1:
    for i in range(width-1):
      q.append(board[dy][dx+i])
    for i in range(height-1):
      q.append(board[dy+i][dx+width-1])
    for i in range(width-1):
      q.append(board[dy+height-1][dx+width-1-i])
    for i in range(height-1):
      q.append(board[dy+height-1-i][dx])

    q.rotate(-r)

    for i in range(width-1):
      board[dy][dx+i] = q.popleft()
    for i in range(height-1):
      board[dy+i][dx+width-1] = q.popleft()
    for i in range(width-1):
      board[dy+height-1][dx+width-1-i] = q.popleft()
    for i in range(height-1):
      board[dy+height-1-i][dx] = q.popleft()

    width -= 2
    height -= 2
    dx += 1
    dy += 1
    time = min(width, height) // 2

rotate_list(N,M,R)

for i in board:
  for j in i:
    print(j, end=' ')
  print()