import sys


def getInput():
    H, W = map(int, sys.stdin.readline().split())
    arr = [[0 for _ in range(W)] for _ in range(H)]
    k = list(map(int, sys.stdin.readline().split()))
    for i in range(W):
        for j in range(k[i]):
            arr[j + (H - k[i])][i] = 1
    return H, W, arr


def printer(arr):
    print()
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            print(arr[i][j], end=" ")
        print()


# 1 밑에서 부터 올라감 ,왼쪽에서부터 오른쪽으로
# 2 맨 왼쪽 1부터 그 다음 1이 나올때까지 사이의 0을 세어준다
def solution():
    H, W, arr = getInput()
    totalCount = 0
    for i in range(H - 1, -1, -1):
        temp = 0
        # 벽의 시작과 끝을 표시하는 플래그 1이면 벽사이 0이면 벽 바깥
        blockFlag = 0
        for j in range(W):
            # 시작 벽을 만난 경우
            if arr[i][j] == 1 and blockFlag == 0:
                # 벽만난거 표시
                blockFlag = 1
            # 끝나는 벽을 만난 경우
            elif arr[i][j] == 1 and blockFlag == 1:
                totalCount += temp
                temp = 0
            elif blockFlag == 1:
                temp += 1
    print(totalCount)


solution()
