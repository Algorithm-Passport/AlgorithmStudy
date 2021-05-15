import sys
from collections import deque

input= sys.stdin.readline

n = int(input())

graph  = []
result = 0
x      = 0

for _ in range(n):
    graph.append(int(input()))
graph.append(0) # 마지막까지 다 돌리기 위함
stack = [(0, graph[0])]

for i in range(1, n+1):
    x = i # x 좌표 옮겨줌
    while stack and stack[-1][1] > graph[i]: # 현재 위치의 바로 전 블럭이 현재 위치보다 높이가 높다.
        x, temp = stack.pop()
        result = max(result, temp*(i-x)) # 전 블럭 높이 이상을 가지는 블럭의 개수는, x번째 블록의 앞 (i-x) 개가 된다.
    stack.append((x, graph[i])) # 자기 자신을 쌓아준다. 자기 자신이 전 블럭보다 높이가 낮았으면, 그 전것들은 다 계산되어 사라진다.
print(result)
