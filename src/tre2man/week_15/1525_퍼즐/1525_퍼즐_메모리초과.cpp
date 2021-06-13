#include <bits/stdc++.h>
using namespace std;

/* 답은 맞게 나오나, 메모리 초과를 계속 낸다. 다른 방법으로 풀이를 해야 한다. */

typedef struct
{
	short arr[3][3];
	short x, y, moved;
} maps;

int move_x[] = {1, -1, 0, 0};
int move_y[] = {0, 0, 1, -1};
maps ans;
bool visited[999999999];

maps input;

int mtoi(maps a)
{
	char str[10];

	int idx = 0;
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			str[idx++] = a.arr[i][j] + '0';
	str[idx] = '\0';
	return (atoi(str));
}

bool mapcmp(maps a, maps b)
{
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			if (a.arr[i][j] != b.arr[i][j])
				return (0);
	return (1);
}

int bfs()
{
	queue<maps> q;
	q.push(input);
	while (!q.empty())
	{
		maps before = q.front();
		q.pop();
		if (mapcmp(before, ans))
			return (before.moved);
		for (int i = 0; i < 4; i++)
		{
			/* dx dy는 바꿀 숫자의 좌표, before에 있는 숫자는 0이 있는 좌표 */
			int dx = before.x + move_x[i];
			int dy = before.y + move_y[i];
			if (dx >= 0 & dx < 3 && dy >= 0 && dy < 3)
			{
				/* 방문하지 않았다면 */
				visited[mtoi(before)] = 1;
				maps newmap = before;
				newmap.arr[before.y][before.x] = before.arr[dy][dx];
				newmap.arr[dy][dx] = 0;
				newmap.x = dx;
				newmap.y = dy;
				newmap.moved = before.moved + 1;
				if (!visited[mtoi(newmap)])
					q.push(newmap);
			}
		}
	}
	return (-1);
}

int main()
{
	short idx = 1;
	for(int i=0;i<3;i++)
		for(int j=0;j<3;j++)
			ans.arr[i][j] = idx++;
	ans.arr[2][2] = 0;
	
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			cin >> input.arr[i][j];
			if (!input.arr[i][j])
			{
				input.x = j;
				input.y = i;
			}
		}
	}
	input.moved = 0;
	cout << bfs();
	return (0);
}
