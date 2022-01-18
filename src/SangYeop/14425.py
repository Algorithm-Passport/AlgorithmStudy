from sys import stdin
n,m = map(int,stdin.readline().split())
words = set()
check = set()
for _ in range(n):
  words.add(stdin.readline())
for _ in range(m):
  check.add(stdin.readline())
cnt = 0
for word in check:
  if word in words:
    cnt += 1
print(cnt)