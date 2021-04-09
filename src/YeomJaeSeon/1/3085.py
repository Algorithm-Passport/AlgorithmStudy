N = int(input())
arr = []
for i in range(N):
  arr.append(input())
  
realArr = [[0] * N for i in range(N)]

for i in range(N):
  for j in range(N):
    realArr[i][j] = arr[i][j]


x = [-1, 1, 0, 0]
y = [0, 0, -1, 1]

def checkMax(paramArr):
  max = 1
  # 행 체크
  for i in range(N):
    importNum = paramArr[i][0]
    cnt = 1
    for j in range(1, N):
      if paramArr[i][j] == importNum:
        cnt += 1
      else:
        importNum = paramArr[i][j]
        cnt = 1
      if max < cnt:
        max = cnt

  # 열 체크
  for i in range(N):
    importNum = paramArr[0][i]
    cnt = 1
    for j in range(1, N):
      if paramArr[j][i] == importNum:
        cnt += 1
      else:
        importNum = paramArr[j][i]
        cnt = 1
      if max < cnt:
        max = cnt

  return max

      
def bomboni(i, j, arr):
  max = 1
  for k in range(4):
    if i + x[k] >= N or i + x[k] < 0 or j + y[k] >= N or j + y[k] < 0:
      continue
    if arr[i][j] == arr[i + x[k]][j + y[k]]:
      continue

    tmp = arr[i][j]
    arr[i][j] = arr[i + x[k]][j + y[k]]
    arr[i + x[k]][j + y[k]] = tmp

    if checkMax(arr) > max:
      max = checkMax(arr)
    
    tmp = arr[i][j]
    arr[i][j] = arr[i + x[k]][j + y[k]]
    arr[i + x[k]][j + y[k]] = tmp
  
  return max;


realMax = checkMax(realArr)
for i in range(N):
  for j in range(N):
    if bomboni(i, j, realArr) > realMax:
      realMax = bomboni(i, j, realArr)

print(realMax)
    
