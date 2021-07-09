#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct s_list
{
	char	c;
	struct s_list *next;
	struct s_list *prev;
}t_list;

typedef struct s_pwd
{
	t_list *fst;
	t_list *last;
}t_pwd;

t_list	*create_list(void)
{
	t_list *lst;

	lst = (t_list *)malloc(sizeof(t_list));
	memset(lst, 0, sizeof(t_list));
	return (lst);
}
//back, front는 각각 커서위치(현재 노드 위치) 이동
void	back(t_list **cur)
{
	if ((*cur)->c == 0)
		return ;
	*cur = (*cur)->prev;
}

void	front(t_list **cur)
{
	if ((*cur)->next == 0)
		return ;
	*cur = (*cur)->next;
}
//앞의 노드 지움.
void	backspace(t_list **cur)
{
	t_list *tmp, *del;

	if ((*cur)->c == 0)
		return ;
	del = *cur;
	tmp = (*cur)->next;
	*cur = (*cur)->prev;
	(*cur)->next = tmp;
	if (tmp)
		tmp->prev = *cur;
	free(del);
}

void	clear_list(t_list *head)
{
	t_list *cur, *tmp;

	cur = head->next;
	while (cur)
	{
		tmp = cur;
		cur = cur->next;
		free(tmp);
	}
	memset(head, 0, sizeof(t_list));
}

void	putin(t_list *head, char *str)
{
	t_list *cur, *tmp;
	int i = 0;

	cur = head;
	//데이터 리스트에 입력
	while (str[i])
	{
		//명령어들
		if (str[i] == '<')
			back(&cur);
		else if (str[i] == '>')
			front(&cur);
		else if (str[i] == '-')
			backspace(&cur);
		else//문자일 때 입력
		{
			tmp = create_list();
			tmp->c = str[i];
			if (cur->next == 0)//커서가 데이터의 마지막일 때
			{
				cur->next = tmp;
				tmp->prev = cur;
				cur = cur->next;
			}
			else//커서가 문자 데이터 중간에 있을 때
			{
				tmp->prev = cur;
				tmp->next = cur->next;
				cur->next = tmp;
				tmp->next->prev = tmp;
				cur = tmp;
			}
		}
		i++;
	}
	//리스트 출력
	cur = head->next;
	while (cur)
	{
		printf("%c", cur->c);
		cur = cur->next;
	}
	printf("\n");
	//리스트 비우기
	clear_list(head);
}

int main()
{
	int	n, i = 0;
	char	str[1000000];
	t_list	head;

	scanf("%d", &n);
	memset(&head, 0, sizeof(t_list));
	for (i = 0; i < n; i++)
	{
		scanf("%s", str);
		putin(&head, str);
		memset(str, 0, sizeof(str));
	}
	return (0);
}

/*
1. 양방향 연결리스트로 커서 구현, 현재 노드 위치 = 현재 데이터 뒤에 커서
2. 각 명령 구현
3. 
*/