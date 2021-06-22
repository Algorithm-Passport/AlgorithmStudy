#include <bits/stdc++.h>
#define MAX 32000
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, M;
	int dgree[MAX + 1];
	vector<int> v[MAX + 1];
	priority_queue<int, vector<int>, greater<int>> pq;

	cin >> N >> M;

	// 그래프 제작
	for (int i = 0; i < M; i++)
	{
		int a, b;
		cin >> a >> b;
		dgree[b]++;
		v[a].push_back(b);
	}

	// 목적지가 0인겅우 pq에 추가
	for (int i = 1; i <= N; i++)
		if (dgree[i] == 0)
			pq.push(i);

	// 탐색 시작하기
	while (!pq.empty())
	{
		int node = pq.top();
		pq.pop();
		cout << node << " ";

		for (int i = 0; i < v[node].size(); i++)
		{
			int nxnode = v[node][i];
			if (--dgree[nxnode] == 0)
				pq.push(nxnode);
		}
	}
	return (0);
}