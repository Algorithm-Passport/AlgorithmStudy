import sys

input = sys.stdin.readline

s = input().rstrip()
flag = False
word = ""
answer = ""

for i in s:
    if flag == False:
        if i == "<":
            flag = True
            word += i
        elif i == " ":
            word += i
            answer += word
            word = ""
        else:
            word = i + word

    else:
        word += i
        if i == ">":
            flag = False
            answer += word
            word = ""

print(answer + word)