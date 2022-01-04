# 일단 각 자판의 좌표가 필요해
# 그 다음은 거리를 구할때, 1. 가까운것을 조사하고 2. 가까운 손가락이 이동을 한 다음 그 위치를 업데이트를 해야지만이 가능하다.

l , r = map(str, input().split())
word = [input().split()]
keyboard = {'z':(0,0),'x':(1,0)}

left = l
right = r
second = len(word)

def checkDistance(a,b):
  (x1,y1) = keyboard[a]
  (x2,y2) = keyboard[b]
  
  return abs(x1-x2)+abs(y1-y2)


for i in word:
  if checkDistance(left, i) >= checkDistance(right, i):
    second += checkDistance(right, i)
    right = 'i'
  else:
    second += checkDistance(left, i)
    left = 'i'

print(second)
# checkDistance(left,right)



# for i in word:
#   if checkDistance(left, i) >= checkDistance(right, i):
#     second += checkDistance(right,i)
#     right = i
#   else: 
#     second += checkDistance(left, i)
#     left = i

# print(second)

# 대입을 하는 형태의 문제 해결하면 쉽게 해결할 수 있어 보인다. 