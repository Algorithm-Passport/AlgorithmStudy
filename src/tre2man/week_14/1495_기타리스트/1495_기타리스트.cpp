#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

/*
다이나믹 프로그래밍을 이용한다.
다음 경우에 대해서 결과가 범위 안에 들어오게 되면 결과 좌표에 true를 표시한다.
마지막 라인에서 최댓값을 찾아낸다. 최댓값이 없으면 -1을 출력한다.
*/

int main()
{
	int N, S, M, ans = -1;
	int arr[101];
	bool dp[101][1001];

	cin >> N >> S >> M;
	for (int i = 1; i <= N; i++)
		cin >> arr[i];

	if (S - arr[1] >= 0)
		dp[1][S - arr[1]] = true;
	if (S + arr[1] <= M)
		dp[1][S + arr[1]] = true;
	for (int i = 2; i <= N; i++)
	{
		for (int j = 0; j <= M; j++)
		{
			if (dp[i - 1][j])
			{
				if (j - arr[i] >= 0)
					dp[i][j - arr[i]] = true;
				if (j + arr[i] <= M)
					dp[i][j + arr[i]] = true;
			}
		}
	}
	for (int i = 0; i <= M; i++)
		if (dp[N][i])
			ans = max(ans, i);
	cout << ans;
	return (0);
}
