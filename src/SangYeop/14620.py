# N = int(input())

# array = []
# for i in range(N):
#   array.append(list(map(int, input().split())))

# priceMap = [[0]*(N-2) for _ in range(N-2)]
# isUsed = [[0]*N for _ in range(N)]
# count = 0
# result = 0


# for i in range(1,N-1):
#   for j in range(1,N-1):
#     priceMap[i-1][j-1] = array[i][j] + array[i-1][j] + array[i][j-1] + array[i+1][j] + array[i][j+1]

# # priceMap에서 가장 작은 숫자를 찾는 함수
# def findSmallest():
#   smallest = 1001
#   for i in range(N-2):
#     for j in range(N-2):
#       if smallest > priceMap[i][j]:
#         smallest = priceMap[i][j]
#         global row 
#         global col
#         row = i
#         col = j
#   return [smallest,row,col]



# while count < 3:
#   [smallest,row,col] = findSmallest()
#   # 사용된 적이 있는 땅인지 모두 확인한다. 하나라도 사용했으면 못쓰는 것, 그리고 한번 못쓰는 것이 확인이 되었으면 가장 값이 적은 땅을 찾을때
#   # 다시는 찾지 않도록 가장 큰 숫자를 집어 넣어준다.
#   if isUsed[row+1][col+1]==1 or isUsed[row][col+1]==1 or isUsed[row+1][col]==1 or isUsed[row+2][col+1]==1 or isUsed[row+1][col+2]==1:
#     priceMap[row][col] = 1001
#   else:
#     isUsed[row+1][col+1]=1
#     isUsed[row][col+1]=1
#     isUsed[row+1][col]=1
#     isUsed[row+2][col+1]=1
#     isUsed[row+1][col+2]=1
#     count += 1
#     priceMap[row][col] = 1001
#     result += smallest
#     # print(priceMap)
# print(result)

# 틀렷을 가능성이 많다고 생각했어.
# 일단 보이는대로 짰지만, 문제가 있는 것이 예외처리가 안되어 있어. 가장 작은 값이 중복이 되는 경우에 대한 생각이 부족해. 
# 그런데 이걸 생각하면 너무 복잡해서 못햇어. 더 생각해봐야해 
# 그리고 지금 짠 코드보다 더 간단하고 멋지게 푸는 것도 잇을 것 같아... 
# 예외처리를 할 수 있는 코드를 생각하기 + 새로운 코드 익히기
# 이런 식으로 예외처리 안되. 그렇기 때문에 dfs를 통해 완전 탐색을 해야하는 것이야. 당연히 완전탐색으로 해야해. 이것!!!!!!! 포인트!!!!!!


# 그리고 내가 처음 생각한 것에 대해서 피드백도 받고 싶어
# 남들이 어떻게 푸는지를 확인하고 스스로 피드백 해보자

# 지금 잘 못하는 것. 입력받는것, 배열만드는법, for문 배열의 범위 지정하는 것.  명확히 공부할 것




N = int(input())

array = [list(map(int,input().split()))  for _ in range(N)]
visited = [[False]*N for _ in range(N)]
answer = 9999999
direction = [(0,0),(-1,0),(1,0),(0,1),(0,-1)]

def check(y,x):
  # global N
  for dy, dx in direction:
    ny = y + dy
    nx = x + dx
    if 0 > ny or ny > N-1 or 0 > nx or nx > N-1 or visited[ny][nx] == True:
      return False
  return True

def allSum(y,x):
  # global N
  result = 0
  for dy, dx in direction:
    ny = y + dy
    nx = x + dx
    result += array[ny][nx]
  return result

def dfs(start, cost, cnt):
  global answer
  if cnt == 3:
    answer =  min(answer, cost)
    return 
  
  for i in range(start, N):
    for j in range(1, N):
      if check(i,j):
        visited[i][j] = True
        for dy, dx in direction:
          visited[i+dy][j+dx] = True
        dfs(i, cost + allSum(i,j), cnt+1)
        visited[i][j] = False
        for dy, dx in direction:
          visited[i+dy][j+dx] = False

dfs(1,0,0)
print(answer)