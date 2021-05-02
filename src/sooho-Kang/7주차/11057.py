import sys


def solution(n):
    dp = [[0] * (11) for _ in range(1001)]
    for i in range(1, 11):
        dp[1][i] = 1
    for i in range(2, n + 1):
        for j in range(1, 11):
            for k in range(j, 11):
                dp[i][j] += dp[i - 1][k]
    return sum(dp[n]) % 10007


n = int(sys.stdin.readline())
print(solution(n))
