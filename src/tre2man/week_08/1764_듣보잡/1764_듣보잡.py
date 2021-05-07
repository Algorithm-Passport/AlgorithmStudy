from sys import stdin


def main():
    N, M = map(int, stdin.readline().split())
    notListened = [stdin.readline().strip() for i in range(N)]
    notLooked = [stdin.readline().strip() for i in range(M)]

    #set 자료형의 연산 &를 이용하면 교집합을 구할 수 있다. 두 집합의 교집합이 답이 된다.
    ans = sorted(list(set(notListened) & set(notLooked)))

    print(len(ans))
    for i in ans:
        print(i)


main()
