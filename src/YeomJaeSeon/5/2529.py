# 시간초과 + 출력 틀림

import copy
k = int(input())

problem = list(input().split()) # 부등호
cases = [] # 구하고자하는 경우들
tmp = []
nums = [] # 0 ~ 9
for i in range(0, 10):
  nums.append(i)

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


def search(nums, tmp, problem):
  if len(tmp) == len(problem) + 1:
    test = []
    for i in range(0, len(tmp)):
      test.append(tmp[i])
      if i == len(tmp) - 1:
        continue
      test.append(problem[i])
    # 가지치기안하고 한가지의 경우를 모두 검사함. - 당연히시간초과 
    if calculate(test) == False:
      return
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
  result.append(int(i[0]) * 100 + int(i[1]) * 10 + int(i[2]))

if max(result) < 100:
  print('0'+str(max(result)))
else:
  print(max(result))
if min(result) < 100:
  print('0'+str(min(result)))
else:
  print(min(result))

