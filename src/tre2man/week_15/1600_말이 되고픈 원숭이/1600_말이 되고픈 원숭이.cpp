#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

/*
dp로 풀이가 될까 했으나, 길이 보이지 않았음.
예전에 비슷한 문제를 풀이한 적이 있어서 참고했다. (백준 2206)
x,y,horse 의 3개 변수값을 가지고 있는 큐를 선언.
3차원 배열을 통해서 K + 1 개의 차원에서 bfs를 돌린다.
각각의 차원에서 알아서 탐색이 될 것이며, 가장 빨리 목표에 도달하는 곳이 정답일 것이다.
정답에 도달하지 못하면 while문을 빠져나와 -1을 반환하게 될 것이다.
*/

typedef struct
{
	int x, y, horse;
} loc;

int map[200][200];
int visited[200][200][30];
int K, W, H;

int bfs()
{
	queue<loc> q;
	int move_horse_x[8] = {1, 2, 2, 1, -1, -2, -2, -1};
	int move_horse_y[8] = {2, 1, -1, -2, -2, -1, 1, 2};
	int move_x[4] = {1, -1, 0, 0};
	int move_y[4] = {0, 0, 1, -1};
	int ans = -1;

	visited[0][0][0] = 1;
	q.push((loc){0, 0, 0});
	while (!q.empty())
	{
		loc a = q.front();
		q.pop();
		int x = a.x;
		int y = a.y;
		int horse = a.horse;
		if ((y == H - 1) && (x == W - 1))
			return (visited[y][x][horse] - 1);
		/* 일반적인 인접한 곳 이동 */
		for (int i = 0; i < 4; i++)
		{
			int dx = x + move_x[i];
			int dy = y + move_y[i];
			if (dx >= 0 && dx < W && dy >= 0 && dy < H && !map[dy][dx] && !visited[dy][dx][horse])
			{
				visited[dy][dx][horse] = visited[y][x][horse] + 1;
				q.push((loc){dx, dy, horse});
			}
		}
		/* 말처럼 이동 */
		for (int i = 0; i < 8; i++)
		{
			int dx = x + move_horse_x[i];
			int dy = y + move_horse_y[i];
			if (dx >= 0 && dx < W && dy >= 0 && dy < H && !map[dy][dx] && !visited[dy][dx][horse + 1] && horse < K)
			{
				visited[dy][dx][horse + 1] = visited[y][x][horse] + 1;
				q.push((loc){dx, dy, horse + 1});
			}
		}
	}
	return (-1);
}

int main()
{
	//freopen("test", "r", stdin);
	cin >> K >> W >> H;
	for (int i = 0; i < H; i++)
		for (int j = 0; j < W; j++)
			cin >> map[i][j];

	cout << bfs();
	return (0);
}