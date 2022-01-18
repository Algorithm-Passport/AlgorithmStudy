# from itertools import combinations

# n = int(input())

# for _ in range(n):
#   a,b = map(int, input().split())
#   if a >= b:
#     print(len(list(combinations(range(1,a+1),b))))
#   else:
#     print(len(list(combinations(range(1,b+1),a))))
# 메모리 초과

def fac(x):
  if x <= 1:
    return 1
  else:
    return x*fac(x-1)

n = int(input())

for _ in range(n):
  a,b = map(int, input().split())
  if a >=b:
    print((fac(a)//fac(b))//fac(a-b))
  else:
    print((fac(b)//fac(a))//fac(b-a))