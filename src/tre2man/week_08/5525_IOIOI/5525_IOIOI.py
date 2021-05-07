from sys import stdin

def main():
    N = int(stdin.readline())
    M = int(stdin.readline())
    S = stdin.readline()

    ans = 0
    temp = 0
    i = 1
    while i < M - 1:
        # 조건에 맞는 문자열을 찾을 경우
        if S[i-1] == 'I' and S[i] == 'O' and S[i+1] == 'I':
            # 임시 체크
            temp += 1
            # 문자열의 길이와 입력이 일치할 경우
            if temp == N:
                temp -= 1
                ans += 1
            # 다음 문자열 찾아가야 한다.
            i += 1
        else:
            temp = 0
        # 다음 문자열 찾으러간다.
        i += 1
    print(ans)


main()
