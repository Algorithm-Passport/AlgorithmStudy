import sys


def dfs(n, visited, arr):
    # 길이가 n이면 출력 리턴됨으로 이전호출의 17번째줄로감
    if len(arr) == n:
        print(" ".join(map(str, arr)))
    else:
        for i in range(1, n + 1):
            # 아직 방문하지 않으면
            if not visited[i]:
                # 정답배열에 추가하고 방문체크
                arr.append(i)
                visited[i] = True
                dfs(n, visited, arr)
                # 정답배열에서 빼고 방문체크혜제
                arr.pop()
                visited[i] = False


def solution(n):
    # 방문체크배열
    visited = [False] * (n + 1)
    # 정답배열
    arr = []
    dfs(n, visited, arr)


solution(int(sys.stdin.readline().rstrip()))