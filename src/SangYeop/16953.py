N, M = map(int, input().split())

# result = 1

# while True:
#   if N > M:
#     result = -1
#     break
#   if N == M:

#     break
#   if M % 2 == 0:
#     M = M // 2
#     result += 1
#   else:
#     if str(M)[len(str(M))-1] == '1':
#       M = M // 10
#       result += 1
#     else:
#       result = -1
#       break

# print(result)

# 처음부터 특정 숫자까지 가서 비교하는 것이 복잡하다고 판단하여 거꾸로 2로 나누거나 일의 자리의 1을 없애는 방식이 더 간단하다고 판단함
# 코드자체는 매우 더러움. 더 좋은 코드로 가야한다. 사람들이 푼 것을 보니깐 그렇게 나쁘진 않네
count = 1

while N < M:
  if M % 2 == 0:
    M = M // 2
  elif M % 10 == 1:
    M = M // 10
  else:
    break
  count += 1

if N == M:
  print(count)
else:
  print(-1)