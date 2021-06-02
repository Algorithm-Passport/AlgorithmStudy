#include <iostream>
#include <algorithm>

#define MOD 1000000007

using namespace std;

long long ans[5001];

void cal()
{
	ans[0] = 1;
	ans[1] = 1;
	for (int i = 2; i <= 5000; i++)
	{
		for (int j = 0; j < i; j++)
		{
			ans[i] += ans[j] * ans[i - j - 1];
			ans[i] %= MOD;
		}
		ans[i] %= MOD;
	}
}

int main()
{
	int T, L, temp;

	cal();
	cin >> T;
	while (T--)
	{
		cin >> L;
		/* 짝수일 때 */
		if (!(L & 1))
			cout << ans[L / 2] << "\n";
		else
			cout << "0\n";
	}
	return (0);
}