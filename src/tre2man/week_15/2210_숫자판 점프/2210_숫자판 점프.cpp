#include <iostream>
#include <cstring>
#define MAX_INDEX 1000000
using namespace std;

/*
브루트 포스를 이용한 문제.
모든 시작 좌표부터 시작하여 인덱스를 벗어나지 않게 탐색한다.
방문한 곳을 재방문해도 된다.
*/

bool arr[MAX_INDEX];
char number[7];
int map[5][5];

void bfs(int x, int y, int n)
{
	if (n == 6)
	{
		arr[atoi(number)] = true;
		return;
	}
	number[n] = map[x][y] + '0';
	if (x > 0)
		bfs(x - 1, y, n + 1);
	if (x < 4)
		bfs(x + 1, y, n + 1);
	if (y > 0)
		bfs(x, y - 1, n + 1);
	if (y < 4)
		bfs(x, y + 1, n + 1);
}

int calAns()
{
	int ans = 0;

	for (int i = 0; i < MAX_INDEX - 1; i++)
		if (arr[i])
			ans++;
	return (ans);
}

int main()
{
	number[6] = '\0';

	for (int i = 0; i < 5; i++)
		for (int j = 0; j < 5; j++)
			cin >> map[i][j];

	for (int i = 0; i < 5; i++)
		for (int j = 0; j < 5; j++)
			bfs(i, j, 0);

	cout << calAns();
	return (0);
}