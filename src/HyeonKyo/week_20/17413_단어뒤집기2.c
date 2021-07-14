#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int	is_identifier(int c)
{
	//구분자인지 리턴값으로 확인
	if (c == '<' || c == '>')
		return (1);
	else if (c == ' ')
		return (2);
	else if (c == 0)
		return (3);
	else
		return (0);
		
}

void	reverse_string(char *str, int f_idx, int l_idx)
{
	//인덱스를 기준으로 단어 뒤집기
	char	*tmp;
	int		i, j, len = 0;

	len = l_idx - f_idx + 1;
	tmp = (char *)malloc(len + 1);
	tmp[len] = 0;
	strncpy(tmp, str + f_idx, len);
	j = len - 1;
	for (i = f_idx; i <= l_idx; i++)
		str[i] = tmp[j--];
	free(tmp);
}

int main()
{
	int		i, first_idx, last_idx = 0;
	char	str[100001];

	//하나의 string으로 입력 받음.
	for (i = 0; i < 100001; i++)
	{
		scanf("%c", str + i);
		if (str[i] == '\n')
		{
			str[i] = 0;
			break ;
		}
	}
	i = 0;
	while (str[i])
	{
		//<를 만나면 >를 만날때까지 인덱스 넘김
		if (is_identifier(str[i]) == 1)
		{
			while (is_identifier(str[++i]) != 1);
			i++;
		}
		else if (is_identifier(str[i]) == 0)
		{
			//단어의 문자를 만나면 첫번째와 마지막 인덱스를 찾아서
			//함수에 넘겨줌.
			first_idx = i;
			while (!is_identifier(str[++i]));
			last_idx = i - 1;
			reverse_string(str, first_idx, last_idx);
		}
		else
			i++;
	}
	//바꾼 string 출력
	printf("%s\n", str);
	return (0);
}