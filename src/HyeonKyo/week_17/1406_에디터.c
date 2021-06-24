#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//연결리스트 노드 구성
//데이터, 이전주소, 다음주소
typedef struct		s_node
{
	char	data;
	struct s_node *prev;
	struct s_node *next;
}					node;

//문자 데이터 c를 넣은 노드 생성
node	*create_node(char c)
{
	node *lst;
	lst = (node *)malloc(sizeof(node));
	memset(lst, 0, sizeof(node));
	lst->data = c;
	return (lst);
}

//현재 노드 다음에 노드 생성 후 연결.
void	link_node(node *cur)
{
	node *tmp;
	tmp = create_node(0);
	cur->next = tmp;
	tmp->prev = cur;
}

//이전 노드로 이동(시작 노드 데이터는 \0이 있음)
void	edit_L(node **cur)
{
	if ((*cur)->prev->data != 0)
		*cur = (*cur)->prev;
}

//다음 노드로 이동
void	edit_D(node **cur)
{
	if ((*cur)->next != 0)
		*cur = (*cur)->next;
}
//이전 노드를 하나 지워줌
void	edit_B(node **cur)
{
	node *front;
	node *tmp;

	if ((*cur)->prev->data == 0)
		return ;
	tmp = (*cur)->prev;
	front = tmp->prev;
	(*cur)->prev = front;
	if (front != 0)
		front->next = (*cur);
	free(tmp);
	tmp = 0;
}
//이전 노드에 문자 c를 넣은 노드 연결
void	edit_P(node *cur, char c)
{
	node *tmp;
	node *new;

	tmp = cur->prev;
	new = create_node(c);
	cur->prev = new;
	new->next = cur;
	if (tmp != 0)
		tmp->next = new;
	new->prev = tmp;
}
//연결리스트 삭제
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

int main()
{
	char	str[100001];
	node	*cur;
	node	*head;
	node	*tmp;
	int		M, i, j = 0;
	char	c1[1000001];
	char	c2[1000001];

	head = create_node(0);
	cur = create_node(0);
	head->next = cur;
	cur->prev = head;
	//입력
	scanf("%s", str);
	//1. 문자열 입력을 연결리스트에 각각 문자 하나씩 저장
	while (str[i])
	{
		cur->data = str[i++];
		link_node(cur);
		cur = cur->next;
	}
	scanf("%d", &M);
	//2. 명령어들 c1배열에 저장, P를 만나면 c2에 추가할 문자 따로 저장.
	for (i = 0; i < M; i++)
	{
		scanf("\n%c ", c1 + i);
		if (c1[i] == 'P')
			scanf(" %c", c2 + j++);
	}
	j = 0;
	//3.각 명령어 수행
	for (i = 0; i < M; i++)
	{
		if (c1[i] == 'L')
			edit_L(&cur);
		else if (c1[i] == 'D')
			edit_D(&cur);
		else if (c1[i] == 'B')
			edit_B(&cur);
		else if (c1[i] == 'P')
			edit_P(cur, c2[j++]);
	}
	//4. 연결리스트 순차적 출력
	cur = head->next;
	while (cur->data != 0)
	{
		printf("%c", cur->data);
		cur = cur->next;
	}
	printf("\n");
	//5. 리스트 삭제
	del_lst(head);
	return (0);
}