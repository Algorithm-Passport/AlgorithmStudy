#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
int N;
char Map[51][51];
using namespace std;
void Input(void)
{
	ios::sync_with_stdio(0);
	cin >> N;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
		{
			cin >> Map[i][j];
		}
}

int Check_horizontal(void)
{
	int max_cnt = 1;

	for (int i = 0; i < N; i++)
	{
		int cnt = 1;
		for (int j =0; j < N - 1; j++)
		{
			if (Map[i][j] == Map[i][j+1])
			{
				cnt++;
				max_cnt = max(max_cnt, cnt);
			}
			else
			{
				max_cnt = max(max_cnt, cnt);
				cnt = 1;
			}
		}
	}
	return (max_cnt);
}

int	Check_vertical(void)
{
	int max_cnt = 1;
	for (int i = 0; i < N ; i++)
	{
		int cnt = 1;
		for (int j = 0; j < N - 1; j++)
		{
			if (Map[j][i] == Map[j + 1][i])
			{
				cnt++;
				max_cnt = max(max_cnt, cnt);
			}
			else
			{
				max_cnt = max(max_cnt, cnt);
				cnt = 1;
			}
		}
	}
	return (max_cnt);
}
int		g_cnt;

int		main(void)
{
	Input();
	int cnt1;
	int cnt2;
	for (int i = 0; i < N; i++)
		for (int j =0; j < N; j++)
		{
			if (j != N - 1)
			{
				char temp;
				temp = Map[i][j];
				Map[i][j] = Map[i][j+1];
				Map[i][j+1] = temp;
				g_cnt = max(g_cnt,max(Check_horizontal(), Check_vertical()));
				Map[i][j+1] = Map[i][j];
				Map[i][j] = temp;
			}
			if (i != N - 1)
			{
				char temp;
				temp = Map[i][j];
				Map[i][j] = Map[i + 1][j];
				Map[i + 1][j] = temp;
				g_cnt = max(g_cnt, max(Check_horizontal(), Check_vertical()));
				Map[i + 1][j] = Map[i][j];
				Map[i][j] = temp;
			}
		}
	cout << g_cnt << '\n';
}




