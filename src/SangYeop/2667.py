# n = int(input())
# board = []
# for _ in range(n):
#   board.append(list(map(int,input().strip())))

# def dfs(x,y,k):
#   if x <= -1 or y <= -1 or n <= x or n <= y:
#     return False
#   if board[x][y] == 1:
#     board[x][y] = k
#     dfs(x-1,y,k)
#     dfs(x,y-1,k)
#     dfs(x+1,y,k)
#     dfs(x,y+1,k)
#     return True
#   return False

# result = 0
# k = 2
# dic = dict()

# for i in range(n):
#   for j in range(n):
#     if dfs(i,j,k)==True:
#       result+=1
#       k+=1
# for i in range(2,k):
#   dic[i]=0

# for i in range(n):
#   for j in range(n):
#     for l in range(2,k):
#       if board[i][j]==l:
#         dic[l]+=1

# dic.items()
# d= sorted(dic.items(), key=lambda x: x[1])
# print(result)
# for i in range(len(d)):
#   print(d[i][1])
# --------------------------------------------------
# n = int(input())
# graph = []
# for _ in range(n):
#     graph.append(list(map(int,input())))
 
# grp = []
# cnt = 0
# dx = [-1,1,0,0] # 상하좌우
# dy = [0,0,-1,1]
 
# def dfs(x,y):
#     global cnt #재귀를 쓰는 상황에서 cnt를 계속 가져가야 하기 때문에 전역변수로 두고 하는 것이야
#     if x<0 or x>=n or y<0 or y>=n: # 범위
#         return False
    
#     if graph[x][y]==1:
#         cnt +=1
#         graph[x][y] = 0
#         for i in range(4):
#             dfs(x+dx[i],y+dy[i])
#         return True
    
    
# for i in range(n):
#     for j in range(n):
#         if dfs(i,j)==True:
#             grp.append(cnt)
#             cnt = 0
            
# print(len(grp))
# grp.sort()
# for i in grp:
#     print(i)
# --------------------------------------------------
from collections import deque
n = int(input())
board = []
for _ in range(n):
    board.append(list(map(int,input())))

dx = [-1,1,0,0]
dy = [0,0,-1,1]
cnt = []
q = deque()

def bfs(x,y):
  q.append((x,y))
  board[x][y] = 0
  count=1
  while q:
    x,y = q.popleft()
    
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx and nx < n and 0 <= ny and ny < n and board[nx][ny]==1:
        board[nx][ny] = 0
        q.append((nx,ny))
        count += 1
  return count

for i in range(n):
  for j in range(n):
    if board[i][j]==1:
      cnt.append(bfs(i,j))
print(len(cnt))
cnt.sort()
for i in range(len(cnt)):
  print(cnt[i])