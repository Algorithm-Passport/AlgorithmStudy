#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;

/*
bfs를 이용하여 구현했다.
깊이가 2가 되는 구간까지 탐색 후 방문한 지점에 대해서 계산함.
*/

typedef struct
{
	int data;
	int depth;
} loc;

vector<int> v[51];

int bfs(int start, int N)
{
	int ans = 0;
	int visited[51];
	queue<loc> q;

	memset(visited, 0, sizeof(visited));
	q.push({start, 0});
	visited[start] = 1;
	while (!q.empty())
	{
		int start = q.front().data;
		int depth = q.front().depth;
		if (depth >= 2)
			break;
		q.pop();
		/* 
		auto 연산자는 알아서 형태를 지정한다. 
		여기서는 std::iterator 이므로 포인터를 붙여야 실제 값이 나온다.
		*/
		for (auto i = v[start].begin(); i != v[start].end(); i++)
		{
			/* 새로운 노드 발견 시 탐색 진행한다. */
			if (!visited[*i])
			{
				visited[*i] = 1;
				q.push({*i, depth + 1});
			}
		}
	}
	for (int i = 0; i < N; i++)
		if (visited[i])
			ans++;
	return (ans - 1);
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, maxnum, ans;
	string str;
	int arr[51];

	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> str;
		for (int j = 0; j < N; j++)
		{
			if (str[j] == 'Y')
			{
				v[i].push_back(j);
				v[j].push_back(i);
			}
		}
	}
	maxnum = 0;
	ans = 0;
	for (int i = 0; i < N; i++)
	{
		/* 깊이가 2인 노드의 개수, arr 인덱스에 저장한다. */
		arr[i] = bfs(i, N);
		maxnum = max(maxnum, arr[i]);
	}
	/* 최댓값에 해당하는 인덱스를 오름차순으로 출력한다. */
	for (int i = 0; i < N; i++)
	{
		if (maxnum == arr[i])
		{
			cout << arr[i];
			return (0);
		}
	}
	return (0);
}