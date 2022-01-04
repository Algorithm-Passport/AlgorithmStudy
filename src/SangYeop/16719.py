# 일단 바로 떠오르는 것은 모든 문자열을 각각 다 비교하는거야
# 예를들어 [b,o,b]가 있다면... b,o,b비교 하고 bb,bo이렇게 비교하는 식으로 그런데 오래 걸릴 것 같아..
# 그리고 중요한 것은 원래 문자열의 순서대로 나오는 거야...
# 그렇다면 맨 앞에 있는 것 뒤로만 비교를 하는게 가장 좋겠어!!! 이게 맞아. 그러면 모두 비교를 하지 않아도 된다.
# 자료구조를 어떻게 활용해서 할 것인지...

string = list(input())
visited = [False] * len(string)


def solve(left, right):
    if left == right:
        return

    min_str = min(string[left: right])
    min_idx = string[left: right].index(min_str) + left

    visited[min_idx] = True

    for i in range(len(string)):
        if visited[i]:
            print(string[i], end='')
    print()

    solve(min_idx + 1, right)
    solve(left, min_idx)


solve(0, len(string))



# 이거 전체적인 구조 다시 생각해야해. while과 for문을 중심으로 => 이거 머리속으로 안그려져 연습해야해
# 뒤에거 다 붙이고 그다음 앞으로 가는거로... 나는 왓다갔다하고 있어. 나쁘지 않아
# 그런데 앞뒤로 붙이는거 아니야. 원래 자리에 맞게 들어가야 하는 거야
# 그럼 없는 곳에서 새로 만들어 주는게 아니라 안되는것을 없애고 출력하는 식으로 해볼까?
# 아니면 전부 조합을 해서 사전 순서대로 리턴하는 것? 자리 지키면서...아..이건.. 좀ㅁ...



# 문자열도 가장 작고 큰게 있다.


