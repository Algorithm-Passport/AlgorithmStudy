#include <stdio.h>
#include <string.h>

int arr[5][5];
int	buf[1000000];

void	find(int i, int j, int num, int n);

int main()
{
	int i, j, num, cnt = 0;

	for (i = 0; i < 5; i++)
		for (j = 0; j < 5; j++)
			scanf("%d", &(arr[i][j]));
	memset(buf, 0, sizeof(buf));
	find(0, 0, 0, 0);
	for (i = 0; i < 1000000; i++)
	{
		if (buf[i])
			cnt++;
	}
	printf("%d\n", cnt);
	return (0);
}

void	find(int i, int j, int num, int n)
{
	if (n == 6)
	{
		if (buf[num] == 0)
			buf[num] = 1;
		return ;
	}
	if (i - 1 >= 0)
		find(i - 1, j, num * 10 + arr[i][j], n + 1);
	if (j - 1 >= 0)
		find(i, j - 1, num * 10 + arr[i][j], n + 1);
	if (i + 1 < 5)
		find(i + 1, j, num * 10 + arr[i][j], n + 1);
	if (j + 1 < 5)
		find(i, j + 1, num * 10 + arr[i][j], n + 1);
}

// 1. 2차원 5 x 5배열에 입력을 받음.
// 	2. 0,0에서 시작하여 재귀로 모든 경우의 수 탐색
// 	3. 6개의 숫자가 저장된 배열을 서로 비교함.(strcpy)
// 	4. 같지 않으면 그 배열을 buf에 저장함. (인덱스가 카운트가 됨)