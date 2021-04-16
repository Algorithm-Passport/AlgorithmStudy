import sys

# 4
# 1 5 6 7
def getInput():
    n = int(sys.stdin.readline())
    arr = [0]
    arr.extend(list(map(int, sys.stdin.readline().split())))
    return n, arr


def getMaxPay(n, arr):
    cache = [0 for _ in range(10001)]
    cache[1] = arr[1]
    # 받은 카드의 가격들 최적화
    # ex)카드들이 1 5 6 7 일때 4장을 구매하는 경우에 무조건 5+5가 7보다 높음으로 4에 5+5 들어가도록
    for i in range(2, len(arr)):
        cache[i] = arr[i]
        for k in range(1, len(arr)):
            if i >= k and cache[i] < cache[i - k] + arr[k]:
                cache[i] = cache[i - k] + arr[k]
    # dp를 활용하여 카드arr돌면서 최고 비싼값 찾음
    for j in range(len(arr), n):
        for k in range(1, len(arr)):
            if cache[j] < cache[j - k] + arr[k]:
                cache[j] = cache[j - k] + arr[k]
    return cache[n]


def solution():
    n, arr = getInput()
    print(getMaxPay(n, arr))


solution()