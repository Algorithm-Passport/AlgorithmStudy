n = int(input())

for _ in range(n):
  m = int(input())
  stickers = []
  for _ in range(2):
    stickers.append(list(map(int,input().split())))
  
  for i in range(1,m):
    if i == 1:
      stickers[0][i] += stickers[1][0]
      stickers[1][i] += stickers[0][0]
    else:
      stickers[0][i] += max(stickers[1][i-1],stickers[1][i-2])
      stickers[1][i] += max(stickers[0][i-1],stickers[0][i-2])
  print(max(stickers[0][m-1], stickers[1][m-1]))

# 실제로 문제를 어떻게 풀고 접근할 것인가를 생각
# 맨날 풀던대로 푼다는 생각을 버리기
