n = int(input())
town = []
population = 0
for _ in range(n):
  a,b = map(int,input().split())
  population += b
  town.append([a,b])

town = sorted(town, key = lambda i : i[0])

if population%2==0:
  middle = population//2
else:
  middle = population//2 + 1

cnt = 0
for a,b in town:
  cnt += b
  if cnt >= middle:
    print(a)
    break

