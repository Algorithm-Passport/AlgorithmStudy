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

int	main()
{
	int			N, C, i, cnt = 0;
	long long	max, min, mid, base, past = 0;
	long long	arr[200000] = {0, };

	scanf("%d %d", &N, &C);
	for (i = 0; i < N; i++)
		scanf("%lld", arr + i);
	qsort(arr, N, sizeof(long long), compare);
	
	max = arr[N - 1] - arr[0];
	min = 1;
	while (min <= max)
	{
		mid = (max + min) / 2;
		base = arr[0];
		cnt = 1;
		for (i = 1; i < N; i++)
		{
			if (arr[i] - base >= mid)
			{
				cnt++;
				base = arr[i];
			}
		}
		if (cnt >= C)
		{
			min = mid + 1;
			if (mid > past)
				past = mid;
		}
		else
			max = mid - 1;
	}
	printf("%lld\n", past);
	return (0);
}