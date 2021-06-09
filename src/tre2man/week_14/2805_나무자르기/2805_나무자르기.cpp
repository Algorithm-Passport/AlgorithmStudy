#include <iostream>
using namespace std;

/*
생각나는게 없어서 일단 재귀로 풀이
front와 rear를 변수로 두고, 그 둘의 평균을 기준으로 큰거 작은거 탐색한다.
재귀로 풀이하니 시간을 너무 많이 잡아먹는다.
*/

typedef long long ll;

ll arr[1000001];

/* 현재 높이의 나무 길이 반환 */
ll check(ll width, ll N)
{
	ll temp, ans = 0;

	for (int i = 1; i <= N; i++)
	{
		temp = arr[i] - width;
		if (temp > 0)
			ans += temp;
	}
	return (ans);
}

/* 실제 탐색하는 부분 */
ll find(ll front, ll rear, ll N, ll M)
{
	ll mid = (front + rear) / 2;
	ll checkNow = check(mid, N);
	if (front > rear)
		return (rear);
	if (checkNow == M)
		return (mid);
	else if (checkNow < M)
		return (find(front, mid - 1, N, M));
	else
		return (find(mid + 1, rear, N, M));
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	ll N, M, width, maxnum = 0, temp;
	cin >> N >> M;
	for (int i = 1; i <= N; i++)
	{
		cin >> arr[i];
		maxnum = max(maxnum, arr[i]);
	}
	cout << find(0, maxnum, N, M);
	return (0);
}
