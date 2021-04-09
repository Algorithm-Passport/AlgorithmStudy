#include <iostream>
#include <cstring>
using namespace std;

/*
너무 비효율적으로 작성한 것 같다. 연산 횟수와 코드 간결화 해야함.
*/

char input[51];
char map[50][50];
char copied_map[50][50];
int N, ans = 0;

void copy(int a_x, int a_y, int b_x, int b_y)
{
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            copied_map[i][j] = map[i][j];
    char temp = copied_map[a_x][a_y];
    copied_map[a_x][a_y] = copied_map[b_x][b_y];
    copied_map[b_x][b_y] = temp;
}

void check()
{
    for (int i = 0; i < N; i++)
    {
        int temp_num = 1;
        int temp_max = 1;
        char temp_char = copied_map[i][0];
        for (int j = 0; j < N - 1; j++)
        {
            if (temp_char == copied_map[i][j + 1])
                temp_num++;
            else
            {
                temp_char = copied_map[i][j + 1];
                temp_max = max(temp_max, temp_num);
                temp_num = 1;
            }
        }
        ans = max(ans, max(temp_num, temp_max));
    }
    for (int i = 0; i < N; i++)
    {
        int temp_num = 1;
        int temp_max = 1;
        char temp_char = copied_map[0][i];
        for (int j = 0; j < N - 1; j++)
        {
            if (temp_char == copied_map[j + 1][i])
                temp_num++;
            else
            {
                temp_char = copied_map[j + 1][i];
                temp_max = max(temp_max, temp_num);
                temp_num = 1;
            }
        }
        ans = max(ans, max(temp_num, temp_max));
    }
}

void cal()
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (i + 1 < N)
            {
                copy(i, j, i + 1, j);
                check();
            }
            if (j + 1 < N)
            {
                copy(i, j, i, j + 1);
                check();
            }
        }
    }
}

int main()
{
    scanf("%d", &N);
    memset(map, 0, sizeof(map));
    memset(copied_map, 0, sizeof(copied_map));
    for (int i = 0; i < N; i++)
    {
        scanf("%s", input);
        for (int j = 0; j < N; j++)
            map[i][j] = input[j];
    }
    cal();
    printf("%d", ans);
    return (0);
}