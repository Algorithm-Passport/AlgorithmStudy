import sys


def getInput():
    N, M = map(int, sys.stdin.readline().split())
    d = []  # 듣
    b = []  # 보
    for _ in range(N):
        d.append(sys.stdin.readline().strip())
    for _ in range(M):
        b.append(sys.stdin.readline().strip())

    return sorted(b), sorted(d)


def solution():
    d, b = getInput()
    ans = []
    j = 0
    for i in d:
        if j >= len(b):
            break
        #보 배열에 값을 하나하나 돌아 듣 배열의 i값과 같으면 ans배열에 추가시킴
        while j < len(b) and b[j] <= i:
            if b[j] == i:
                ans.append(i)
            j += 1
    print(len(ans))
    for i in ans:
        sys.stdout.write(i + "\n")


solution()
