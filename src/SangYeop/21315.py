import itertools

n = int(input())
arr = input().split()
K = []
k = 1

while n >= 2:
  K.append(k)
  k += 1
  n = n/2

arr = list(map(tuple, itertools.permutations(K, 2)))

# arr안에 있는 것들로 카드 뒤집기
def flipCard():
  for k in arr:
    a,b = k

# 수도코드로는 어떻게 하겠는데... 좋은 방법을 코드적으로 모르겠어
