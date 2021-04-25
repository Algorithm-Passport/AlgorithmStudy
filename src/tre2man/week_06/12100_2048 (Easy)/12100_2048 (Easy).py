import sys
from copy import deepcopy


'''
위 아래 우측 좌측으로 판을 움직일 수 있는 함수를 제작한다.
bfs 이용해 모든 경우의 수에 대하여 탐색할 수 있게 했다.

각 이동 함수에 대한 알고리즘
1. 한 줄을 기준으로 0을 제일 뒤쪽으로 다 뺀다. (숫자를 분리, 원본 0으로 치환, 원본에 순서대로 분리한 숫자 대입)
2. 탐색 기준 칸과 뒤의 숫자가 같으면 탐색 칸*2 하고 뒤의 숫자는 0으로 변경 후 1칸씩 앞으로 당긴다.

구문 설명 
arr = [list(map(int, input().split())) for _ in range(N)]
가로 N줄 배열을 입력받는다.

temp[i] = [item for item in temp[i] if item != 0]
temp에 있는 원소 중 0을 모조리 제거한다. (0이 아니면 배열에 대입)
키워드 : 리스트 컴프리헨션

move 함수들을 간소화 할 방법을 찾아봐야 할거같다.
'''


# 재귀함수 호출 횟수 증가
sys.setrecursionlimit(100000)
ans = 0

#위로 이동하기
def moveUp(N, arr):
    temp = deepcopy(arr)
    for i in range(N):
        temparr = []
        for j in range(0, N):
            if temp[j][i] != 0:
                temparr.append(temp[j][i])
                temp[j][i] = 0
        while len(temparr) < N:
            temparr.append(0)
        for j in range(0, N):
            temp[j][i] = temparr[j]
        for j in range(0, N - 1):
            if temp[j][i] == temp[j + 1][i]:
                temp[j][i] *= 2
                for k in range(j + 1, N - 1):
                    temp[k][i] = temp[k + 1][i]
                temp[N - 1][i] = 0
    return temp


#아래로 이동하기
def moveDown(N, arr):
    temp = deepcopy(arr)
    for i in range(N):
        temparr = []
        for j in range(N - 1, -1, -1):
            if temp[j][i] != 0:
                temparr.append(temp[j][i])
                temp[j][i] = 0
        while len(temparr) < N:
            temparr.append(0)
        for j in range(N - 1, -1, -1):
            temp[j][i] = temparr[N - 1 - j]
        for j in range(N - 1, 0, -1):
            if temp[j][i] == temp[j - 1][i]:
                temp[j][i] *= 2
                for k in range(j - 1, 0, -1):
                    temp[k][i] = temp[k - 1][i]
                temp[0][i] = 0
    return temp


# 우측으로 이동하기
def moveRight(N, arr):
    temp = deepcopy(arr)
    for i in range(N):
        cnt = temp[i].count(0)
        temp[i] = [item for item in temp[i] if item != 0]
        for j in range (cnt):
            temp[i].insert(0,0)
        for j in range(N - 1, 0, -1):
            if temp[i][j] == temp[i][j-1]:
                temp[i][j] *= 2
                temp[i].pop(j-1)
                temp[i].insert(0, 0)
    return temp


#좌측으로 이동하기
def moveLeft(N, arr):
    temp = deepcopy(arr)
    for i in range(N):
        cnt = temp[i].count(0)
        temp[i] = [item for item in temp[i] if item != 0]
        for j in range (cnt):
            temp[i].append(0)
        for j in range(0, N - 1):
            if temp[i][j] == temp[i][j + 1]:
                temp[i][j] *= 2
                temp[i].pop(j + 1)
                temp[i].append(0)
    return temp


# 모든 경우의 수에 대해서 탐색하기
def backTrack(count, N, arr):
    global ans
    if count == 5:
        ans = max(ans, max(map(max, arr)))
    else:
        backTrack(count + 1, N, moveDown(N, arr))
        backTrack(count + 1, N, moveUp(N, arr))
        backTrack(count + 1, N, moveLeft(N, arr))
        backTrack(count + 1, N, moveRight(N, arr))


def main():
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    backTrack(0, N, arr)
    print(ans)


main()
