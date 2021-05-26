import sys

#TODO:코드 개같이짬 ㅠ 나중에 다시해보자 
cnt = 9


def solution():
    IC = int(sys.stdin.readline())
    dic = {
        1: [1, 2, 4],
        2: [1, 2, 3, 5],
        3: [2, 3, 6],
        4: [1, 4, 5, 7],
        5: [2, 4, 5, 6, 8],
        6: [3, 5, 6, 9],
        7: [4, 7, 8],
        8: [5, 7, 8, 9],
        9: [6, 8, 9],
    }
    arr = []
    for _ in range(IC):
        strs = " "
        for _ in range(3):
            strs += sys.stdin.readline().strip()
        board = list(strs)
        for i in range(len(board)):
            if board[i] == "*":
                board[i] = 1
            elif board[i] == ".":
                board[i] = 0
            else:
                board[i] = None
        arr.append(board)
    # DO
    for j in arr:
        global cnt
        cnt = 9
        ans = []
        visited = [False] * 10
        pure = [0 for _ in range(10)]
        pure[0] = None
        dfs(0, [1, 2, 3, 4, 5, 6, 7, 8, 9], visited, ans, dic, pure, j)
        print(cnt)


def check(checker, ans):
    for i in range(1, len(ans)):
        if checker[i] != ans[i]:
            return False
    return True


def printer(arr):
    for i in range(1, 10):
        print(arr[i], end=" ")
        if i % 3 == 0:
            print()


def dfs(cur, arr, visited, ans, dic, pure, checker):
    global cnt
    pure = [0 for _ in range(10)]
    for i in ans:
        for j in dic[i]:
            if pure[j] == 1:
                pure[j] = 0
            elif pure[j] == 0:
                pure[j] = 1
    if check(checker, pure):
        if cnt > len(ans):
            cnt = len(ans)

    for i in range(cur, len(arr)):
        if not visited[i]:
            visited[i] = True
            ans.append(arr[i])
            dfs(i, arr, visited, ans, dic, pure, checker)
            visited[i] = False
            ans.pop()


solution()
