#include <iostream>
#include <cstring>
using namespace std;

int block[501];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int h, w, ans = 0, temp, isWater;
	cin >> h >> w;
	for (int i = 0; i < w; i++)
		cin >> block[i];
	for (int dep = 1; dep <= h; dep++)
	{
		isWater = 0;
		temp = 0;
		for (int i = 0; i < w - 1; i++)
		{
			if (isWater)
			{
				ans++;
				temp++;
			}
			if ((block[i] - dep >= 0) && (block[i + 1] - dep < 0))
				isWater = 1;
			if ((block[i] - dep < 0) && (block[i + 1] - dep >= 0))
			{
				isWater = 0;
				temp = 0;
			}
		}
		ans -= temp;
	}
	cout << ans;
}