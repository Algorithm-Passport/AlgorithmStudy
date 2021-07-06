#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct deque
{
	int *buf;
	int f_idx;
	int l_idx;
	int check;
}t_deque;

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

void	insert_queue(t_deque *que, int n, char *arr)
{
	que->f_idx = 0;
	que->l_idx = n - 1;
	if (n == 0)
	{
		que->l_idx = 0;
		que->buf = 0;
		return ;
	}
	que->check = 1;
	que->buf = (int *)malloc(n * sizeof(int));
	ft_split(que->buf, arr);
}

void	fun_R(t_deque *que)
{
	que->check *= -1;
}

int	fun_D(t_deque *que)
{
	if (que->f_idx >= que->l_idx)
		return (0);
	if (que->check > 0)
		que->f_idx++;
	else
		que->l_idx--;
	return (1);
}

void	print_buf(int n, t_deque que)
{
	int i = 0;

	if (n == 0)
	{
		printf("[]\n");
		return ;
	}
	printf("[");
	if (que.check > 0)
	{
		for (i = que.f_idx; i <= que.l_idx; i++)
		{
			if (i != que.l_idx)
				printf("%d,", que.buf[i]);
			else
				printf("%d]\n", que.buf[i]);
		}
	}
	else
	{
		for (i = que.l_idx; i >= que.f_idx; i--)
		{
			if (i != que.f_idx)
				printf("%d,", que.buf[i]);
			else
				printf("%d]\n", que.buf[i]);
		}
	}
}

int main()
{
	int T, n, i, ret = 0;
	char	P[100001];
	char	arr[200010];
	t_deque	que;

	scanf("%d", &T);
	while (T--)
	{
		scanf("%s", P);
		scanf("%d", &n);
		scanf("%s", arr);
		insert_queue(&que, n, arr);
		i = 0;
		ret = 1;
		while (P[i])
		{
			if (P[i] == 'R')
				fun_R(&que);
			else
			{
				if (!(ret = fun_D(&que)))
				{
					printf("error\n");
					break ;
				}
			}
			i++;
		}
		if (ret)
			print_buf(n, que);
		if (que.buf)
			free(que.buf);
		que.buf = 0;
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
		len - 1까지 que.buf[i] = buf[i + 1]
		len--
	5. P의 처음부터 끝까지 함수 확인하며 실행
	6. '['출력, buf숫자 1개, ','1개출력 len까지
		만약 len번째 숫자 출력이면 ','말고 ']'출력
	7. input부터 6까지 T만큼 반복
*/