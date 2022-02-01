from itertools import product

n,m = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
result = list(product(arr, repeat=m))
result = sorted(list(set(result)))

for i in result:
  print(*i)
# for i in list(map(' '.join, product(arr, repeat = m))):
#   result.add(i)

# a= sorted(list(result))

# for i in a:
#   print(i)
# print(list(map(' '.join, permutations(arr, m))))
# for i in permutations([1,1,3,4], 2):
#     print(i, end=" ")
# int 배열 받는거 이따가 다시해보기