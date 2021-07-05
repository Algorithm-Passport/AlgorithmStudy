#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct	s_list
{
	char str[6];
	struct s_list *next;
}				t_list;

typedef struct	s_deq
{
	t_list	*fst;
	t_list	*last;
}				t_deq;

void	push(t_deq *deq, char *src)
{
	if (deq->last != 0)
	{
		deq->last->next = (t_list *)malloc(sizeof(t_list));
		deq->last = deq->last->next;
	}
	else
		deq->last = deq->fst;
	strncpy(deq->last->str, src, strlen(src));
	deq->last->next = 0;
}

void	pull(t_deq *deq, char *src)
{
	t_list	*cur;
	t_list	*prev;
	t_list	*tmp;

	cur = deq->fst;
	prev = 0;
	while (cur)
	{
		if (!strncmp(cur->str, src, strlen(src)))
		{
			if (prev == 0)
			{
				deq->fst = cur->next;
				free(cur);
			}
			else
			{
				tmp = cur;
				cur = cur->next;
				prev->next = cur;
				free(tmp);
			}
			return ;
		}
		prev = cur;
		cur = cur->next;
	}
}

void	clear(t_list *lst)
{
	t_list *cur;

	while (lst)
	{
		cur = lst;
		lst = lst->next;
		free(cur);
	}
}

int	main()
{
	int		i, N = 0;
	t_deq	deq;
	t_list	*lst;
	t_list	*cur;
	t_list	*min;
	char	src[6], check[6];

	scanf("%d", &N);
	lst = (t_list *)malloc(sizeof(t_list));
	lst->next = 0;
	deq.fst = lst;
	deq.last = 0;
	for (i = 0; i < N; i++)
	{
		scanf("%s %s", src, check);
		if (!strcmp(check, "enter"))
			push(&deq, src);
		else
			pull(&deq, src);
	}
	cur = deq.fst;
	min = deq.fst->next;
	while (cur)
	{
		while (cur)
		printf("%s\n", cur->str);
		cur = cur->next;
	}
	clear(deq.fst);
	return (0);
}