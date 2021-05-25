count = 0


def solution(n):
    board = [0]
    visited = [False] * (n + 1)
    queen(n, board, visited)
    print(count)


def check(board, x):
    # 대각검사만 하면댐 보드사이즈가 다채워졌을때 검사함
    for i in range(1, len(board)):
        if abs(i - len(board)) == abs(board[i] - x):
            return False
    return True


def queen(n, board, visited):
    global count
    if len(board) == n + 1:
        count += 1
        # print(board)
    # 검사
    else:
        for i in range(1, n + 1):
            if not visited[i]:
                if not check(board, i):
                    continue
                board.append(i)
                visited[i] = True
                queen(n, board, visited)
                visited[i] = False
                board.pop()


solution(int(input()))
# pypy만 통과... n==14 일때 걸린다 python으로 통과하는 방법 찾아보자
