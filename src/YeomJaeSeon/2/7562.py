# 가중치없는 최단거리 -> BFS 너비우선탐색 -> 큐
from collections import deque

TestCase = int(input())

# 나이트가 움직일수 있는 8경우의수.
dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [1, 2, 2, 1, -1, -2, -2, -1]

for _ in range(TestCase):
  I = int(input())
  currentPos = list(map(int, input().split()))
  targetX, targetY = map(int, input().split())

  result = 0
  # 시작과 목표 위치가 같으면
  if targetX == currentPos[0] and targetY == currentPos[1]:
    print(result)
    continue

  graph = [[0] * I for _ in range(I)] # 리스트컴프레헨션으로 2차원배열초기화

  # bfs
  queue = deque()
  queue.append(currentPos)
  
  flag = True # out while loop break하기위한 flag변수
  while queue:
    if flag == False:
      break
    [x, y] = queue.popleft()

    for i in range(8):
      nextX = x + dx[i]
      nextY = y + dy[i]
      if nextX < 0 or nextX >= I or nextY < 0 or nextY >= I:
        continue
      if graph[nextX][nextY] > 0:
        continue
      graph[nextX][nextY] = graph[x][y] + 1 # 이전에서 온 곳에서  +1을해줌.
      if nextX == targetX and nextY == targetY:
        result = graph[targetX][targetY]
        flag = False
        break
      queue.append([nextX, nextY])

  print(result)