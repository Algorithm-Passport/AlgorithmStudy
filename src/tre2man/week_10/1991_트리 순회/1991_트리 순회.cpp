#include <bits/stdc++.h>
using namespace std;

/*
c++에 트리 구조인 set 자료형이 있으나, 사용법을 잘 몰라서 string 제외, c로 풀이.
탐색 범위에 대해서 다시한번 생각하게 한 문제임.
부모 노드가 트리에 없을 경우도 있기 때문에, 부모 노드가 존재하는 것부터 삽입한다.

자식노드 = 부모노드 *2 (+1) 의 조건을 잘 이해했어야 한다.
다음에는 구조체 포인터를 이용해봐야겠다.
*/

#define SEARCH_MAX 100000

char arr[SEARCH_MAX + 1];

/* 전위 순회 */
void preOrder(int start)
{
	if (arr[start] != '.')
		cout << arr[start];
	if (arr[start * 2] != '.')
		preOrder(start * 2);
	if (arr[start * 2 + 1] != '.')
		preOrder(start * 2 + 1);
}

/* 중위 순회 */
void inOrder(int start)
{
	if (arr[start * 2] != '.')
		inOrder(start * 2);
	if (arr[start] != '.')
		cout << arr[start];
	if (arr[start * 2 + 1] != '.')
		inOrder(start * 2 + 1);
}

/* 후위 순회 */
void postOrder(int start)
{
	if (arr[start * 2] != '.')
		postOrder(start * 2);
	if (arr[start * 2 + 1] != '.')
		postOrder(start * 2 + 1);
	if (arr[start] != '.')
		cout << arr[start];
}

/* 트리에 해당 문자가 존재하는지 확인*/
int findChar(char c)
{
	if (c == 'A')
		return (0);
	for (int i = 1; i <= SEARCH_MAX; i++)
		if (arr[i] == c)
			return (i);
	return (0);
}

/* 트리에 입력 데이터를 올바를 위치에 두기 */
void inputChar(string s)
{
	int i;

	if (s[0] == 'A')
	{
		arr[1] = s[0];
		arr[2] = s[2];
		arr[3] = s[4];
	}
	else
	{
		i = findChar(s[0]);
		arr[i] = s[0];
		arr[i * 2] = s[2];
		arr[i * 2 + 1] = s[4];
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N;
	string s[27];

	memset(arr, '.', sizeof(arr));
	arr[1] = 'A';
	cin >> N;
	/* getline 함수를 사용하면 s[0]에는 개행 문자만 입력되더라. */
	for (int i = 0; i <= N; i++)
		getline(cin, s[i]);
	/* 최상단 노드 채우기 */
	for (int i = 1; i <= N; i++)
		if (s[i][0] == 'A')
			inputChar(s[i]);
	/* 부모노드가 존재하면 채우기 */
	for (int i = 1; i <= SEARCH_MAX; i++)
		for (int j = 0; j <= N; j++)
			if (arr[i] == s[j][0])
				inputChar(s[j]);
	/* 나머지 노드 채우기 */
	for (int i = 1; i <= SEARCH_MAX; i++)
		for (int j = 0; j <= N; j++)
			if (arr[i] == s[j][0])
				inputChar(s[j]);
	/* 순서대로 탐색하기 */
	preOrder(1);
	cout << "\n";
	inOrder(1);
	cout << "\n";
	postOrder(1);
	cout << "\n";
	return (0);
}