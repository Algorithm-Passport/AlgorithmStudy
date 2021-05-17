#include <iostream>
#include <stdbool.h>

using namespace std;

int		visit[15];
int		N;
int		g_cnt;

bool	is_valid(int row, int col)
{
	int		check;

	check = 0;
	while (check < row)
	{
		if (visit[check] == col || (row - check) == abs(col - visit[check]))
			return (false);
		check++;
	}
	return (true);
}

void	play_chess(int row, int col)
{
	int		next_col;

	next_col = 0;
	visit[row] = col;
	if (row == N - 1)
	{
		g_cnt++;
		return ;
	}
	while (next_col < N)
	{
		if (is_valid(row + 1, next_col))
			play_chess(row + 1, next_col);
		next_col++;
	}
}

int		main(void)
{
	cin >> N;

	for (int col = 0; col < N; col++)
	{
		play_chess(0, col);
	}
	cout << g_cnt << '\n';
	return (0);
}
