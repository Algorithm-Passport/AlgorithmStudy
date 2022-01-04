import itertools

n = int(input())
test = [list(map(int,input().split()))  for _ in range(n)]

num = ['1','2','3','4','5','6','7','8','9']
allNum = list(map(''.join, itertools.permutations(num,3)))

for i in test:
  testNum, s, b = i
  testNum = str(testNum)
  r_cnt = 0
  for j in range(len(allNum)):
    j -= r_cnt
    s_cnt = 0
    b_cnt = 0
    for i in range(3):
      if testNum[i] in allNum[j]:
        if testNum[i] == allNum[j][i]:
          s_cnt+=1
        else:
          b_cnt+=1
    if s != s_cnt or b != b_cnt:
      allNum.remove(allNum[j])
      r_cnt+=1
print(len(allNum))

# 1. 전체를 돌아가면서 일일이 스트라이크랑 볼을 확인한다는 컨셉을 떠올리기
# 2. 배열에서 제거한 숫자를 제거하더라도 반복문을 계속 돌릴 수 있는 스킬
