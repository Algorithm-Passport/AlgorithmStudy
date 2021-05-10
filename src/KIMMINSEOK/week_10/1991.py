import sys


N = int(sys.stdin.readline())
arr = [0 for _ in range(27)]
alph = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ.'
for i in range(N):
    root,left,right = [_ for _ in sys.stdin.readline().split()]
    arr[alph.index(root)] = (alph.index(left), alph.index(right))

def pre_order(s):
    if s == 26:
        return
    print(alph[s], end="")
    
    pre_order(arr[s][0]) # Left
    pre_order(arr[s][1]) # Right

pre_order(0)
print('')

def in_order(s):
    if s == 26:
        return
    in_order(arr[s][0])
    print(alph[s], end='')
    in_order(arr[s][1])

in_order(0)
print('')
def post_order(s):
    if s == 26:
        return
    post_order(arr[s][0]) # Left
    post_order(arr[s][1]) # Right
    print(alph[s], end="")
    
post_order(0)
