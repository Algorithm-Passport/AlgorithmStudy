import sys


def getInput():
    N = int(sys.stdin.readline())
    return N


def game(n):
    cache = [0 for _ in range(n + 1)]
    # 0번쨰 인덱스 사용안함
    cache[0] = 0
    # 1,2,3번째 인덱스 초기화
    cache[1] = 1
    try:
        cache[2] = 2
        cache[3] = 1
    except:
        return 2 if n == 2 else 1
    for i in range(4, n + 1):
        # 최적의 방법을 찾음 돌 3개를 집거나 1개를 집을때 더 작은수가 최적
        cache[i] = min(cache[i - 1], cache[i - 3]) + 1
    return cache[n]


def solution():
    N = getInput()
    count = game(N)
    if count % 2 == 1:
        print("SK")
    else:
        print("CY")


solution()
