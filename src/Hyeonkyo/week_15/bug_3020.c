#include <stdio.h>
#include <stdlib.h>

int	compare(const void *a, const void *b)
{
	int	num1 = *(int *)a;
	int	num2 = *(int *)b;

	if (num1 < num2)
		return (-1);
	else if (num1 > num2)
		return (1);
	else
		return (0);
}

int		find_idx1(int *arr, int base);
int		find_idx2(int *arr, int base, int H);

int	main()
{
	int	N, H, n, i, j, max, min, mid, past, cnt = 0;
	int	down[100000], up[100000] = {0, };

	scanf("%d %d", &N, &H);
	for (i = 0; i < N / 2; i++)
	{
		scanf("%d", down + i);
		scanf("%d", up + i);
	}
	qsort(up, N / 2, sizeof(int), compare);
	qsort(down, N / 2, sizeof(int), compare);

	max = H;
	min = 1;
	past = N / 2;
	n = 2;
	while (min < max)
	{
		mid = (max + min) / 2;
		i = find_idx1(down, mid);
		j = find_idx2(up, mid, H);
		cnt = N - i - j;
		if (past > cnt)
		{
			past = cnt;
			n = 1;
		}
		else if (past == cnt)
			n++;
		if (i >= j)
			min = mid + 1;
		else if (i < j)
			max = mid - 1;
	}
	printf("%d %d", past, n);
	return (0);
}

int		find_idx1(int *arr, int base)
{
	int	i;

	i = 0;
	while (arr[i] < base)
		i++;
	return (i);
}

int		find_idx2(int *arr, int base, int H)
{
	int	i;

	i = 0;
	while (H - arr[i] >= base)
		i++;
	return (i);
}


void	find_cnt(int N, int H, int *up, int *down, int *past, int *n, int max, int min)
{
	int	mid, i, j, cnt = 0;

	if (min >= max)
		return ;
	mid = (max + min) / 2;
	i = find_idx1(down, mid);
	j = find_idx2(up, mid, H);
	cnt = N - i - j;
	printf("cnt : %d\n", cnt);
	if (*past > cnt)
	{
		*past = cnt;
		*n = 1;
	}
	else if (*past == cnt)
		(*n)++;
	if (i > j)
		find_cnt(N, H, up, down, past, n, max, mid + 1);
	else if (i < j)
		find_cnt(N, H, up, down, past, n, mid - 1, min);
	else
	{
		find_cnt(N, H, up, down, past, n, mid - 1, min);
		find_cnt(N, H, up, down, past, n, max, mid + 1);
	}
}

/*
구간 1인 곳의 장애물 개수 = 석순 개수
구간 H인 곳의 장애물 개수 = 종유석 개수 = N / 2
구간 n인 곳의 장애물 개수 = (높이 >= n인 석순 개수) + (H - 높이 > n)인 종유석 개수
구간n은 H만큼 있음(2 <= n <= H)
장애물은 N개 있음.

*/