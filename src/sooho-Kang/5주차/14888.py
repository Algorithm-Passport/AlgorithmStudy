import sys


def getInput():
    IC = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))
    arr2 = list(map(int, sys.stdin.readline().split()))
    opr = ["+"] * arr2[0] + ["-"] * arr2[1] + ["*"] * arr2[2] + ["//"] * arr2[3]
    return IC, arr, opr


def operation(s, a, b):
    if s == "+":
        return a + b
    elif s == "-":
        return a - b
    elif s == "*":
        return a * b
    elif s == "//":
        if a < 0:
            return -(-a // b)
        elif b < 0:
            return -(a // -b)
        return a // b


def dfs(n, opr, oprs, ans, visited, arr):
    if len(oprs) == n:
        # 계산
        res = arr[0]
        for i in range(1, len(arr)):
            res = operation(oprs[i - 1], res, arr[i])
        ans[0] = ans[0] if ans[0] > (res) else res
        ans[1] = ans[1] if ans[1] < res else res
    else:
        for i in range(len(opr)):
            if not visited[i]:
                oprs.append(opr[i])
                visited[i] = True
                dfs(n, opr, oprs, ans, visited, arr)
                oprs.pop()
                visited[i] = False


def solution():
    IC, arr, opr = getInput()
    visited = [False] * (IC - 1)
    oprs = []
    # 0인덱스 max, 1 인덱스 min
    ans = [-100000000, 1000000000]
    dfs(IC - 1, opr, oprs, ans, visited, arr)
    sys.stdout.write(str(ans[0]) + "\n")
    sys.stdout.write(str(ans[1]))


solution()