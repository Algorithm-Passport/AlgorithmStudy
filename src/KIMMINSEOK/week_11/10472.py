import sys, copy
from collections import deque

dx = [0,1,-1,0,0]
dy = [0,0,0,1,-1]

def convert_board(board,x,y):
    ret = copy.deepcopy(board)

    for i in range(5):
        nx, ny = x + dx[i], y + dy[i] # 제자리, 동서남북
        if 0 <= nx < 3 and 0 <= ny < 3:
            ret[nx][ny] = "*" if ret[nx][ny] == "." else "." # 색 반대로
    return ret

def convert_to_binary(board):
    binary_str = '' # 이진수로 인덱싱.

    for x in range(3):
        for y in range(3):
            binary_str += '0' if board[x][y] == '.' else '1'
    return int(binary_str, 2)

def bfs(goal):
    time = 0
    init_board = [['.'] * 3 for _ in range(3)]
    visit = [0]*1000

    q = deque([init_board])
    visit[convert_to_binary(init_board)] = 1

    while q:
        loop = len(q) # 보드의 경우의 수를 전부 넣어두는 듯.
        for _ in range(loop):
            board = q.popleft()
            if board == goal: # 목적 보드판.
                return time

            for row in range(3):
                for col in range(3): # 3X3 보드이므로
                    next_board = convert_board(board, row, col)
                    binary_code = convert_to_binary(next_board)

                    if not visit[binary_code]:
                        q.append(next_board)
                        visit[binary_code] = 1
        time += 1


def solution(testcase):
    time = bfs(testcase)
    return time

T = int(input())
for _ in range(T):
    testcase = [list(sys.stdin.readline().strip()) for _ in range(3)]
    answer = solution(testcase)
    print(answer)
