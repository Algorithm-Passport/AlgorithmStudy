#include <stdio.h>
#include <stdlib.h>

int	compare(const void *a, const void *b)//비교 함수.
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

int		find_down_idx(int *arr, int base, int N);
int		find_up_idx(int *arr, int base, int H, int N);

int	main()
{
	int	N, H, n, i, j, base, past, cnt = 0;
	int	down[100000], up[100000] = {0, };
	//입력
	scanf("%d %d", &N, &H);
	for (i = 0; i < N / 2; i++)
	{
		scanf("%d", down + i);
		scanf("%d", up + i);
	}
	//정렬
	qsort(up, N / 2, sizeof(int), compare);
	qsort(down, N / 2, sizeof(int), compare);
	
	past = N / 2;//past는 이전의 실행동안 만난 장애물의 최솟값.
	cnt = 2;//장애물을 최소로 만나는 구간의 개수.
	//구간 1, H인 지점은 항상 장애물을 (N/2)개 만큼만 만남 / 따라서 이전의 최솟값 = N/2, 동일 구간 개수 = 2로 시작함. 
	for (base = 2; base < H; base++)//구간 2부터 H - 1까지 탐색.
	{
		//구간 n인 곳의 장애물 개수 = (높이 >= n인 석순(down) 개수) + (H - 높이 > n)인 종유석(up) 개수
		n = find_down_idx(down, base, N) + find_up_idx(up, base, H, N);
		//그 장애물의 개수가 이전의 최소 장애물보다 적다면 past = n, 개수 = 1로 변경
		if (past > n)
		{
			past = n;
			cnt = 1;
		}
		else if (past == n)
			cnt++;
	}
	//구간 전부 탐색 후 출력.
	printf("%d %d\n", past, cnt);
	return (0);
}

int		find_down_idx(int *arr, int base, int N)
{
	//높이 >= n인 석순(down) 개수 찾기.
	int idx, left, right = 0;

	left = 0;
	right = N / 2;
	//이분 탐색으로 높이 >= n인 석순(down)의 개수를 찾음.
	while (left <= right)
	{
		idx = (left + right) / 2;
		if (arr[idx] > base)
			right = idx - 1;
		else
			left = idx + 1;
	}
	//base(구간 높이)보다 작은 장애물은 걸리지 않음.
	//따라서 base에 걸리는 장애물의 첫 인덱스(개수)를 찾아줌.
	while (arr[idx] <= base && idx < N / 2)
		idx++;
	return ((N / 2) - idx);//N/2 - idx 를 하면 구간에 걸리는 석순 장애물의 개수가 나옴.
}

int		find_up_idx(int *arr, int base, int H, int N)
{
	//(H - 높이 > n)인 종유석 개수 찾기.
	int idx, left, right = 0;

	left = 0;
	right = N / 2;
	while (left <= right)
	{
		idx = (left + right) / 2;
		if (arr[idx] > H - base)
			right = idx - 1;
		else
			left = idx + 1;
	}
	while (arr[idx] <= H - base && idx < N / 2)
		idx++;
	return ((N / 2) - idx);
}


//printf("idx : %d, arr[idx] : %d, H - base : %d", idx, arr[idx], H - base);
/*
구간 1인 곳의 장애물 개수 = 석순 개수
구간 H인 곳의 장애물 개수 = 종유석 개수 = N / 2
구간 n인 곳의 장애물 개수 = (높이 >= n인 석순 개수) + (H - 높이 > n)인 종유석 개수
구간n은 H만큼 있음(2 <= n <= H)
장애물은 N개 있음.
*/