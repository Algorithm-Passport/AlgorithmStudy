import sys
input = sys.stdin.readline

N = int(input(). rstrip())

dic = dict()

for _ in range(N):
  files = input().rstrip()
  extention = files.split('.')[-1]
  if extention not in dic:
    dic[extention] = 1
  else:
    dic[extention] += 1

result = list(dic.keys())
result.sort()
for name in result:
  print(name, dic[name])

# 오래걸린다... 어떤 부분이 오래걸리는가...


############
import sys
input = sys.stdin.readline

N = int(input(). rstrip())
F_E = dict()
for _ in range(N):
    files = input().rstrip()
    extension = files.split('.')[1]
    F_E[extension] = F_E.get(extension, 0) + 1

for k in sorted(F_E.keys()):
    print(k, F_E[k])

##########첫풀이 오래걸리는 것/받는 시간이 오래걸려서 그런가???
n = int(input())
arr = []
for _ in range(n):
  arr.append(input())

dic = dict()

for file in arr:
  name = file.split('.')
  extention = name[-1]
  if extention not in dic:
    dic[extention] = 1
  else:
    dic[extention] += 1

result = dict(sorted(dic.items()))

for key,value in result.items():
  print(key, value)