def isOpen(a):
    return True if (a == "(" or a == "[") else False


def isClose(a):
    return True if (a == ")" or a == "]") else False


def isPair(a, b):
    if a == "(" and b == ")":
        return True
    if a == "[" and b == "]":
        return True
    else:
        return False


def isNum(a):
    return True if type(a) == type(100) else False


def solution(arr):
    stack = []
    for i in arr:
        if isOpen(i):
            stack.append(i)
        elif isClose(i):
            # 스택 비어있으면 일치하는 괄호 없음으로 FALSE
            if not stack:
                return 0
            count = 2 if i == ")" else 3
            # 스택이 마지막값이 괄호랑 한 쌍이면
            if isPair(stack[len(stack) - 1], i):
                # 여는괄호 제거
                stack.pop()
                stack.append(count)
            # 최근값이 숫자라면 곱해야된다
            elif isNum(stack[len(stack) - 1]):
                # 값 계산
                temp = stack.pop() * count
                # 여는괄호 버리기 만약 들어온값이랑 일치 안하면 FALSE
                if not stack:
                    return 0
                if not isPair(stack.pop(), i):
                    return 0
                stack.append(temp)
            if len(stack) > 1:
                if isNum(stack[len(stack) - 1]) and isNum(stack[len(stack) - 2]):
                    temp = stack.pop()
                    temp1 = stack.pop()
                    stack.append(temp + temp1)
        else:
            return 0
    if not stack or len(stack) > 1:
        return 0
    if not isNum(stack[0]):
        return 0
    return stack.pop()


# inp = input()
# print(solution(inp))

testArr = [
    ("(()[[]])([])", 28),
    ("()", 2),
    ("[]", 3),
    ("[[]]", 9),
    ("[[]]()", 11),
    ("[[[()]]", 0),
    ("[(()[[]])([])]", 84),
    ("[(([)[[]])([])]", 0),
    ("()()", 4),
    ("[][]", 6),
    ("(())", 4),
    ("[[]]", 9),
    ("(()[])", 10),
    ("()[[]]", 11),
    ("(()[[]])", 22),
    ("()[", 0),
    ("([)", 0),
    ("[()", 0),
    ("([)]", 0),
    ("[(])", 0),
    (")[", 0),
    ("(", 0),
    (")", 0),
    ("([])[", 0),
    ("(())[[]])", 0),
    ("{}{[]", 0),
    ("[]())", 0),
    ("([)", 0),
    ("(()[])", 10),
    ("((()[]))", 20),
    ("((()[]))[]", 23),
    ("((()[])[])", 26),
    ("()[()]", 8),
    ("(()[[]])", 22),
    ("(()[[]])[]", 25),
    ("[()[()[()]]]", 78),
    ("()[()]()[()]", 16),
    ("(()[()]()[()])", 32),
    ("(()[()]()[()])(()[()]()[()])", 64),
    ("[](()[()]()[()])(()[()]()[()])", 67),
    ("[](()[()]()[()])()(()[()]()[()])", 69),
    ("[](()[()]()[()])()(()[()]()[()])[]", 72),
    ("((()[()]()[()])()(()[()]()[()])[])", 138),
    ("]()", 0),
    ("())(", 0),
    ("[[[]][]]", 36),
    ("()[]())", 0),
    ("(()()", 0),
    ("(([()", 0),
    ("([[]", 0),
    ("[[([])", 0),
    ("[()([[]", 0),
    ("([]", 0),
    ("[[]", 0),
    ("(()()()", 0),
    ("()()[[]", 0),
    ("[([[(([]", 0),
    ("[]([]", 0),
    ("[[]", 0),
    ("[](()[]", 0),
    ("(()", 0),
    ("[()", 0),
    ("()[()", 0),
    ("([]", 0),
    ("[()", 0),
    ("([]", 0),
    ("[()(()", 0),
    ("[()", 0),
    ("[[()", 0),
    ("[()", 0),
    ("[[]]([(([]())[[]]", 0),
    ("[][(()[]", 0),
    ("([[](()(())", 0),
    ("[[]", 0),
    ("[[[][]", 0),
    ("([()", 0),
    ("()[([[[][]][]", 0),
    ("[][()[]", 0),
    ("[]()[()", 0),
    ("(()[[]])([])(()[[]])([])(()[[]])([])", 84),
    ("(){}", 0),
    ("([[]]())", 22),
    ("[[()][]]", 27),
    ("((())[])", 14),
    ("((])", 0),
    ("[()) ", 0),
    ("(()[])()", 12),
    ("([](([]))[])", 36),
]


# def test(arr):
#     for i in arr:
#         sol = solution(i[0])
#         print(i, "\t\t:", True if sol == i[1] else False, " ", sol)


# # test(testArr)


# IC,max = map(int,input().split())
# nums=map(int,input().split())
# strs=''
# for i in nums:
#     if i<max:
#         strs+=(str(i)+' ')

# strs[len(strs)-1]=''
# print(strs)
solution("((()[()]()[()])()(()[()]()[()])[])")

# 10 5
# 1 10 4 9 2 3 8 5 7 6