#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct	s_st
{
	int idx;
	int h;
}				st;

st stack[500001];
int top = -1;

int	isempty(void)
{
	if (top < 0)
		return (1);
	return (0);
}

int isfull(void)
{
	if (top > 500000)
		return (1);
	return (0);
}

void	push(st *tmp)
{
	if (!isfull())
	{
		top++;
		stack[top].h = tmp->h;
		stack[top].idx = tmp->idx;
	}
}

void	pop(void)
{
	if (!isempty())
	{
		stack[top].h = 0;
		stack[top].idx = 0;
		top--;
	}
}

int main()
{
	int N, i = 0;
	st tmp;

	memset(stack, 0, sizeof(stack));
	scanf("%d", &N);
	for (i = 0; i < N; i++)
	{
		tmp.idx = i;
		scanf(" %d", &(tmp.h));
		if (isempty())
			printf("%d", 0);
		else
		{
			while (stack[top].h < tmp.h)
			{
				pop();
				if (isempty())
				{
					printf("%d", 0);
					break ;
				}
			}
			if (!isempty())
				printf("%d", stack[top].idx + 1);
		}
		push(&tmp);
		if (i != N - 1)
			printf(" ");
	}
	return (0);
}