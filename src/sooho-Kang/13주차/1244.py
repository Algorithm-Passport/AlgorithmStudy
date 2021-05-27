import sys


def getInput():
    N = int(sys.stdin.readline())
    switches = [None]
    switches.extend(list(map(int, sys.stdin.readline().split())))
    M = int(sys.stdin.readline())
    kids = []
    for _ in range(M):
        kids.append(list(map(int, sys.stdin.readline().split())))
    return switches, kids


def boy(switches, loc):
    temp = loc
    while loc < len(switches):
        if switches[loc] == 1:
            switches[loc] = 0
        elif switches[loc] == 0:
            switches[loc] = 1
        loc += temp


def girl(switches, loc):
    val = 1
    if switches[loc] == 1:
        switches[loc] = 0
    else:
        switches[loc] = 1
    while loc - val > 0 and loc + val < len(switches):
        if switches[loc + val] == switches[loc - val]:
            if switches[loc + val] == 1:
                switches[loc + val] = 0
            elif switches[loc + val] == 0:
                switches[loc + val] = 1
            if switches[loc - val] == 1:
                switches[loc - val] = 0
            elif switches[loc - val] == 0:
                switches[loc - val] = 1
        else:
            break
        val += 1


def solution():
    switches, kids = getInput()
    for i in range(len(kids)):
        # boy
        if kids[i][0] == 1:
            boy(switches, kids[i][1])
        # girl
        if kids[i][0] == 2:
            girl(switches, kids[i][1])
    strs = ""
    for i in range(1, len(switches)):
        strs += str(switches[i]) + " "
        if i % 20 == 0:
            strs += "\n"
    sys.stdout.write(strs)


solution()
