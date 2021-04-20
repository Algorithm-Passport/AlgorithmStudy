import sys
from collections import deque, Counter


def solution(strs):
    # str list로 변환하여 str내에 값을 추가할 수 있도록함
    strs = list(strs)

    #::있는 경우 검사 ::를 만나면 문자열안에 빈 블록만큼 :0룰 추가해줌
    for i in range(len(strs)):
        if i < len(strs) and strs[i] == ":" and strs[i + 1] == ":":
            strs[i] = ":0" * (8 - Counter(strs)[":"])
            break

    # 리스트로 변환했던 문자열을 deque자료구조로 변환
    arr = list(map(deque, "".join(strs).split(":")))
    for i in range(len(arr)):
        # 자른 문자열의 길이가 4가 아니라면 없는 숫자만큼 0을 앞에 붙여준다
        if len(arr[i]) != 4:
            while len(arr[i]) != 4:
                arr[i].appendleft("0")
        arr[i] = "".join(arr[i])

    return ":".join(arr)


print(solution(sys.stdin.readline().rstrip()))
