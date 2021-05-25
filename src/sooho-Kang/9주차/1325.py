import sys
from collections import deque


def getInput():
    N, M = map(int, sys.stdin.readline().split())
    arr = [[] for _ in range(N + 1)]
    for _ in range(M):
        a, b = map(int, sys.stdin.readline().split())
        arr[b].append(a)
    return arr, N


def bfs(temp, i, visited, arr):
    temp.append(i)
    visited[i] = True
    queue = deque([i])
    while queue:
        cur = queue.popleft()
        temp.append(cur)
        for j in arr[cur]:
            if not visited[j]:
                visited[j] = True
                queue.append(j)


def dfs(queue, temp, visited, arr):
    for j in queue:
        if not visited[j]:
            visited[j] = True
            temp.append(j)
            dfs(arr[j], temp, visited, arr)


def solution():
    arr, N = getInput()
    ans = []
    maxLen = 0
    for i in range(1, N + 1):
        visited = [False] * (N + 1)
        temp = []
        bfs(temp, i, visited, arr)
        # queue = deque([i])
        # dfs(queue, temp, visited, arr)
        if len(temp) == maxLen:
            ans.append(i)
        elif len(temp) > maxLen:
            ans = [i]
            maxLen = len(temp)
    sys.stdout.write(" ".join(list(map(str, ans))))


solution()