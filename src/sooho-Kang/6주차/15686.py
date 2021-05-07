import sys

distance = sys.maxsize


def getInput():
    N, M = map(int, sys.stdin.readline().split())
    board = []
    chickens = []
    houses = []
    for _ in range(N):
        board.append(list(map(int, sys.stdin.readline().split())))
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == 1:
                # 집배열에 담음
                houses.append([j, i])
            elif board[i][j] == 2:
                # 치킨집 배열에 담음
                chickens.append([j, i])
    return M, houses, chickens


def getD(x1, y1, x2, y2):
    return abs(x2 - x1) + abs(y2 - y1)


def getDistances(bhc, houses):
    count = 0
    for i in range(len(houses)):
        arr = []
        hx = houses[i][0]
        hy = houses[i][1]
        # 집에서 각각 치킨집까지의 거리 계산후 arr 배열에 담음
        for j in range(len(bhc)):
            bx = bhc[j][0]
            by = bhc[j][1]
            arr.append(getD(hx, hy, bx, by))
        # arr배열에서 최소값 계산
        count += min(arr)
    return count


def dfs(visited, bhc, chickens, M, cur, houses):
    global distance
    if len(bhc) == M:
        # 치킨거리 계산
        dist = getDistances(bhc, houses)
        # 치킨거리가 제일 짧을때가 답임으로 모든 경우에 대해
        # distance가 가장 짧을때를 구함
        if distance > dist:
            distance = dist
    else:
        # dfs탐색을 통해 조합 구함
        for i in range(cur, len(chickens)):
            if not visited[i]:
                bhc.append(chickens[i])
                visited[i] = True
                dfs(visited, bhc, chickens, M, i, houses)
                bhc.pop()
                visited[i] = False


def solution():
    global distance
    M, houses, chickens = getInput()
    visited = [False] * len(chickens)
    # df로 m만큼 선택받은 치킨집들
    bhc = []
    # dfs돌려서 모든 치킨집의 경우를 계산해보자
    dfs(visited, bhc, chickens, M, 0, houses)
    return distance


print(solution())
