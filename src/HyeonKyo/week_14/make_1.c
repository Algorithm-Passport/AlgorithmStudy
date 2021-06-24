#include <stdio.h>

int		find_min(int n1, int n2, int n3)
{
	int	min = 0;

	if (n1 > n2)
		min = n2;
	else
		min = n1;
	if (min > n3)
		min = n3;
	return (min);
}

void	find_dp(int n, int *dp)
{
	int cnt1; // n이 3의 배수인 경우
	int	cnt2;// n이 2의 배수인 경우
	int	cnt3;// n이 1보다 커서 -1이 가능한 경우
	int	i;
	
	i = 4;
	while (++i <= n)
	{
		if (dp[i])
			continue ;
		if (i % 3 == 0)
			cnt1 = dp[i / 3];
		else
			cnt1 = 1000000;
		if (i % 2 == 0)
			cnt2 = dp[i / 2];
		else
			cnt2 = 1000000;
		cnt3 = dp[i - 1];
		dp[i] = find_min(cnt1, cnt2, cnt3) + 1;
	}
	printf("%d\n", dp[n]);
}

int	main()
{
	int dp[1000001] = {0, };
	int	n = 0;
	
	//메모이제이션의 초기 참고 값들
	dp[1] = 0;
	dp[2] = 1;
	dp[3] = 1;
	dp[4] = 2;
	//입력 받음
	scanf("%d", &n);
	//상향식 계산법으로 dp를 채움.
	find_dp(n, dp);

	return (0);
}