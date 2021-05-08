import sys

N = int(sys.stdin.readline())
people = []
cnt = [0 for _ in range(N)]

for i in range(N):
    people.append(sys.stdin.readline().rstrip())


def dfs(p,idx):
    if p == idx:
        return 
    target = people[idx] # N 인 사람.
    for i in range(N):
        if target[i] == "Y" and people[i][p] == "Y":
            cnt[p] += 1
            break

for k in range(N):
    for m in range(N):
        if people[k][m]=="N":
            dfs(k, m)
        else:
            cnt[k]+= 1
print(max(cnt))
            
