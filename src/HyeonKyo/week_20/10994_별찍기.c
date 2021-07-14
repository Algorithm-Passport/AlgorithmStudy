#include <stdio.h>

char	map[400][400];

void	initialize(int n)
{
	//map의 길이만큼 ' '로 채워줌
	int i, j, len = 0;

	len = 4 * (n - 1) + 1;
	for (i = 0; i < len; i++)
		for (j = 0; j < len; j++)
			map[i][j] = ' ';
}

//x, y는 n일 때 왼쪽 위 모퉁이 좌표
void	draw_star(int n, int x, int y)
{
	int	i, j, len = 0;
	//재귀 종료 조건 => n = 1
	if (n == 1)
	{
		map[y][x] = '*';
		return ;
	}
	//정사각형의 길이
	len = 4 * (n - 1) + 1;
	//위 아래 가로를 길이만큼 그려줌
	for (i = 0; i < len; i++)
	{
		map[y][x + i] = '*';
		map[y + len - 1][x + i] = '*';
	}
	//양 옆 세로를 길이만큼 그려줌
	for (j = 0; j < len; j++)
	{
		map[y + j][x] = '*';
		map[y + j][x + len - 1] = '*';
	}
	draw_star(n - 1, x + 2, y + 2);
}

void	print_map(int n)
{
	int i, j, len = 0;

	len = 4 * (n - 1) + 1;
	for (i = 0; i < len; i++)
	{
		for (j = 0; j < len; j++)
			printf("%c", map[i][j]);
		printf("\n");
	}
}

int	main()
{
	int	n;

	scanf("%d", &n);
	initialize(n);
	draw_star(n, 0, 0);
	print_map(n);

	return (0);
}