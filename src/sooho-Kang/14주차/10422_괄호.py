import sys, math


input = sys.stdin.readline


def getInput():
    IC = int(input())
    arr = []
    for _ in range(IC):
        arr.append(int(input()))
    return arr


def solution():
    arr = getInput()
    dp = [0] * 5001
    dp[0] = 1
    dp[2] = 1
    dp[4] = 2
    for i in range(5, 5001):
        if i % 2 == 0:
            dp[i] = dp[i - 2]
            for j in range(2, i, 2):
                dp[i] += dp[i - j] * dp[j - 2]
            dp[i] %= 1000000007
    for i in arr:
        print(dp[i])


solution()
