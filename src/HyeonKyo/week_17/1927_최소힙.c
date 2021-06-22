#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void	insert_num(int *arr, int size, int num)
{
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

	if (c_idx >= size)
		return ;
	if (arr[p_idx] > arr[c_idx])
	{
		tmp = arr[p_idx];
		arr[p_idx] = arr[c_idx];
		arr[c_idx] = tmp;
	}
	p_idx = c_idx;
	cl = p_idx * 2;
	cr = p_idx * 2 + 1;
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

	if (*size == 1)
	{
		printf("%d\n", 0);
		return ;
	}
	printf("%d\n", arr[1]);
	arr[1] = arr[*size - 1];
	p_idx = 1;
	cl_idx = 2;
	cr_idx = 3;
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
	scanf("%d", &N);
	for (i = 0; i < N; i++)
	{
		scanf("%d", &tmp);
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