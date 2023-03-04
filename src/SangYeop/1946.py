import sys
input = sys.stdin.readline

T = int(input())
result = []
for _ in range(T):
  N = int(input())
  people = [list(map(int, input().split())) for _ in range(N)]
  
  for _ in range(N):
    resultlist = people[:]
    for i in range(len(people)):
      for j in range(len(people)):
        if people[i][0] > people[j][0] and people[i][1] > people[j][1]:
          if people[i] in resultlist:          
            resultlist.remove(people[i])
          else:
            continue
        elif people[i][0] < people[j][0] and people[i][1] < people[j][1]:
          if people[j] in resultlist:
            resultlist.remove(people[j])
          else:
            continue
        else:
          continue
  print(len(resultlist))
    
  # print(result)
  #되는 코드일 것 같은데 시간초과가 난다. 여기서 어떻게 시간을 단축시킬 것인가
  # 역시 이중반복문이기 때문에 이것을 개선할 수 있겠다. 아니면 브레이크를 잘 걸어서 하는 방법?
  