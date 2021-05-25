import sys
input = sys.stdin.readline

N        = int(input()) # 스위치 개수
switches = [None]

switches += [int(_) for _ in input().split()] # 초기 스위치 구조

S    = int(input()) # 학생 수
info = [] # 성별 / 받은 번호 정보

for i in range(S):
    a,b = [int(_) for _ in input().split()]
    info.append((a,b))


def solution(s, n):
    global switches
    global N
    if s == 1: # 남자
        for k in range(1, (N//n) + 1):
            idx = n*k
            if switches[idx] == 1:
                switches[idx] = 0
            else:
                switches[idx] = 1
    if s == 2: # 여자
        if switches[n] == 0:
            switches[n] = 1
        else:
            switches[n] = 0
        tmp = 1
        while True:
            if n - tmp <= 0 or n + tmp == N+1:
                break
            if switches[n-tmp] == switches[n+tmp]:
                if switches[n-tmp] == 1:
                    switches[n-tmp] = 0
                    switches[n+tmp] = 0
                    tmp += 1
                else:
                    switches[n-tmp] = 1
                    switches[n+tmp] = 1
                    tmp += 1
            else:
                break
for k in info:
    solution(k[0],k[1])

for i in range(int(((N-0.01)//20)+1)):
    print(*switches[20*(i)+1:20*(1+i)+1])
        
        

