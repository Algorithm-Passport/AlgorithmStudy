import sys

input = sys.stdin.readline


def getInput():
    IC = int(input())
    arr = []
    for _ in range(IC):
        arr.append(int(input()))
    return arr


def pushHeap(heap, ele):
    heap.append(ele)
    cur = len(heap) - 1
    while cur > 1:
        parent = cur // 2
        if heap[parent] >= heap[cur]:
            heap[parent], heap[cur] = heap[cur], heap[parent]
        else:
            break
        cur = parent


def popHeap(heap, arr):
    if len(heap) == 1:
        arr.append("0")
        return
    heap[1], heap[len(heap) - 1] = heap[len(heap) - 1], heap[1]
    arr.append(str(heap.pop()))
    cur = 1
    while cur <= (len(heap)-1) // 2:
        left = cur * 2
        right = cur * 2 + 1
        try:
            minN = left if heap[left] < heap[right] else right
        except:
            minN = left
        if heap[cur] > heap[minN]:
            heap[cur], heap[minN] = heap[minN], heap[cur]
            cur = minN
        else:
            break


def solution():
    arr = getInput()
    heap = [False]
    strs = []
    for i in arr:
        if i == 0:
            popHeap(heap, strs)
        else:
            pushHeap(heap, i)
    sys.stdout.write("\n".join(strs))


solution()
