import sys


def getInput():
    IC = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))
    return IC, arr


def solution():
    IC, arr = getInput()
    cache = []
    for i in arr:
        cache.append(i)
    for i in range(IC):
        for j in range(i - 1, -1, -1):
            if arr[j] < arr[i] and cache[i] < arr[i] + cache[j]:
                cache[i] = arr[i] + cache[j]
    return max(cache)

print(solution())