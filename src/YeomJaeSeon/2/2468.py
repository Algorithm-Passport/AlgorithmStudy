# dfs - 깊이우선탐색
import copy
import sys
sys.setrecursionlimit(30000)
N = int(input())

graph = []
for _ in range(N):
  inputList = list(map(int, input().split()))
  graph.append(inputList)

# 비가 1부터 99까지올경우를 다계산한다음 최대값을 구해야함.
# 최초값은 1로설정. 비가 안올땐 안전영역개수는 1개

def dfs(x, y, graph):
  # 인덱스 범위벗어나면 False
  if x < 0 or x >= N or y < 0 or y >= N:
    return False

  if graph[x][y] == 1:
    # 방문처리. 
    graph[x][y] = 0
    # 재귀함수로 DFS구현
    dfs(x - 1, y, graph)
    dfs(x + 1, y, graph)
    dfs(x, y - 1, graph)
    dfs(x, y + 1, graph)
    
    # 안전영역이면 True를 리턴.
    return True

  return False
# 1부터 99까지 비가온다.
safetyAreaCnt = 1 # 최초값. 비안올땐 안전영역 한개
for i in range(1, 100):
  testGraph = copy.deepcopy(graph)

  # 도시 1 0 으로초기화 - 1은 비에안잠김 0은 비에잠김
  for x in range(N):
    for y in range(N):
      if testGraph[x][y] > i:
        testGraph[x][y] = 1
      elif testGraph[x][y] <= i:
        testGraph[x][y] = 0
  
  cnt = 0
  for x in range(N):
    for y in range(N):
      if dfs(x, y, testGraph) == True:
        cnt +=1
  if cnt == 0:
    break
  if cnt > safetyAreaCnt:
    safetyAreaCnt = cnt
  
  
print(safetyAreaCnt)

      
