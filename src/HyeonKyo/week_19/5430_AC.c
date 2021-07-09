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
	//숫자를 찾아서 정수형 배열 buf에 넣어줌.
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
	//n은 input 수열 개수로, 0인경우 예외처리
	if (n == 0)
	{
		que->l_idx = 0;
		que->buf = 0;
		return ;
	}
	que->check = 1;
	//que의 정수형 배열인 buf할당 후 숫자값 넣어줌.
	que->buf = (int *)malloc(n * sizeof(int));
	ft_split(que->buf, arr);
}

void	fun_R(t_deque *que)
{
	if (que->f_idx >= que->l_idx)
		return ;
	que->check *= -1;//음수면 역순, 양수면 정순
}

int	fun_D(t_deque *que)
{
	if (que->f_idx >= que->l_idx)//buf에 데이터 없는 경우
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
	//숫자가 없을 때 예외처리
	if (n == 0)
	{
		printf("[]\n");
		return ;
	}
	printf("[");
	if (que.check > 0)//정순 출력
	{
		for (i = que.f_idx; i <= que.l_idx; i++)
		{
			if (i != que.l_idx)
				printf("%d,", que.buf[i]);
			else
				printf("%d]\n", que.buf[i]);
		}
	}
	else//역순 출력
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
		//숫자 입력을 정수형 배열에 옮겨줌.
		scanf("%s", P);
		scanf("%d", &n);
		scanf("%s", arr);
		insert_queue(&que, n, arr);
		i = 0;
		ret = 1;
		//명령어 하나씩 확인하며 수행
		while (P[i])
		{
			if (P[i] == 'R')
				fun_R(&que);
			else
			{
				//숫자가 없는데 D 수행시 error처리
				if (!(ret = fun_D(&que)))
				{
					printf("error\n");
					break ;
				}
			}
			i++;
		}
		//error처리 안됐을 시 정상 출력
		if (ret)
			print_buf(n, que);
		//que초기화 후 반복
		if (que.buf)
			free(que.buf);
		que.buf = 0;
	}
	return (0);
}

/*
	1. 자료구조 : 덱(+정수 배열, 배열의 시작 index, 끝 index)
	2. R는 check가 양수인지 음수인지로 판별
	3. D는 시작 or 끝의 index를 하나 뒤로 미뤄서 처리함.
	4. check에 맞는 순서로 출력
*/