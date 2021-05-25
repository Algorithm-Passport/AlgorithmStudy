import sys

input = sys.stdin.readline
sys.setrecursionlimit(1000000)
maxN = 0


def getInput():
    N = int(input())
    arr = [0] * 100001
    for i in range(N):
        arr[i] = int(input())
    arr[100000] = 1000000000
    return N, arr


def makeTree(tree, node, arr, start, end):
    if start == end:
        tree[node] = start
        return tree[node]
    mid = (start + end) // 2
    left = makeTree(tree, node * 2, arr, start, mid)
    right = makeTree(tree, node * 2 + 1, arr, mid + 1, end)
    tree[node] = min(left, right, key=lambda k: arr[k])
    return tree[node]


def find(tree, node, arr, start, end, begin, finish):
    if end < begin or start > finish:
        return 100000
    if start >= begin and end <= finish:
        return tree[node]
    mid = (start + end) // 2
    left = find(tree, node * 2, arr, start, mid, begin, finish)
    right = find(tree, node * 2 + 1, arr, mid + 1, end, begin, finish)
    return min(left, right, key=lambda k: arr[k])


def search(tree, arr, N, begin, finish):
    global maxN
    if begin > finish:
        return
    idx = find(tree, 1, arr, 0, N - 1, begin, finish)
    tmp = (finish - begin + 1) * arr[idx]
    if maxN < tmp:
        maxN = tmp
    search(tree, arr, N, begin, idx - 1)
    search(tree, arr, N, idx + 1, finish)


def solution():
    global maxN
    N, arr = getInput()
    tree = [None] * (400000)
    makeTree(tree, 1, arr, 0, N - 1)
    search(tree, arr, N, 0, N - 1)
    print(maxN)


solution()
