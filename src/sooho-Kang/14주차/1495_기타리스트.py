import sys


def getInput():
    # N: 곡의 갯수
    # S: 시작볼륨
    # M: 볼륨의 최대값
    N, S, M = map(int, sys.stdin.readline().split())
    arr = list(map(int, sys.stdin.readline().split()))
    return S, M, arr


def solution():
    s, m, arr = getInput()
    dp = [[False for _ in range(m + 1)] for _ in range(len(arr) + 1)]
    dp[0][s] = True
    # 3 5 10
    for i in range(len(arr)):
        for j in range(len(dp[i])):
            if dp[i][j] == True:
                if not j + arr[i] > m:
                    dp[i + 1][j + arr[i]] = True
                if not j - arr[i] < 0:
                    dp[i + 1][j - arr[i]] = True
    maxN = -1
    s = len(arr)
    for i in range(len(dp[s])):
        if dp[s][i] == True:
            maxN = i
    print(maxN)


solution()
