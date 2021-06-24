#include <stdio.h>

long long	find_height(int N, long long *tree, long long M, long long max, long long min);

int	main()
{
	int			N, i;
	long long	M, tmp, max, min, base, sum = 0;
	long long	tree[1000000] = {0, };

	scanf("%d %lld", &N, &M);
	for (i = 0; i < N; i++)
	{
		scanf("%lld", tree + i);
		if (tree[i] > max)
			max = tree[i];
	}
	min = 0;
	base = find_height(N, tree, M, max, min);
	printf("%lld\n", base);
	
	return (0);
}

long long	find_height(int N, long long *tree, long long M, long long max, long long min)
{
	long long	mid, sum = 0;
	int			i = 0;

	sum = 0;
	mid = (max + min) / 2;
	if (min > max)
		return (mid);
	for (i = 0; i < N; i++)
		if (tree[i] - mid > 0)
			sum += tree[i] - mid;
	if (sum < M)
		max = mid - 1;
	else
		min = mid + 1;
	find_height(N, tree, M, max, min);
}