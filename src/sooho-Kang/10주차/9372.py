import sys


def getInput():
    IC = int(sys.stdin.readline())
    ans = []
    for _ in range(IC):
        N, M = map(int, sys.stdin.readline().split())
        ans.append(str(N - 1))
        for _ in range(M):
            a = sys.stdin.readline()
    sys.stdout.write("\n".join(ans))


def solution():
    getInput()


solution()