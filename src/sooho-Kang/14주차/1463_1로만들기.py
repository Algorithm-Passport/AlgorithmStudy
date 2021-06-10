import sys


def solution():
    n = int(sys.stdin.readline())
    dp = [0 for _ in range(1000001)]
    dp[1] = 0
    dp[2] = 1
    dp[3] = 1
    for i in range(4, len(dp)):
        # 1로 빼는 경우
        dp[i] = dp[i - 1] + 1
        # 2으로 나누는 경우
        if i % 2 == 0 and dp[i] > dp[i // 2] + 1:
            dp[i] = dp[i // 2] + 1
        # 3으로 나누는 경우
        if i % 3 == 0 and dp[i] > dp[i // 3] + 1:
            dp[i] = dp[i // 3] + 1
    return dp[n]


print(solution())
