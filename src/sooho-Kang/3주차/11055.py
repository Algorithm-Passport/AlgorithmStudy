import sys


def getInput():
    IC = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))
    return IC, arr


def solution():
    IC, arr = getInput()
    cache = []
    # 어디서 시작하든 최소 자기의 value값 이상이기때문에 해당 index value로 cache 초기화
    for i in arr:
        cache.append(i)
    # 자기 위치 인덱스 갑보다 전에있는 인덱스가 작으면 그 값을 더할 수 있음
    # 추가로 현재 자기의 캐시값보다 전에 나온 캐시값에 자기를
    # 더한값이 크면 그값으로 자신의 캐시값 초기화
    for i in range(IC):
        for j in range(i - 1, -1, -1):
            if arr[j] < arr[i] and cache[i] < arr[i] + cache[j]:
                cache[i] = arr[i] + cache[j]
    return max(cache)


print(solution())