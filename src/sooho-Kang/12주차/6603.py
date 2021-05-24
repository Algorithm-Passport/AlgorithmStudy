import sys


def getInput():
    arr = []
    while True:
        temp = list(map(int, sys.stdin.readline().split()))
        if temp[0] == 0:
            break
        arr.append([temp[0], temp[1:]])
    return arr


def solution():
    arr = getInput()
    for curA in arr:
        visited = {}
        for j in range(curA[0]):
            visited[curA[1][j]] = False
        ans = []
        dfs(0, curA[1], visited, ans)
        print()


def dfs(cur, arr, visited, ans):
    if len(ans) == 6:
        print(" ".join(map(str, ans)))
    else:
        for i in range(cur, len(arr)):
            if not visited[arr[i]]:
                visited[arr[i]] = True
                ans.append(arr[i])
                dfs(i, arr, visited, ans)
                visited[arr[i]] = False
                ans.pop()


solution()
