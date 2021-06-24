#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
*최소 힙*
완전 이진 트리 구성으로, 부모 노드는 자식 노드 2개를 하위에 지니고 있고,
부모 노드 값은 항상 자식 노드보다 작음. 즉, 가장 상위의 부모 노드가 최솟값
1차원 배열로 구현, 부모 노드의 인덱스 = n일 때,
왼쪽 자식 노드 인덱스 = 2n
오른쪽 = 2n + 1
*/
void	insert_num(int *arr, int size, int num)
{
	//부모 노드와 비교하면서 부모노드 보다 작을 때까지
	//swap반복
	int p_idx, c_idx, tmp = 0;

	p_idx = size / 2;
	c_idx = size;
	arr[c_idx] = num;
	if (size == 1)
		return ;
	while (arr[p_idx] > arr[c_idx])
	{
		tmp = arr[p_idx];
		arr[p_idx] = arr[c_idx];
		arr[c_idx] = tmp; 
		c_idx = p_idx;
		p_idx /= 2;
		if (p_idx == 0)
			return ;
	}
}

int		compare(int a, int b)
{
	if (a <= b)
		return (1);
	return (0);
}

void	swaping(int *arr, int p_idx, int c_idx, int size)
{
	int tmp, cl, cr = 0;
	//가장 상위 노드에 값을 넣고
	//하위 자식노드 2개와 값을 비교하면서
	//맞는 위치에 위치할 때까지 swap반복.
	if (c_idx >= size)
		return ;
	if (arr[p_idx] > arr[c_idx])
	{
		tmp = arr[p_idx];
		arr[p_idx] = arr[c_idx];
		arr[c_idx] = tmp;
	}
	p_idx = c_idx;
	cl = p_idx * 2;//왼쪽 자식 노드
	cr = p_idx * 2 + 1;//오른쪽 자식 노드
	if (cr < size)
	{
		if (compare(arr[cl], arr[cr]))
			swaping(arr, p_idx, cl, size);
		else
			swaping(arr, p_idx, cr, size);
	}
}

void	print_min_num(int *arr, int *size)
{
	int p_idx, cl_idx, cr_idx, tmp = 0;
	//최소힙의 가장 앞의 값 출력 후 삭제.
	//1. 최소 힙의 최솟값 출력
	if (*size == 1)
	{
		printf("%d\n", 0);
		return ;
	}
	printf("%d\n", arr[1]);
	//2. 최소힙의 가장 끝의 값을 맨 위의 트리로 이동
	arr[1] = arr[*size - 1];
	p_idx = 1;
	cl_idx = 2;
	cr_idx = 3;
	//3. 좌,우의 자식 노드와 비교하며 최소힙 구성에 맞게
	//swaping 반복 
	if (compare(arr[cl_idx], arr[cr_idx]))
		swaping(arr, p_idx, cl_idx, *size);
	else
		swaping(arr, p_idx, cr_idx, *size);
	*size -= 1;
}

int main()
{
	int N, size, tmp, i, j = 0;
	int	arr[100001];

	memset(arr, 0, sizeof(arr));
	size = 1;
	//입력
	scanf("%d", &N);
	for (i = 0; i < N; i++)
	{
		scanf("%d", &tmp);
		//1. 입력 받은 숫자가 0이면 출력
		//2. 아니면 그 숫자를 최소힙에 저장.
		if (tmp == 0)
			print_min_num(arr, &size);
		else if (tmp > 0)
		{
			insert_num(arr, size, tmp);
			size++;
		}
	}
	return (0);
}
	/*
	1. 바로 직전 index의 숫자와 num값 비교
	2. num이 더 크면 그냥 그 자리에 num넣어주고 끝냄
	3. 더 작으면 부모 index의 노드와 비고 => 반복 => idx == 1일 때 까지.
	*/