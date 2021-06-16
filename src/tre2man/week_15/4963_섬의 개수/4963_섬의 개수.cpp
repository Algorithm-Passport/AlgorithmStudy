#include <iostream>
#include <cstring>
using namespace std;

/*
탐색하지 않은 좌표에 대해서 bfs를 실행하자.
x 좌표 y좌표 헷갈리지 말자. 시간 낭비했음.
*/

/* 움직일수 있는 방향이 8가지이므로, 미리 좌표를 만들어 놓는다. */
int move_x[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int move_y[8] = {1, 1, 0, -1, -1, -1, 0, 1};
int map[50][50];
bool visited[50][50];

void dfs(int x, int y, int w, int h, int n)
{
	visited[y][x] = true;
	/* 8방향에 대해서 조건에 맞으면 탐색을 진행한다. */
	for (int i = 0; i < 8; i++)
	{
		int dx = x + move_x[i];
		int dy = y + move_y[i];
		if (dx >= 0 && dx < w && dy >= 0 && dy < h && map[dy][dx] && !visited[dy][dx])
			dfs(dx, dy, w, h, n);
	}
}

int main()
{
	//freopen("test", "r", stdin);
	int w, h, n;
	while (1)
	{
		memset(map, 0, sizeof(map));
		memset(visited, 0, sizeof(visited));
		cin >> w >> h;
		if (!w && !h)
			return (0);
		n = 1;
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				cin >> map[i][j];

		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				if (map[i][j] && !visited[i][j])
					dfs(j, i, w, h, n++);

		cout << n - 1 << "\n";
	}
	return (0);
}