#include <bits/stdc++.h>
using namespace std;

/*
인터넷을 참고 했습니다.
구조체 배열을 선언해서 풀이하니 메모리 초과가 나서 문자열을 이용해서 풀이 했습니다.
배열을 문자열로 변환 후, set 자료르 이용하여 방문한 지점을 기록했습니다.
좌표 변환은 /3, %3을 이용해서 변환합니다.
*/

typedef struct
{
	string str;
	int move;
} info;

int move_x[] = {1, -1, 0, 0};
int move_y[] = {0, 0, 1, -1};
string input, ans = "123456780";
set<string> visited;

int bfs()
{
	queue<info> q;
	q.push((info){input, 0});
	while (!q.empty())
	{
		info before = q.front();
		q.pop();
		if (before.str == ans)
			return (before.move);
		int zero = before.str.find('0');
		/* x 좌표와 y 좌표를 추출한다. */
		int x = zero / 3;
		int y = zero % 3;
		for (int i = 0; i < 4; i++)
		{
			int dx = x + move_x[i];
			int dy = y + move_y[i];
			if (dx >= 0 && dx < 3 && dy >= 0 && dy < 3)
			{
				string next = before.str;
				swap(next[x * 3 + y], next[dx * 3 + dy]);
				/* visit에서 next 찾기, 못찾았으면 end 값 반환 */
				if (visited.find(next) == visited.end())
				{
					visited.insert(next);
					q.push((info){next, before.move + 1});
				}
			}
		}
	}
	return (-1);
}

int main()
{
	//freopen("test", "r", stdin);
	int temp;
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			cin >> temp;
			input += temp + '0';
		}
	}
	cout << bfs();
	return (0);
}