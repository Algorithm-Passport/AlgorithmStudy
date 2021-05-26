import sys
from collections import deque


def getInput():
    IC = int(sys.stdin.readline())
    testcases = []
    for _ in range(IC):
        n, m = map(int, sys.stdin.readline().split())
        arr = [n, m]
        arr.append(deque(map(lambda k: [int(k), False], sys.stdin.readline().split())))
        testcases.append(arr)
    return testcases


def solution():
    testCases = getInput()
    # check
    for i in testCases:
        K = i[1]
        arr = i[2]
        arr[K][1] = True
        count = 0
        while True:
            # for 문을 성공적으로 돌면 true
            flag = True
            for k in range(1, len(arr)):
                if arr[0][0] < arr[k][0]:
                    arr.append(arr.popleft())
                    flag = False
                    break
            if flag == True:
                count += 1
                if arr[0][1] == True:
                    print(count)
                    break
                else:
                    arr.popleft()


solution()