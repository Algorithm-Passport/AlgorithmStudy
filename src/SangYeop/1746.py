n,m = map(int, input().split())
arr = []
for _ in range(n+m):
  arr.append(input())
listen = set(arr[:n])
see = set(arr[n:])

# for _ in range(n):
#   listen.add(input())
# for _ in range(m):
#   see.add(input())

result = list(listen.intersection(see))
result.sort()
print(len(result))
for i in result:
  print(i)

# --------------------------------------

# import sys
# N, M = map(int, input().split())
# arr = list(sys.stdin.read().rstrip().split())
# hear = set(arr[:N])
# seem = set(arr[N:])
# result = list(hear & seem)

# print(len(result))
# result.sort()
# for i in result:
#   print(i)