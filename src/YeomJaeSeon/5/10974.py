import sys
import copy

sys.setrecursionlimit(3000)

N = int(input())

answer = []
cases = []
tmp = []

# 시작 수열
for i in range(1, N + 1):
  answer.append(i)

def dfs(answer, tmp, cases):
  if len(tmp) == N:
    newTmp = copy.deepcopy(tmp)
    cases.append(newTmp)
    return
  for i in answer:
    if i in tmp:
      continue
    tmp.append(i)
    dfs(answer, tmp, cases)
    tmp.pop()

dfs(answer, tmp, cases)
# print("완료")
for i in cases:
  for j in i:
    print(j, end=' ')
  print()