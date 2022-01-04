# import sys
# from collections import deque

# N = int(sys.stdin.readline())
# circles = deque([])

# for _ in range(N):
#   c, r = map(int, input().split())
#   circles.append((c,r))

# def is_meet(cir1,cir2):
#   c1, r1 = cir1
#   c2, r2 = cir2

#   d = c1 - c2 if c1 > c2 or c1 == c2 else c2 - c1
#   difference = r1 - r2 if r1 > r2 or r1 == r2 else r2 - r1

#   if(d < difference or d > r1 + r2 or d == 0):
#     return False
#   return True

# for i in range(N-1):
#   circle1 = circles[i]
#   circle2 = circles[i+1]

#   if is_meet(circle1, circle2):
#     print('NO')
#     break
# else:
#   print('YES')


import sys

N = int(sys.stdin.readline())

for i in range(N):
  centerA, rA = map(int, input().split())
  # centerA = int(circleA[0])
  # rA = int(circleA[1])
  for j in range(i+1,N):
    centerB, rB = map(int, input().split())
    # circleB = input().split()
    # centerB = int(circleB[0])
    # rB = int(circleB[1])

    d = centerA - centerB if centerA > centerB or centerA == centerB else centerB - centerA

    difference = rA - rB if rA > rB or rA == rB else rB - rA

    if(d < difference or d > rA + rB or d == 0):
      continue
    else:
      print('NO')
      break
  else:
    print('YES')


# 이거 맞을 가능성이 높아 보이는데 시간초과