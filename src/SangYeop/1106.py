c,n = map(int,input().split())
arr = []
for _ in range(n):
    arr.append(list(map(int,input().split())))
d = [10**10] * (1101)
d[0] = 0
for i in range(n):
    cost, cust = arr[i]
    for j in range(cust,1101):
        d[j] = min(d[j-cust] + cost,d[j])
print(min(d[c:]))