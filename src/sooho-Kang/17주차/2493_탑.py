import sys

input = sys.stdin.readline


def getInput():
    IC = int(input())
    arr = list(map(int, input().split()))
    return arr


# 1: 현재인덱스 이전의 값중 최초로 자신보다 큰값을 가진 인덱스가 정답  
# 2: 현재인덱스의 값이 이전인덱스의 값보다 크면 이전 인덱스들 무시해도 됨

def solution():
    arr = getInput()
    # 스택에는 자신이 현재 위치한 인덱스이전의 인덱스들만 존재 가능
    stack = [0]
    ans = [0]
    for i in range(1, len(arr)):
        # 스택이 아닐때까지 반복문
        while stack:
            # 스택의 pop된 인덱스에 해당하는 값이랑 현재인덱스의 값이랑 비교 한 뒤
            # 만약 스택에서 pop된게 크면 그 값과 현재 인덱스의 값을 스택에 추가하고
            # 스택에서 나온값을 정답배열에 추가함 이후 break
            temp = stack.pop()
            if arr[temp] > arr[i]:
                stack.append(temp)
                stack.append(i)
                ans.append(temp + 1)
                break
        # while문을 탈출하고도 스택이 아니면 끝까지 가서 정답 못찾은것
        # 정답배열에 0추가하고 스택에 현재인덱스 추가
        if not stack:
            ans.append(0)
            stack.append(i)

    print(" ".join(list(map(str, ans))))


solution()
