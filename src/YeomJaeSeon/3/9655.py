N = int(input())

d = [0] * 1001
# 1 : 상근
# 2 : 창영
d[1] = 1
d[2] = 2
d[3] = 1

for i in range(4, N + 1):
  if d[i - 1] == 1:
    d[i] = 2
  elif d[i - 1] == 2:
    d[i] = 1

  if d[i - 3] == 1:
    d[i] = 2
  elif d[i - 3] == 2:
    d[i] = 1

if d[N] == 1:
  print('SK')
else:
  print('CY')

# 바텀업 방식으로 dp테이블에 하나씩 메모이제이션 해가면서 품
# -> 반복문으로.. 