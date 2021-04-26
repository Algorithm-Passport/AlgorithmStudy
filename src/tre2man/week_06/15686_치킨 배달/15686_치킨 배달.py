from itertools import combinations
from copy import deepcopy


'''
모든 경우의 수에 대하여 판단했다.
조합을 이용하여 지워야 할 치킨집의 순서를 저장하고, 모든 조합의 경우에 대하여 탐색함.
치킨 거리를 알아낼 때 bfs로 탐색할 필요가 없다. (처음에 시간초과로 틀림)
모든 치킨집에 대해 거리를 구한 다음, 최솟값을 도출한다.
'''


N = M = 0
ans = 99999999
locChicken = []
locCheck = []
locHouse = []
arr = []


# 치킨 거리를 구하는 함수.
def checkClength(x, y, checkArr):
    global N, arr, locChicken
    temp = 9999999
    for i in locChicken:
        if checkArr[i[0]][i[1]] == 2:
            temp = min(temp, abs(x - i[0]) + abs(y - i[1]))
    return temp


# 도시의 치킨 거리를 구하는 함수. 치킨 거리를 계속 불러와 최솟값을 저장한다.
def exploreClength():
    global ans, arr, locCheck, locChicken, temp
    for a in locCheck:
        temp = deepcopy(arr)
        for b in a:
            temp[locChicken[b][0]][locChicken[b][1]] = 0
        sumLength = 0
        for i in range(len(temp)):
            for j in range(len(temp[i])):
                if temp[i][j] == 1:
                    sumLength += checkClength(i, j, temp)
        ans = min(ans, sumLength)


# 입력받고 삭제할 치킨집을 저장하는 조합을 생성
def main():
    global N, M, ans, locChicken, locCheck, arr, locHouse
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            # 치킨집의 좌표를 저장한다.
            if arr[i][j] == 2:
                locChicken.append([i, j])
    # 지워야 하는 곳의 좌표 인덱스를 기록한 배열
    locCheck = list(combinations(
        list(range(len(locChicken))), len(locChicken) - M))
    exploreClength()
    print(ans)


main()