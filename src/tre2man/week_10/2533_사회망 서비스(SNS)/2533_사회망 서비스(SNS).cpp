#include <bits/stdc++.h>
using namespace std;

/*
dp와 tree 구조를 이용하여 푸는 문제.
상당한 난이도를 자랑한다.

내가 얼리면 친구들은 얼리여도 되고 아니여도 된다.
내가 얼리가 아니면 친구들은 무조건 얼리여야 한다.

그래프의 깊이의 원소 수에 따라서 배열에 저장 후 dp로 풀면 절대 안된다.
예외 케이스 :
9
1 2
1 3
2 4
3 5
3 6
4 7
4 8 
4 9
출력 : 3
*/

#define MAX_LEN 1000000

vector<int> v[MAX_LEN + 1];
int visited[MAX_LEN + 1];
int dp[MAX_LEN + 1][2];
int maxdepth;

void dfs(int start)
{
	visited[start] = 1;
	/* 0은 내가 얼리가 아닐때, 1은 내가 얼리일때 */
	dp[start][0] = 0;
	dp[start][1] = 1;
	for(auto i = v[start].begin(); i != v[start].end(); i++)
	{
		if(!visited[*i])
		{
			dfs(*i);
			/* 내가 얼리가 아니면, 친구들은 모두 얼리 */
			dp[start][0] += dp[*i][1]; 
			/* 내가 얼리면 친구들이 얼리 또는 얼리가 아니여도 됨 */
			dp[start][1] += min(dp[*i][0], dp[*i][1]);
		}
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, a, b;

	cin >> N;
	N--;
	while (N--)
	{
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	dfs(1);
	N == 2 ? cout << "1" : cout << min(dp[1][0], dp[1][1]);
	return (0);
}