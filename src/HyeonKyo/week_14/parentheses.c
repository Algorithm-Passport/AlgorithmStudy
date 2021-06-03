#include <stdio.h>
//점화식이 틀렸음 => 점화식을 찾는 것이 핵심.
int	main()
{
	int			T, i, j, k, n, sum;
	int			L[101] = {0, };
	long long	dp[5001] = {0, };

	scanf("%d", &T);
	for (i = 1; i <= T; i++)
		scanf("%d", L + i);
	dp[2] = 1;
	dp[4] = 2;
	sum = 0;
	for (i = 1; i <= T; i++)
	{
		if (L[i] % 2)
			printf("0\n");
		else
		{
			n = L[i] / 2;
			for (j = 6; j <= L[i]; j += 2)
				for (k = 1; k <= (n / 2); k++)
					dp[j] += (dp[2 * (n - k)] + dp[2 * k]) * (dp[2 * (n - k)] * dp[2 * k]);
			printf("%lld\n", (dp[L[i]] % 1000000007));
		}
		
	}
	return (0);
}