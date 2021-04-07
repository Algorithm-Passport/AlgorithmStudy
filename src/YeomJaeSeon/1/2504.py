problem = input()
origin = []
for i in range(len(problem)):
  origin.append(problem[len(problem) - i - 1])

stackArr = []

def isInt(value):
  try:
    int(value)
    return True 
  except ValueError:
    return False

while len(origin) > 0:
  if len(stackArr) == 0:
    stackArr.append(origin.pop())
  else:
    # stackArr에서 정수가 붙어있는경우
    # if (stackArr[len(stackArr) - 1] == ')' and origin[len(origin) - 1] == '(') or (stackArr[len(stackArr) - 1] == '(' and origin[len(origin) - 1] == ')'):
    if isInt(stackArr[len(stackArr) - 1]) == True and isInt(stackArr[len(stackArr) - 2]) == True and len(stackArr) >= 2:
      sumValue = int(stackArr.pop()) + int(stackArr.pop())
      stackArr.append(str(sumValue))
      continue
    # stackArr peek와 origin peek가 정수인경우
    if isInt(stackArr[len(stackArr) - 1]) == True and isInt(origin[len(origin) - 1]) == True:
      sumValue = int(origin.pop()) + int(stackArr.pop())
      stackArr.append(str(sumValue))
      continue

    if stackArr[len(stackArr) - 1] == '(' and origin[len(origin) - 1] == ')':      
      stackArr.pop()
      stackArr.append('2')
      origin.pop()
      continue
    elif stackArr[len(stackArr) - 2] == '(' and origin[len(origin) - 1] == ')' and isInt(stackArr[len(stackArr) - 1]) == True:
      newValue = int(stackArr.pop()) * 2
      stackArr.pop()        
      stackArr.append(str(newValue)) 
      origin.pop()
      continue
    # elif (stackArr[len(stackArr) - 1] == ']' and origin[len(origin) - 1] == '[') or (stackArr[len(stackArr) - 1] == ']' and origin[len(origin) - 1] == '['):
    
    if stackArr[len(stackArr) - 1] == '[' and origin[len(origin) - 1] == ']':      
      stackArr.pop()
      stackArr.append('3')
      origin.pop()
      continue
    elif stackArr[len(stackArr) - 2] == '[' and origin[len(origin) - 1] == ']' and isInt(stackArr[len(stackArr) - 1]) == True:
      newValue = int(stackArr.pop()) * 3
      stackArr.pop()
      stackArr.append(str(newValue))
      origin.pop()
      continue

    stackArr.append(origin.pop())

flag = True
sum = 0
for i in range(len(stackArr)):
  if isInt(stackArr[i]) == False:
    flag = False
  else:
    sum += int(stackArr[i])
if flag == True:
  print(sum)
else:
  print(0)
  

# if len(stackArr) == 1:
#   if isInt(stackArr[])
# if isInt(stackArr[0]) == False or isInt(stackArr[1]) == False:
#   print(0)
# else:  
#   print("결과 : ", int(stackArr[0]) + int(stackArr[1]))
# for i in range(len(stackArr)):
#   origin.append(stackArr[len(stackArr) - i - 1])
# stack = []

# (()[]) - 10
# (((()))) - 16
# ( - 0
