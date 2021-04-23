import copy
import math

k = int(input())

problem = list(input().split()) # 부등호
cases = [] # 구하고자하는 경우들
tmp = []
nums = [] # 0 ~ 9
for i in range(0, 10):
  nums.append(i)

# 수식이있는 test리스트가 적절한지 검사하는 리스트
def calculate(test):
  tmp = []
  for i in test:
    if len(tmp) == 3:
      if tmp[1] == '<':
        if not tmp[0] < tmp[2]:
          return False
      if tmp[1] == '>':
        if not tmp[0] > tmp[2]:
          return False
      tmp = [tmp[2]]
    tmp.append(i)
  if len(tmp) == 3:
    if tmp[1] == '<':
      if not tmp[0] < tmp[2]:
        return False
    if tmp[1] == '>':
      if not tmp[0] > tmp[2]:
        return False
  
  return True

# 정답을 찾는 함수 (cases에 적절한 경우를 넣는 함수)
def search(nums, tmp, problem):
  if len(tmp) >= 3:
    test = []
    # test할 수식 들어간 리스트만들기
    for i in range(0, len(tmp)):
      test.append(tmp[i])
      if i == len(tmp) - 1:
        continue
      test.append(problem[i])
    # 적절한지 검사
    if calculate(test) == False:
      return
    if len(tmp) == len(problem) + 1:
      newTmp = copy.deepcopy(tmp)
      cases.append(newTmp)
      return

  for i in nums:
    if i in tmp:
      continue
    tmp.append(i)
    search(nums, tmp, problem)
    tmp.pop()

search(nums, tmp, problem)

result = []

for i in cases:
  sum = 0
  for j in range(k + 1):
    sum += int((int(i[j]) * math.pow(10, k - j)))
  result.append(sum)

maxValue = max(result)
minValue = min(result)

resultMax = max(result)
resultMin = min(result)

maxCnt = 0
while maxValue > 0:
  maxValue //= 10
  maxCnt += 1

minCnt = 0
while minValue > 0:
  minValue //= 10
  minCnt += 1
# maxCnt, minCnt 는 자리수를 구한것


if maxCnt < k + 1:
  print('0' * (k + 1 - maxCnt) + str(resultMax))
else:
  print(resultMax)
if minCnt < k + 1:
  print('0' * (k + 1 - minCnt) + str(resultMin))
else:
  print(resultMin)

# search메서드에서 모든 수식을 다 넣고 하나씩 검사하는것 보단 들어오는 값들을 먼저 계산해서 적절하지않으면 가지치기하는 형식으로품
# 1. 시간초과 : 수식을 다넣고 검사했음 - 가지치기 X
# 2. 틀림 : 출력을 잘못함
