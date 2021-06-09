#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	vector<int> v;
	int N, C, temp, cnt, len, res;

	cin >> N >> C;
	for (int i = 0; i < N; i++)
	{
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	int front = 1, rear = v[N - 1] - v[0], mid;
	while (front <= rear)
	{
		/* 공유기 사이의 거리를 최대로 할려면 맨 앞의 집에 공유기가 설치되어야 한다. */
		cnt = 1;
		temp = v[0];
		mid = (front + rear) / 2;
		/* 현재 탐색할려는 거리(mid)에서 체크하기 */
		for (int i = 1; i < N; i++)
		{
			len = v[i] - temp;
			/* 다음 칸에 해당하는 집이 없다면 */
			if (mid <= len)
			{
				cnt++;
				temp = v[i];
			}
		}
		if (cnt >= C)
		{
			res = mid;
			front = mid + 1;
		}
		else
			rear = mid - 1;
	}
	cout << res;
	return (0);
}