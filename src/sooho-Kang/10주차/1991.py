import sys


class Node:
    def __init__(self, content, left, right):
        self.content = content
        if left != ".":
            self.left = left
        else:
            self.left = None
        if right != ".":
            self.right = right
        else:
            self.right = None

    def printer(self):
        print("content %s left %s right %s" % (self.content, self.left, self.right))


def inorder(arr, node):
    if node:
        inorder(arr, arr[node].left)
        print(arr[node].content, end="")
        inorder(arr, arr[node].right)


def preorder(arr, node):
    if node:
        print(arr[node].content, end="")
        preorder(arr, arr[node].left)
        preorder(arr, arr[node].right)


def postorder(arr, node):
    if node:
        postorder(arr, arr[node].left)
        postorder(arr, arr[node].right)
        print(arr[node].content, end="")


def getInput():
    IC = int(sys.stdin.readline())
    arr = {}
    for _ in range(IC):
        a, b, c = map(str, sys.stdin.readline().split())
        arr[a] = Node(a, b, c)
    return arr


def solution():
    arr = getInput()
    preorder(arr, "A")
    print()
    inorder(arr, "A")
    print()
    postorder(arr, "A")


solution()
