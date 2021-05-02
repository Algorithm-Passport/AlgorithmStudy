import re

problem = input()

sig = []
result = [] # 결과

for i in range(len(problem)):
  if problem[i] == '+' or problem[i] == '-':
    sig.append(problem[i])

# 정규식으로 split가능.
newArr = re.split('[+-]', problem)

# int로 형변환
changeArr = []
for i in newArr:
  changeArr.append(int(i))

# +끼리는 다 +한 result 배열로 변환
result.append(changeArr[0])
for i in range(1, len(changeArr)):
  if sig[i - 1] == '+':
    result[len(result) - 1] += changeArr[i]
  else:
    result.append(changeArr[i])

# result 첫 원소부터 계쏙해서 빼나가면됨.
sum = result[0]
for i in range(1, len(result)):
  sum -= result[i]
print(sum)