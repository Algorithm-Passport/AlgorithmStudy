n = int(input())

arr = list(map(int, input().split()))

d = [0] * 1000

d[0] = arr[0]
for i in range(1, n):
  d[i] = arr[i] # dp테이블 초기화

  for j in range(0, i):
    # 증가수열일경우            # 무조건 증가부분수열이라고 새로운 d[i]를 가지면안되고 가장 큰값이 dp테이블에 존재해야하므로
    if arr[i] > arr[j] and d[i] < d[j] + arr[i]:
      d[i] = d[j] + arr[i] # dp[i] - 기준
      # j를 0부터 i - 1까지 움직여가면서 d[i] (입력될 dp 테이블값)에 
      # d[j] (메모이제이션된 dp테이블 값)을 더함

print(d)
print(max(d))

# 5 2 9 7 올경우 dp 테이블
# d : 5 2 11 9
# 나와야할값 : 5 2 14 12

# 문제점 : arr[i] > arr[j]이면 단순히 d[i]에 값을 덮어버림.
# 조건문하나 추가해야함. d[i] < d[j] + arr[i]  이미 존재하는 것보다 더 큰경우에만 d[i]에 값을 넣는다.
# 문제자체가 증가부분수열중 합이 가장 큰것이므로.(합이 가장큰것이므로)
