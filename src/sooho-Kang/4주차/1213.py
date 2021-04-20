import sys
from collections import Counter, deque


def solution(strs):
    # 모두 덱 자료구조로 만듬
    front = deque([])
    back = deque([])
    arr = deque([])
    center = ""
    # strs 배열화, 정렬
    for i in sorted(strs):
        arr.append(i)
    # 갯수를 센 배열
    counted = Counter(arr)

    # 검사 개수가 홀수인 문자가 하나 이하여야됨
    WFLAG = 0
    for i in set(arr):
        if counted[i] % 2 != 0:
            WFLAG += 1
            center = i
            # center값 하나 제거 나중에 이어붙이기 위함
            arr.remove(center)
            if WFLAG == 2:
                return "I'm Sorry Hansoo"
    # 메인로직
    for i in sorted(set(arr)):
        #모든 문자 카운트는 짝수임 이걸 반짤라서 앞에 붙이고 뒤에 붙임
        for _ in range(counted[i] // 2):
            front.append(arr.popleft())
            back.appendleft(arr.popleft())
    #최종값 반환 
    front.append(center)
    return "".join(front + back)


print(solution(sys.stdin.readline().rstrip()))
# testCases = [
#     ("AABB", "ABBA"),
#     ("BAAA", "I'm Sorry Hansoo"),
#     ("AA", "AA"),
#     ("AA B", "I'm Sorry Hansoo"),
#     ("BCDAADCB", "ABCDDCBA"),
#     ("ABABB", "ABBBA"),
#     ("ABBAB", "ABBBA"),
#     ("AABBC", "ABCBA"),
#     ("AABBCCCD", "I'm Sorry Hansoo"),
#     ("AAABB", "ABABA"),
# ]
# for i in testCases:
#     temp = solution(i[0])
#     if temp != i[1]:
#         print("FALSE", temp)
#     else:
#         print("TRUE")
