from collections import deque

n,m  = map(int,input().split())
miro = []
for _ in range(n):
  miro.append(list(map(int,input().split())))

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs():
  q = deque()
  q.append((0,0))

  while q:
    x,y = q.popleft()

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < n and 0 <= ny < m and miro[nx][ny]==1:
        q.append((nx,ny))
        miro[nx][ny] = miro[x][y] + 1
        if nx==n-1 and ny == m-1:
          print(miro[nx][ny])
          break

bfs()
# 변수를 만들어주고 while문 안에 조건문을 추가해서 break를 걸어주는 것이 가장 일반적인 듯 보이는데...