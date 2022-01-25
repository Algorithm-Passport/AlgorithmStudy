n = int(input())
arr = list(map(int,input().split()))

d = [0]*1001
for i in arr:
  d[i] = max(d[:i])+1
print(max(d))

# 길이를 어떻게 측정할 것인가. 원래 디피 테이블을 길이로 가져갈 것인가 vs 다 구한 다음에 길이를 구할 것인가.
# 내가 푼거랑 다른 방식으로 많이 풀려있어. 풀이 확인하기
##########
from sys import*
input = stdin.readline

def lower(l,r,x):
    while l<=r:
        m = (l+r)//2
        if v[m] >= x:
            r = m - 1
        else:
            l = m + 1
    return l
n=int(input())
arr=list(map(int,input().split()))
v=[arr[0]]
for i in range(1,n):
    if v[-1] < arr[i]:
        v.append(arr[i])
    else:
        v[lower(0,len(v)-1,arr[i])]=arr[i]

print(len(v))