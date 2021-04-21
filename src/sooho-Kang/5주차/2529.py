import sys


def getInput():
    IC = int(sys.stdin.readline())
    arr = list(sys.stdin.readline().split())
    return IC, arr

# 연산자에 따라 a,b연산함
def operation(s, a, b):
    if s == ">":
        return a > b
    if s == "<":
        return a < b


def dfs(arr, visited, opr, ans):
    if len(arr) == len(opr) + 1:
        ans.append("".join(map(str, arr)))
    else:
        for i in range(10):
            #방문체크
            if not visited[i]:
                #배열의 길이가 0이거나 operation 함수(입력받은 연산자) 조건에 맞으면
                if not len(arr) or (operation(opr[len(arr) - 1], arr[len(arr) - 1], i)):
                    arr.append(i)
                    visited[i] = True
                    dfs(arr, visited, opr, ans)
                    arr.pop()
                    visited[i] = False


def solution():
    IC, opr = getInput()
    # 방문배열
    visited = [False] * 10
    ans = []
    arr = []
    dfs(arr, visited, opr, ans)
    # print(ans)
    print(ans[len(ans) - 1])
    print(ans[0])


solution()
