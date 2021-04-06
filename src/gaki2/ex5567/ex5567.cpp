#include <iostream>
#include <set>
int N, M;
int	List[10001][2];
using namespace std;
int friends[501] ;
int is_double[501] = {1,1};

void Cal()
{
	ios::sync_with_stdio(0);
	cin >> N >> M;
	for (int i =0; i < M; i++)
	{
		cin >> List[i][0] >> List[i][1];
		if (List[i][0] == 1)
		{
			friends[List[i][1]] = 1;
			is_double[List[i][1]] = 1;
		}
	}

	for (int i = 0; i < M; i++)
	{
		if (friends[List[i][0]] == 1 && !is_double[List[i][1]])
		{
			is_double[List[i][1]] = 1;
			friends[List[i][1]] = 2;
		}
		if (friends[List[i][1]] == 1 && !is_double[List[i][0]])
		{
			is_double[List[i][0]] = 1;
			friends[List[i][0]] = 2;
		}
	}
}

int main(void)
{
	Cal();
	int cnt = 0;
	for (int i = 2; i <= N; i++)
		if (friends[i] == 1 || friends[i] == 2)
			cnt++;
	cout << cnt << '\n';
}

