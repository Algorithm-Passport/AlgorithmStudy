from itertools import permutations

n, m = map(int,input().split())
result = list(permutations(list(map(int,input().split())),n))
answer = 0
for i in result:
  K = 0
  for j in range(n):
    K = K + i[j] - m
    if K < 0:
      break
  else:
    answer += 1
print(answer)