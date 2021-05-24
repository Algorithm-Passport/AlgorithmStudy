import sys


def getInput():
    IC = int(sys.stdin.readline())
    arr = []
    graph = []
    for _ in range(IC):
        arr.append(list(sys.stdin.readline().strip()))
    for i in range(len(arr)):
        temp = []
        for j in range(len(arr[i])):
            if arr[i][j] == "Y":
                temp.append(j)
        graph.append(temp)
    return IC, graph


def dfs(fGraph, graph, visited, ans, val):
    # 0 2 4
    for i in len(fGraph):
        if val == fGraph[i]:
            ans.add(fGraph[i])
        if not visited[i]:
            visited[i] = True
            dfs(graph[i], graph, visited, ans, val)


def solution():
    IC, graph = getInput()
    ans = [set([]) for _ in range(IC)]
    # 친구인 경우 추가
    for i in range(len(graph)):
        for j in range(len(graph[i])):
            ans[i].add(graph[i][j])
    # 친구의 친구인 경우
    for i in range(len(graph)):
        for j in range(len(graph[i])):
            val = graph[i][j]
            for k in range(len(graph)):
                if i == k:
                    continue
                for l in range(len(graph[k])):
                    if val == graph[k][l]:
                        ans[i].add(k)
    print(len(max(ans, key=lambda k: len(k))))


solution()
