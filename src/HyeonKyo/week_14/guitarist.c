#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int	main()
{
	int		N, S, M, i, j, cur_vol, flag, max;
	int		vol[101] = {0, };
	bool	dp[100][1001];//1: N번째 곡 2: 가능 볼륨값 = true
	//초기화 및 입력 저장
	memset(dp, 0, sizeof(dp));
	scanf("%d %d %d", &N, &S, &M);
	for (i = 0; i < N; i++)
		scanf("%d", vol + i + 1);
	//dp의 초기값
	dp[0][S] = 1;
	//i번째 곡까지의 가능 볼륨
	for (i = 1; i <= N; i++)
	{
		cur_vol = vol[i];
		flag = 1;//허용 가능 볼륨 존재 여부 확인
		for (j = 0; j <= M; j++)
		{
			if (dp[i - 1][j])//이전 곡의 허용 볼륨
			{
				if (j - cur_vol >= 0)//가능 볼륨 범위인지
				{
					dp[i][j - cur_vol] = 1;
					flag = 0;
				}
				if (j + cur_vol <= M)
				{
					dp[i][j + cur_vol] = 1;
					flag = 0;
				}
			}
		}
		if (flag)//허용 볼륨 존재하지 않을 때
		{
			printf("-1\n");
			return (0);
		}
	}
	for (i = 0; i <= M; i++)//N번째 곡의 최대 볼륨 값 찾아서 출력
	{
		if (dp[N][i])
			max = i;
	}
	printf("%d\n", max);
	return (0);
}