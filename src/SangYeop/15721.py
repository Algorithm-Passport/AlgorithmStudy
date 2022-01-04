A = int(input())
T = int(input())
word = int(input())

length = 0
time = 0
array = [0,1,0,1,0,0,1,1]

def changeArray(time):
  global array 
  array = [0,1,0,1]
  array.extend([0]*(time+2))
  array.extend([1]*(time+2))

while True:
  if array.count(word) < T:
    T -= array.count(word)
    length += len(array)
  else:
    for i in range(len(array)):
      if array[i] == word:
        T -= 1
      if T == 0:
        length += i
        break
    break
  time += 1
  changeArray(time)

result = length % A
print(result)

# 여기서 발전시킬 수 있는 것이 배열 다음 배열로 바꿔주는 것을 함수로 만들어서 쓰는 것
# 구조적으로 더 쉬운 방법에 대해서 생각 

# 생각을 보자마자 했어야 하는 것 1.전체 배열을 계속 흘려보내 줘서 그 것까지의 개수를 사람의 숫자로 나누어서 나머지로 답을 내는 것
# 2. 배열을 계속 아름답게 바꿔주는것... 이것은 지금도 안되어 있어
# 3. count를 쓰는 것에 대한 생각, extend를 쓰는 것.