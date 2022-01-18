n, k = map(int, input().split())

# 동전의 종류를 넣는 배열
coin = []
for _ in range(n):
  coin.append(int(input()))

d = [0]*(k+1)
for i in range(n):
  for j in range(coin[i],k+1):
    if j == coin[i]:
      d[j]+=1
      # 힘들엇다 ㅠㅠ 하지만 해냇다 ㅎㅎ
    if d[j-coin[i]]!=0:
      d[j]+= d[j-coin[i]] 

print(d[k])