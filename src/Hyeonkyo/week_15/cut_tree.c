#include <stdio.h>

long long	find_height(int N, long long *tree, long long M, long long max, long long min);

int	main()
{
	int			N, i;
	long long	M, tmp, max, min, base, sum = 0;
	long long	tree[1000000] = {0, };

	scanf("%d %lld", &N, &M);
	for (i = 0; i < N; i++)//입력을 받으면서 최댓 값 저장
	{
		scanf("%lld", tree + i);
		if (tree[i] > max)
			max = tree[i];
	}
	min = 0;
	base = find_height(N, tree, M, max, min);//최댓값과 최솟값을 재귀로 이분탐색
	printf("%lld\n", base);
	
	return (0);
}

long long	find_height(int N, long long *tree, long long M, long long max, long long min)
{
	long long	mid, sum = 0;
	int			i = 0;

	sum = 0;
	mid = (max + min) / 2;
	//재귀 종료 조건
	if (min > max)
		return (mid);
	//sum에 기준 높이에 의해 잘리는 나무의 길이를 모두 더함.
	for (i = 0; i < N; i++)
		if (tree[i] - mid > 0)
			sum += tree[i] - mid;
	//sum의 결과로 이분탐색의 좌 우 기준점을 바꿔주면서 재귀로 이분탐색 수행
	if (sum < M)
		max = mid - 1;
	else
		min = mid + 1;
	find_height(N, tree, M, max, min);
}