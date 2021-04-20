import sys

# 마이너스가한번이라도 나오면 그 뒤에있는 숫자들 모두 뺴면 답나옴
def solution(strs):
    nums = []
    opr = []
    strs = list(strs)
    # 문자열 정리
    # 우선 연산자 추출후 그 자리에 콤마 삽입
    for i in range(len(strs)):
        if strs[i] == "-" or strs[i] == "+":
            strs.insert(i, ",")
            opr.append(strs.pop(i + 1))
    # 삽입한 콤마 기준으로 숫자 자름
    nums = list(map(int, "".join(strs).split(",")))
    ans = 0
    #'-'연산자가 한번이라도 나왔는지 확인하는 플래그
    isNeg = False
    # 인덱스 에러를 방지하기 위한 dummy, opr는 숫자들보다 하나 작기 때문
    opr.append(False)
    for i in range(len(nums)):
        #'-'연산자가 안나왓으면 단순 덧셈
        if not isNeg:
            ans += nums[i]
        #'-'연산자가 한번이라도 나왔으면 이제부터 뺄셈
        elif isNeg:
            ans -= nums[i]
            continue
        #'-'연산자가 나왔으면 음수플래그
        if opr[i] == "-":
            isNeg = True
    return ans


print(solution(sys.stdin.readline()))