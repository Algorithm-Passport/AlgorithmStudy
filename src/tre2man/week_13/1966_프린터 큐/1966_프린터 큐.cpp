#include <bits/stdc++.h>
using namespace std;

/*
자료구조에 정말 약한 것 같네요. 질문들을 많이 참고했습니다.

여기서는 우선순위 큐를 이용하여 풀이했습니다.
우선순위 큐에 들어간 숫자들은 자동으로 오름차순으로 정렬이 됩니다.
또 다른 큐에는 해당 칸의 위치와 값을 넣어줍니다.
만약 우선순위가 크거나 같을 경우 큐를 pop 해주고, 위치와 m이 같게 되면 답을 출력합니다.
우선순위 큐 때문에 뒤에서 하나씩 빼주면 됩니다.
*/

typedef struct
{
	int a;
	int b;
} node;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int t_case, m, n, b, ans = 0;

	cin >> t_case;
	while (t_case--)
	{
		queue<node> q;
		priority_queue<int> pq;
		ans = 0;
		cin >> n >> m;
		for (int i = 0; i < n; i++)
		{
			cin >> b;
			q.push({i, b});
			pq.push(b);
		}
		while (!q.empty())
		{
			int idx = q.front().a;
			int val = q.front().b;
			q.pop();
			if (pq.top() == val)
			{
				pq.pop();
				ans++;
				if (idx == m)
				{
					cout << ans << "\n";
					break;
				}
			}
			else
				q.push({idx, val});
		}
	}
	return (0);
}