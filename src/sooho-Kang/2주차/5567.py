import sys


def getInput():
    N = sys.stdin.readline()
    IC = int(sys.stdin.readline())
    arr = []
    for _ in range(IC):
        a, b = sys.stdin.readline().split()
        arr.append([a, b])
    return N, IC, arr


def solution(N, IC, arr):
    friends = []
    ffs = ["1"]
    for i in range(len(arr)):
        if arr[i][0] == "1":
            friends.append(arr[i][1])
        elif arr[i][1] == "1":
            friends.append(arr[i][0])
    for i in range(len(arr)):
        for j in friends:
            if j == arr[i][0]:
                ffs.append(arr[i][1])
            elif j == arr[i][1]:
                ffs.append(arr[i][0])

    for k in ffs:
        friends.append(k)
    set123 = set(friends)
    return len(set123) - 1


def main():
    # N, IC, arr = getInput()
    N = 6
    IC = 5
    arr = [["1", "2"], ["1", "3"], ["3", "4"], ["2", "3"], ["4", "5"]]
    sys.stdout.write(str(solution(N, IC, arr)))


main()


# 3
# 2
# 2 1
# 3 1