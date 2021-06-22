#include <bits/stdc++.h>
using namespace std;

/*
우선순위 큐를 이용하여 구현했다.
c와 입출력 동기화를 풀어서 시간초과가 안나게 했다.
*/

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int num, temp;
	priority_queue<int, vector<int>, greater<int>> q;

	cin >> num;
	while (num--)
	{
		cin >> temp;
		if (!temp)
		{
			if (!q.size())
				cout << "0" << "\n";
			else
			{
				cout << q.top() << "\n";
				q.pop();
			}
		}
		else
			q.push(temp);
	}
	return (0);
}