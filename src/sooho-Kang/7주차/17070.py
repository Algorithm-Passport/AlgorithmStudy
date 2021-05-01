import sys


def getInput():
    IC = int(sys.stdin.readline())
    arr = []
    for _ in range(IC):
        arr.append(list(map(int, sys.stdin.readline().split())))
    return IC, arr


def printer(dp):
    for i in dp:
        for j in i:
            print(j, end=" ")
        print()


def solution():
    IC, arr = getInput()
    # if 가로 = 가로 대각
    # if 세로 = 대각 세로
    # if 대각 = 가로 대각 세로
    # 3차원배열인데 IC*IC크기안에 각각의 방향(가,세,대)모양으로 갈수있는 타일의 개수를 저장하는 배열담음
    dp = [[[0 for _ in range(3)] for _ in range(IC)] for _ in range(IC)]
    for i in range(1, len(arr)):
        if arr[0][i] == 1:
            break
        dp[0][i][0] = 1
    # 행
    for i in range(1, len(arr)):
        # 열
        for j in range(1, len(arr[i])):
            # 가로, 오려는 위치에 벽이 없으면 움직일 수 있음
            if arr[i][j] != 1:
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]
            # 세로, 오려는 위치에 벽이 없으면 움직일 수 있음
            if arr[i][j] != 1:
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]
            # 대각, 오려는 위치+위치 바로위, 위치 바로전에 벽없으면 움직일 수 있음
            if arr[i][j] != 1 and arr[i - 1][j] != 1 and arr[i][j - 1] != 1:
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]
    # printer(dp)
    return sum(dp[IC - 1][IC - 1])


print(solution())

