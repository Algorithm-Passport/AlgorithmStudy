# import sys
# input = sys.stdin.readline()

n,m = map(int,input().split())
square = [list(map(int, input())) for _ in range(n)]
cnt = 1
for i in range(n):
  for j in range(1,m):
    for k in range(j,m):
      if square[i][j]==square[i][k]:
        cnt += 1
      else:
        cnt = 1
