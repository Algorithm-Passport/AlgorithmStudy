import sys

input = sys.stdin.readline

# N 입력
N = int(input())

# 친구들 관계 트리
tree = [[] for _ in range(N+1)]

for i in range(N-1):
    u,v = [int(i) for i in input().split()]
    tree[u].append(v)
    tree[v].append(u)

ea = set() # 얼리어답터
visited = set() # 방문기록

def dfs(s):
    global tree, ea, visited
    current = tree[s]
    visited.add(s) # 이미 고려된 사람.

    if len(current) <= 1: # 단말노드인 경우
        return True
    
    for i in current:
        if not i in visited: # 고려 안된 노드이면
            if dfs(i): # 단말노드면 그 부모는 무조건 더해져야함.
                ea.add(s)
            elif not i in ea: # 자식중 얼리어답터인 자식이 존재하면, 부모가 얼리어답터인 편이 효율적.
                ea.add(s)
    return False

# 단말노드에서 시작하면 시작하자마자 True 뱉고 끝남.
for i, m in enumerate(tree):
    if len(m) > 1:
        dfs(i)
        break

# 다 단말노드면?
if N == 2:
    print(1)
else:
    print(len(ea))
