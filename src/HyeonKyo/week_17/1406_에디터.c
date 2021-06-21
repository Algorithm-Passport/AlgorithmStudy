#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct		s_node
{
	char	data;
	struct s_node *prev;
	struct s_node *next;
}					node;

node	*create_node(char c)
{
	node *lst;
	lst = (node *)malloc(sizeof(lst));
	memset(lst, 0, sizeof(lst));
	lst->data = c;
	return (lst);
}

void	link_node(node *cur)
{
	node *tmp;
	tmp = create_node(0);
	cur->next = tmp;
	tmp->prev = cur;
}

void	insert_node(node *cur, char c)
{
	node *tmp;
	node *new;

	cur->prev = tmp;
	new = create_node(c);
	cur->prev = new;
	new->next = cur;
	tmp->next = new;
	new->prev = tmp;
}

void	edit_L(node **cur)
{
	if ((*cur)->prev != 0)
		*cur = (*cur)->prev;
}

void	edit_D(node **cur)
{
	if ((*cur)->next != 0)
		*cur = (*cur)->next;
}

void	edit_B(node **cur)
{
	node *front;
	node *tmp;

	if ((*cur)->prev == 0)
		return ;
	tmp = (*cur)->prev;
	front = tmp->prev;
	(*cur)->prev = front;
	front->next = (*cur);
	free(tmp);
	tmp = 0;
}

void	edit_P(node *cur, char c)
{
	insert_node(cur, c);
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
	scanf("%s\n", str);
	while (str[i])
	{
		cur->data = str[i++];
		link_node(cur);
		cur = cur->next;
	}
	scanf("%d\n", &M);
	for (i = 0; i < M; i++)
	{
		scanf("%c ", c1 + i);
		if (c1[i] == 'P')
			scanf("%c\n", c2 + j++);
	}
	j = 0;
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
	cur = head->next;
	while (cur != 0)
	{
		printf("%c", cur->data);
		cur = cur->next;
	}
	printf("\n");
	del_lst(head);
	return (0);
}
