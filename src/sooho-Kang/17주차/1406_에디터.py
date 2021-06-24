import sys

input = sys.stdin.readline


def getInput():
    initstr = input().strip()
    count = int(input())
    operation = []
    for _ in range(count):
        operation.append(input().strip().split(" "))
    return initstr, operation


def solution():
    initStr, operation = getInput()
    arr = list(initStr)
    stack = []
    for i in operation:
        if i[0] == "L":
            if arr:
                stack.append(arr.pop())
        elif i[0] == "D":
            if stack:
                arr.append(stack.pop())
        elif i[0] == "B":
            if arr:
                arr.pop()
        elif i[0] == "P":
            arr.append(i[1])
    print("".join(arr + stack[::-1]))


solution()
