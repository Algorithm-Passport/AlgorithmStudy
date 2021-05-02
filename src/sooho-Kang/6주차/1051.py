import sys


def getInput():
    n, m = map(int, sys.stdin.readline().split())
    board = []
    for _ in range(n):
        strs = list(map(str, sys.stdin.readline().strip()))
        board.append(list(map(int, strs)))
    return n, m, board


def solution():
    n, m, board = getInput()
    maxnum = 1
    for i in range(n):
        for j in range(m):
            # 현재 보드값
            cur = board[i][j]
            for k in range(j, m):
                # 1 2
                # 3 4
                # 1 번이 현재위치라 가정할때
                # 2번검사
                if cur == board[i][k]:
                    sub = k - j
                    # 3번검사
                    if n > i + sub and board[i + sub][j] == cur:
                        # 4번검사
                        if board[i + sub][k] == cur:
                            if maxnum < sub + 1:
                                maxnum = sub + 1
    print(maxnum * maxnum)


solution()
