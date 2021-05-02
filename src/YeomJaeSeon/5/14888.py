import copy
from itertools import permutations

N = int(input())
numbers = list(map(int, input().split()))

nums = [] # **
for i in range(len(numbers)):
  nums.append(numbers[i])
  if i == len(numbers) - 1:
    break
  nums.append(-1)

inputOps = list(map(int, input().split()))
operators = [] # **

for i in range(len(inputOps)):
  if inputOps[i] != 0:
    for j in range(inputOps[i]):
      operators.append(i)

cases = []

def calculate(inputTmp):
  newNums = copy.deepcopy(nums)
  for i in range(len(inputTmp)):
    newNums[i * 2 + 1] = inputTmp[i]
  sum = int(newNums[0])
  for i in range(1, len(newNums) - 1):
    if i % 2 == 1:
      if int(newNums[i]) == 0: # +
        sum = sum + int(newNums[i + 1])
      elif int(newNums[i]) == 1: # -
        sum = sum - int(newNums[i + 1])
      elif int(newNums[i]) == 2: # *
        sum = sum * int(newNums[i + 1])
      elif int(newNums[i]) == 3: # //
        if sum < 0:
          sum *= -1
          sum = sum // int(newNums[i + 1])
          sum *= -1
        else:
          sum = sum // int(newNums[i + 1])
  return sum

for i in set(permutations(operators, N - 1)):
  cases.append(calculate(i))

print(max(cases))
print(min(cases))

# set(permutations) - 중복 순열이용. 
# max, min 가지치기할방법이 없음 다 계싼해봐야함. 단지 전처럼순열말고 중복순열로
# 품. 다른풀이보니 dfs로풀어도된다고함.