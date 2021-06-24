#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*
스택 : FILO(first in last out)
pop : 가장 위의 값 삭제
push : 값 하나 가장 위에 추가
*/
typedef struct	s_st//스택의 데이터 저장할 구조체
{
	int idx;//탑 넘버
	int h;//탑의 높이
}				st;

st stack[500001];//스택 = 구조체의 배열
int top = -1;

int	isempty(void)//스택이 비어있는지 확인
{
	if (top < 0)
		return (1);
	return (0);
}

int isfull(void)//스택이 꽉 찼는지 확인
{
	if (top > 500000)
		return (1);
	return (0);
}

void	push(st *tmp)
{
	//스택에 데이터 추가.
	if (!isfull())
	{
		top++;
		stack[top].h = tmp->h;
		stack[top].idx = tmp->idx;
	}
}

void	pop(void)
{
	//스택에 데이터 제거
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
	/*
	입력을 받으면서 스택을 그때그때 수정해주는 구성
	1. 입력받은 탑 높이 >= 스택의 탑 높이
	= 이후 입력받는 탑의 레이저 송신은 이전의 탑이 받을 수 없고
	  현재 입력받은 타워가 받을 것임
	  	=> 0출력
		=> 이전의 스택 값 제거
		=> 입력값 스택에 push
	2. 입력받은 탑 높이 < 스택 탑 높이
		=>스택의 index값 출력
		=>입력 받은 탑 push
	*/
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
				//스택 데이터 제거
				pop();
				//스택이 비면 송신탑이 없다는 의미
				if (isempty())
				{
					printf("%d", 0);
					break ;
				}
			}
			if (!isempty())//스택의 idx출력
				printf("%d", stack[top].idx + 1);
		}
		push(&tmp);
		if (i != N - 1)
			printf(" ");
	}
	return (0);
}