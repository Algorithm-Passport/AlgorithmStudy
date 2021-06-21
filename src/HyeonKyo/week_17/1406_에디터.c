#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct		s_node
{
	char	data;
	struct s_node *prev;
	struct s_node *next;
}					t_node;

void	create_node(t_node **lst)
{
	*lst = (t_node *)malloc(sizeof(*lst));
	memset(*lst, 0, sizeof(*lst));
}

void	next(t_node **lst, t_node *tmp)
{
	t_node tmp;

	create_node(&(*lst->prev));
	*lst->prev = tmp;
	tmp->next = *lst;
	create_node(&(*lst->next));
	tmp = *lst->next;
	tmp->prev = *lst;
	*lst = *(lst->next);
}

int main()
{
	char	*tmp;
	t_node	*lst;
	t_node	*head;
	t_node	*tmp;
	t_node	*cs;
	int		M, i, len, idx, max = 0;
	char	c[1000001];

	create_node(&head);
	create_node(&lst);
	create_node(&tmp);
	head = lst;
	tmp = lst;
	next(&lst, tmp);
	while (1)
	{
		scanf("%c", lst->data);
		if (lst->data == 0)
			break ;
		next(&lst, tmp);
	}
	cs = lst;
	scanf("%d", &M);
	for (i = 0; i < M; i++)
	{
		scanf("%c", &(c[i]));
		if (c[i] == 'P')
			scanf("%c", &(c[++i]));
	}
	/*
	1. cs에 각 명령들 적용
		1. L
		2. D
		3. B
		4. P $
	*/
	return (0);
}
