import sys, time
from itertools import chain, combinations, compress


N,K = [int(i) for i in sys.stdin.readline().split()]

K -= 5 # 고정 a,n,t,i,c

data = []
m    = 0 # 최종답

for i in range(N):
    data.append([str(i) for i in sys.stdin.readline().rstrip()[4:-4] if i not in ['a','n','t','i','c']])

def solve(arr):
    t  = True
    cnt = 0
    global m
    tmp = ''.join(chain(*arr)) # 배운 단어.
    for d in data:
        for k in d:
            try:
                tmp.index(k)
            except:
                t = False
                break
        if t == True:
            cnt += 1
        t = True
    m = max(m,cnt)
            

word_set = set(chain(*data))
m = 0

if K >= 0:
    if len(word_set) != 0:
        c = combinations(word_set, min(K, len(word_set)))
        
        for e in c:
            solve(list(e))
        print(m)
    else:
        print(N)
else:
    print(0)

