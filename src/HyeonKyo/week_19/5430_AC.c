#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int	ft_isdigit(int c)
{
	if (c >= '0' && c <= '9')
		return (1);
	return (0);
}

void	ft_split(int *buf, char *arr)
{
	int i, j, num = 0;

	i = 0;
	j = 0;
	while (arr[i])
	{
		if (!ft_isdigit(arr[i]))
			i++;
		num = 0;
		while (ft_isdigit(arr[i]))
			num = num * 10 + (arr[i++] - '0');
		buf[j++] = num;
		if (arr[i] == ']')
			return ;	
	}
}

void	fun_R(int len, int *buf)
{
	int i, n = 0;
	int *tmp;
	
	tmp = (int *)malloc(len * sizeof(int));
	for (i = 0; i < len; i++)
		tmp[i] = buf[i];
	n = len;
	for (i = 0; i < len; i++)
		buf[i] = tmp[--n];
	free(tmp);
	tmp = 0;
}

int	fun_D(int *len, int *buf)
{
	int i = 0;

	if (*len == 0)
		return (0);
	for (i = 0; i < *len - 1; i++)
		buf[i] = buf[i + 1];
	(*len)--;
	return (1);
}

void	print_buf(int len, int *buf)
{
	int i = 0;

	printf("[");
	for (i = 0; i < len; i++)
	{
		if (i != len - 1)
			printf("%d,", buf[i]);
		else
			printf("%d]\n", buf[i]);
	}
}

int main()
{
	int T, n, i, ret = 0;
	char	P[100001];
	char	arr[200010];
	int		*buf;

	scanf("%d", &T);
	while (T--)
	{
		scanf("%s", P);
		scanf("%d", &n);
		scanf("%s", arr);
		buf = (int *)malloc(n * sizeof(int));
		ft_split(buf, arr);
		i = 0;
		while (P[i])
		{
			if (P[i] == 'R')
				fun_R(n, buf);
			else
			{
				if (!(ret = fun_D(&n, buf)))
				{
					printf("error\n");
					break ;
				}
			}
			i++;
		}
		if (ret)
			print_buf(n, buf);
		free(buf);
		buf = 0;
	}
	return (0);
}

/*
	1. input
		1. P에 함수 문자열 받음
		2. 숫자를 n에 받음
		3. arr에 문자열 받음
	2. buf에 arr에 있는 숫자만 옮김(split), len(숫자개수)리턴
	3. R함수
		1. i = 0, j = len - 1
		2. len만큼 배열 할당 후 buf복사
		3. buf에 만든 배열의 역순 저장j -> 0
		4. 만든 배열 free
	4. D함수
		len - 1까지 buf[i] = buf[i + 1]
		len--
	5. P의 처음부터 끝까지 함수 확인하며 실행
	6. '['출력, buf숫자 1개, ','1개출력 len까지
		만약 len번째 숫자 출력이면 ','말고 ']'출력
	7. input부터 6까지 T만큼 반복
*/