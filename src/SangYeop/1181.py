from sys import stdin
n = int(stdin.readline())
arr = set()
for i in range(n):
    arr.add(stdin.readline())

new_arr = list(arr)

new_arr.sort()
new_arr.sort(key=lambda x:len(x))

print(''.join(new_arr))
