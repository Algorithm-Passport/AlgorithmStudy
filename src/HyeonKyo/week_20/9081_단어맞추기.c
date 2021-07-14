#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int		compare(const void *a, const void *b)
{
    int	num1 = *(int *)a;
    int	num2 = *(int *)b;

	if (num1 < num2)
		return (-1);
	else if (num1 > num2)
		return (1);
	else
		return (0);
}

void	change_char(char *str, int idx1, int idx2)
{
	char	tmp;

	tmp = str[idx1];
	str[idx1] = str[idx2];
	str[idx2] = tmp;
}

void	find_min_char(char *str, int change_idx)
{
	char	base, min;
	int		i, min_idx, len = 0;

	len = (int)strlen(str);
	base = str[change_idx];
	min = 127;
	for (i = change_idx + 1; i < len; i++)
	{
		if (str[i] > base)//base보단 커야 함.
		{
			if (min > str[i])//그 중 최소값 찾기
			{
				min = str[i];
				min_idx = i;
			}
		}
	}
	change_char(str, change_idx, min_idx);
}

void	change_next_word(char *str)
{
	char	base_c, tmp;
	int		i, j, len = 0;

	len = (int)strlen(str);
	if (len < 2)
		return ;
	//기준 문자는 가장 뒤의 문자
	base_c = str[len - 1];
	//현재 문자 >= base문자
	// => base = 현재 문자로 바꿔줌,
	//	  현재의 앞의 문자와 비교 반복
	//	  맨 앞의 문자까지 비교했다면 문자를 바꾸지 않음
	//현재 문자 < base
	// => 그 현재 문자 뒤에 있는 문자 중 현재 문자보다 크지만,
	//    그 중 가장 작은 문자를 현재 문자와 위치를 바꿔주고
	//    그 뒤의 문자들을 작은 순으로 나열
	for (i = len - 2; i >= 0; i--)
	{
		if (str[i] < base_c)
		{
			//str[i]와 뒤의 최소 문자와 바꿔줌
			find_min_char(str, i);
			len = (int)strlen(str + i + 1);
			qsort(str + i + 1, len, sizeof(char), compare);
			break ;
		}
		base_c = str[i];
	}
}

int main()
{
	int		T, i = 0;
	char	str[101];

	scanf("%d", &T);
	for (i = 0; i < T; i++)
	{
		//1. 단어 입력
		//2. 사전 상 다음 단어로 바꿔줌
		//3. string 배열에 넣어줌.
		memset(str, 0, sizeof(char) * 100);
		scanf("%s", str);
		change_next_word(str);
		printf("%s\n", str);
	}
	return (0);
}
