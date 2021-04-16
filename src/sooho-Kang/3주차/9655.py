import sys


def getInput():
    N = int(sys.stdin.readline())
    return N


def game(n):
    cache = [0 for _ in range(n + 1)]
    cache[0] = 0
    cache[1] = 1
    for i in range(2, n + 1):
        cache[i] = cache[i - 1] + 1
        if cache[i] < cache[i // 3] + 1:
            cache[i] = cache[i // 3] + 1
    return cache[n]

def solution():
    N = getInput()
    count=game(N)
    if count%2==1:
        print("SK")
    else:
        print("CY")

solution()
