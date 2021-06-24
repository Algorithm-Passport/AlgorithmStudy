#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
---입력---
1. 구조체 배열에 값 저장
 인덱스 = 숫자, 구조체 내부{indegree, next link}
2. 연결리스트 구조체 생성
	int data, next node
3. N, M을 입력 받고 M만큼 선행 문제 번호를 받음
	=> 예를 들어 4 2가 들어오면
	1. arr[4]->next에 node추가 후 그 data에 2넣어줌
	2. arr[2]->indegree++
----출력---
1. arr[N]까지 indegree = 0인 데이터의 인덱스를 뽑아서 최소힙으로 만듬
2. 최솟값 min print
3. arr[min]에 연결된 리스트들의 데이터에 있는 인덱스들의 indegree값들 모두 -1씩
1~3반복
*/
typedef struct		s_node
{
	int				data;
	struct s_node	*next;
}					node;

typedef struct		s_data
{
	int		indegree;
	node	*next;
}					data;

node	*create_node(int num)
{
	node *lst;
	lst = (node *)malloc(sizeof(node));
	memset(lst, 0, sizeof(node));
	lst->data = num;
	return (lst);
}

//현재 노드 다음에 노드 생성 후 연결.
void	link_data(data *arr, int idx, int num)
{
	node *cur;

	cur = arr[idx].next;
	if (!cur)
		arr[idx].next = create_node(num);
	else
	{
		while (cur->next)
			cur = cur->next;
		cur->next = create_node(num);
	}
}

void	del_lst(node *head)
{
	node *tmp;
	
	while (head)
	{
		tmp = head;
		head = head->next;
		free(tmp);
	}
}

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
	if (a > 0 && b <= 0)
		return (1);
	else if (a <= 0 && b > 0)
		return (0);
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
	if (c_idx >= size || arr[c_idx] <= 0)
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
	if (cr == size)
		swaping(arr, p_idx, cl, size);
	else if (cr < size)
	{
		if (compare(arr[cl], arr[cr]))
			swaping(arr, p_idx, cl, size);
		else
			swaping(arr, p_idx, cr, size);
	}
}

void	adjust_indegree(data *arr, int index)
{
	node	*cur;
	node	*head;

	arr[index].indegree = -1;
	head = arr[index].next;
	cur = head;
	while (cur)
	{
		arr[cur->data].indegree -= 1;
		cur = cur->next;
	}
	del_lst(head);
}

int		print_min_num(int *min_heap, int *size, data *arr)
{
	int	p_idx, cl_idx, cr_idx, tmp = 0;
	if (*size == 1)
		return (0);
	printf("%d", min_heap[1]);
	adjust_indegree(arr, min_heap[1]);
	min_heap[1] = min_heap[*size - 1];
	min_heap[*size - 1] = 0;
	*size -= 1;
	p_idx = 1;
	cl_idx = 2;
	cr_idx = 3;
	if (compare(min_heap[cl_idx], min_heap[cr_idx]))
		swaping(min_heap, p_idx, cl_idx, *size);
	else
		swaping(min_heap, p_idx, cr_idx, *size);
	return (1);
}

int	main()
{
	int 	N, M, i, A, B, heap_size, result = 0;
	data	arr[32002];
	int		min_heap[32002] = {0, };

	memset(arr, 0, sizeof(arr));
	scanf("%d %d", &N, &M);
	for (i = 0; i < M; i++)
	{
		scanf("%d %d", &A, &B);
		link_data(arr, A, B);
		arr[B].indegree += 1;
	}
	//출력
	heap_size = 1;
	while (result != N)
	{
		for (i = 1; i <= N; i++)
		{
			if (arr[i].indegree == 0)
			{
				insert_num(min_heap, heap_size, i);
				heap_size++;
			}
		}
		result += print_min_num(min_heap, &heap_size, arr);
		if (result != N)
			printf(" ");
	}
	return (0);
}
/*
힙 : https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html
위상정렬, 우선순위 큐 정의
https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=mirzzz79&logNo=110023485592
그래프 용어 정리
https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=minichuuuuu&logNo=220808115381
1.모든 일의 선행 필요조건 관계를 따라 그래프를 그린다.

(방향 그래프 완성)

2. 각 일에 대해 indegree를 센다.(자신으로 들어오는 간선의 개수)

3. indegree가 0인 일을 모두 찾아 우선순위 큐에 넣는다

4. 우선순위 큐에서 일 하나를 꺼낸다.

(위상정렬의 결과 출력을 위해 이때 꺼내진 일을 출력하면 된다.)

5. 방금 꺼낸 일에 연결된 모든 일들의 indegree를 1씩 감소시킨다.

6. indegree가 감소된 일들 중 indegree가 0인 일이 있으면 우선순위 큐에 넣어준다.

7. 우선순위 큐가 빌 때까지 4~6을 반복한다.
*/