N = input()

totalArr = []
arr = ''
for i in range(len(N)):
  if N[i] != ':':
    arr += N[i]
  # :를만나면
  else:
    totalArr.append(arr)
    arr = ''
    totalArr.append(N[i])
totalArr.append(arr)
# totalArr 은 입력되는 문자열 split함.

cnt = 0
for i in totalArr:
  if i != '' and i != ':':
    cnt += 1

cnt = 8 - cnt
# cnt는 추가로 들어가야할 숫자의 갯수. 1::라면 cnt = 7임
# 1::1이라면 cnt = 6이고

# ::이 없으면
if cnt == 0:
  result = ''
  for i in range(len(totalArr)):
    if totalArr[i] != ':' and len(totalArr[i]) < 4:
      totalArr[i] = '0' * (4 - len(totalArr[i])) + totalArr[i]
    if totalArr[i] != '': result += totalArr[i]
# ::이 하나라도 있으면
else:
  result = ''
  for i in range(len(totalArr)):
    if totalArr[i] != ':' and totalArr[i] != '' and len(totalArr[i]) < 4:
      totalArr[i] = '0' * (4 - len(totalArr[i])) + totalArr[i]
    if totalArr[i] != '': result += totalArr[i]
  
  # ::의 위치에 따라서 0000: 이녀석의 모양이변경됨. 
  checkPoint = 3
  if result[0] == ':' and result[1] == ':':
    checkPoint = 1 # ::가 맨앞
  elif result[-1] == ':' and result[-2] == ':':
    checkPoint = 2 # ::가 맨뒤
  
  # result가 ::이면.. 모두 0임.
  if result == '::':
    sum = '0000:' * (cnt - 1) + '0000'
  # 1::, ::1, 1::1 같은 경우 ::의 위치마다 다르게 문자열을 수정함
  else:
    if checkPoint == 1:
      sum = '0000:' * cnt
    elif checkPoint == 2:
      sum = ':0000' * cnt
    else:
      sum = ':' + '0000:' * cnt
  # ::와 sum을 변경 replace메서드를 통해서, 1은 횟수임(변경하는 횟수) - 당연히 한번
  result = result.replace('::', sum, 1)

print(result)