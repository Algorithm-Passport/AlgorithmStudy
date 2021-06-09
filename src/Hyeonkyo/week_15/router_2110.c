#include <stdio.h>
#include <stdlib.h>

int	compare(const void *a, const void *b)//qsort를 사용하기 위한 비교함수
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
	long long	arr[200000] = {0, };//집의 좌표값을 저장할 배열.

	//입력 받은 후 배열 정렬
	scanf("%d %d", &N, &C);
	for (i = 0; i < N; i++)
		scanf("%lld", arr + i);
	qsort(arr, N, sizeof(long long), compare);
	//거리 값으로 이분탐색 시작
	max = arr[N - 1] - arr[0];//공유기 설치 가능 최대 거리
	min = 1;//최소 거리
	while (min <= max)
	{
		mid = (max + min) / 2;//설치 가능 최대 거리, 최소 거리의 중간
		base = arr[0];//공유기 설치의 시작점은 무조건 첫번째 좌표이다.
		cnt = 1;//공유기 설치 대수를 나타냄, arr[0]에 무조건 하나를 설치하므로 초기값이 1임.
		for (i = 1; i < N; i++)
		{
			if (arr[i] - base >= mid)//기준 거리(mid)보다 거리가 멀면 공유기를 설치하고 카운트 + 1을 해줌.
			{
				cnt++;
				base = arr[i];
			}
		}
		if (cnt >= C)//cnt > C라는 것은 설치 대수가 많다는 것이므로 기준 거리를 늘려야함. 고로 min값이 mid값을 가짐.
		{
			min = mid + 1;
			if (mid > past)
				past = mid;
		}
		else//반대의 경우.
			max = mid - 1;
	}
	printf("%lld\n", past);
	return (0);
}