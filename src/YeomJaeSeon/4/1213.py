name = input()

nameArr = []
pelindrom = [-1] * len(name);
single = [] # length 가 2이상이면 무조건 X - 여기엔 비교해서 다른값이들어감. 
for i in range(len(name)):
  nameArr.append(name[i])
  
nameArr.sort()

checkFirst = 0
checkSecond = 1
while(checkSecond <= len(nameArr) - 1):
  if nameArr[checkFirst] == nameArr[checkSecond]:
    checkFirst += 2
    checkSecond += 2
  else:
    single.append(nameArr[checkFirst])
    nameArr[checkFirst] = -1
    checkFirst += 1
    checkSecond += 1
# 적절치 못한 값이 두개이상있으면안됨
if len(single) > 1:
  print("I'm Sorry Hansoo")
else:
  if len(single) == 1:
    nameArr.remove(-1)
    nameArr.append(single[0])
  # TREE 같은경우 check를 위함.
  a = 0
  b = 0
  for i in range(len(nameArr)):
    if i % 2 == 1:
      # pelindrom리스트 앞에 추가
      for j in range(len(nameArr)):
        if pelindrom[j] == -1:
          pelindrom[j] = nameArr[i]
          a = j
          break
    else:
      # pelindrom리스트 뒤에 추가
      for j in range(len(nameArr) - 1, -1, -1):
        if pelindrom[j] == -1:
          pelindrom[j] = nameArr[i]
          b = j
          break
  # TREE 같은경우 예외처리.
  if len(nameArr) % 2 == 0 and pelindrom[a] != pelindrom[b]:
    print("I'm Sorry Hansoo")
  else:     
    print(''.join(pelindrom))