#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

/*
bfs를 이용하여 구현했다.
bfs를 통하여 탐색을 할 때 새로운 노드를 발견했을 때 탐색 횟수를 늘린다.
*/

vector<int> v[10001];

int bfs(int start, int N)
{
	int ans = 0;
	int visited[10001] = {0};
	queue<int> q;

	q.push(start);
	visited[start] = 1;
	while(!q.empty())
	{
		int start = q.front();
		q.pop();
		/* 
		auto 연산자는 알아서 형태를 지정한다. 
		여기서는 std::iterator 이므로 포인터를 붙여야 실제 값이 나온다.
		*/
		for(auto i = v[start].begin(); i != v[start].end(); i++)
		{
			/* 새로운 노드 발견 시 탐색 진행한다. */
			if (!visited[*i])
			{
				visited[*i] = 1;
				q.push(*i);
				ans++;
			}
		}
	}
	return (ans);
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, M, a, b, ans;
	int arr[10001];

	cin >> N >> M;
	while (M--)
	{
		cin >> a >> b;
		/*
		b를 해킹하면 a도 해킹할 수 있으므로, 단방향 노드를 설정한다.
		b에서 a로는 탐색이 가능하지만, 반대로는 탐색이 불가능하다.
		*/
		v[b].push_back(a);
	}
	ans = 0;
	for (int i = 1; i <= N; i++)
	{
		/* 몇번 탐색했는지, arr 인덱스에 저장한다. */
		arr[i] = bfs(i, N);
		ans = max(ans, arr[i]);
	}
	/* 최댓값에 해당하는 인덱스를 오름차순으로 출력한다. */
	for (int i = 1; i <= N; i++)
		if (ans == arr[i])
			cout << i << " ";
	return (0);
}