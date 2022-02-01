# from itertools import product
# from collections import deque

# answer = list(map(int,input().split()))
# arr = list(product([1,2,3,4,5], repeat=10))
# new_arr = []
# result = 0
# for i in arr:
#   stack = deque()
#   for j in i:
#     if len(stack)==2 and stack[-1]==j:
#       break
#     if len(stack)==0:
#       stack.append(j)
#     elif stack[-1]!=j:
#       stack.popleft()
#       stack.append(j)
#     elif stack[-1]==j:
#       stack.append(j)
#   else:
#     new_arr.append(i)
# print(new_arr)
# for i in answer:
#   for j in new_arr:
#     cnt = 0
#     for k in j:
#       if k==j:
#         cnt += 1
#       if cnt >= 5:
#         result += 1
#         break

# print(result)

# 너무 숫자가 커져서 안되는 것 같아. 일일이 비교를 하는 것이 아니라 다른 방법이 있는 것 같아


answer = list(map(int,input().split()))
arr = []
cnt = 0

def BT(depth):
  global cnt
  if depth == 10:
    correct = 0
    for i in range(10):
      if arr[i]==answer[i]:
        correct += 1
      if correct>=5:
        cnt+=1
        break
    return ;
  
  for i in range(1,6):
    if depth > 1 and arr[depth-1]==arr[depth-2]== i:
      continue
    arr.append(i)
    BT(depth+1)
    arr.pop()

BT(0)
print(cnt)


