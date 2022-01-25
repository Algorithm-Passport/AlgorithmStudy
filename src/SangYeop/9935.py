a = input()
b = input()

while True:
  result = ''
  i = 0
  while i < len(a):
    if a[i:i+len(b)]==b:
      i = i+len(b)
    else:
      result = result + a[i]
      i += 1
  if b not in result :
    if result == '':
      print('FRULA')
      break
    else:
      break
  a = result
print(result)


# 1. 어떻게 주어진 문자열을 순회할 것인가
# 2. 폭발 문자열을 어떻게 확인해서 없앨 것인가
# 새로운 문자열을 만들어 나가자
# 한번돌았을때는 됫어. 그러면 여러번 돌기를 짜야 해
# 맞긴 맞는데 리스트를 이용해서 하네 사람들은... 왜일까???
