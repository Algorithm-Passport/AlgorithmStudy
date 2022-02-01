n,m = map(int, input().split())
arr = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    arr[b].append(a)
global cnt 
def dfs(i):
  visited = [0 for _ in range(n+1)]
  global cnt 
  if len(arr[i])==0:
    return 1
  if visited[i]==0:
    cnt+=1
    visited[i]=1
    for j in range(len(arr[i])):
      dfs(arr[i][j])
      return cnt
  
max_num = 0
result = []

for i in range(1,n+1):
  cnt = 1
  tmp = dfs(i)
  if max_num == tmp:
    result.append(i)
  if max_num < tmp:
    max_num = tmp
    result = []
    result.append(i)
print(*result)

# 왜 틀리지 ㅠㅠ 모르겟어 ㅠㅠ