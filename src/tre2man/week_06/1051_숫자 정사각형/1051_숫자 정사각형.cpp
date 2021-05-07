#include <iostream>
#include <algorithm>
using namespace std;

int arr[51][51];

/* 4개의 숫자가 같은지 */
int checkSame(int a, int b, int c, int d)
{
    if (a == b && a == c && b == d && c == d)
        return (1);
    else
        return (0);
}

/* 제일큰 정사각형 넓이 반환 */
int checkSquare(int x, int y, int N, int M)
{
    int ans = 1;
    for (int i = 0; (x + i <= N) && (y + i <= M); i++)
    {
        if (checkSame(arr[x][y], arr[x + i][y], arr[x][y + i], arr[x + i][y + i]))
            ans = (i + 1) * (i + 1);
    }
    return (ans);
}

/* 탐색을 시작할 기준 좌표 돌리기 */
int cal(int N, int M)
{
    int temp, ans = 1;
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= M; j++)
        {
            temp = checkSquare(i, j, N, M);
            ans = max(ans, temp);
        }
    }
    return (ans);
}

int main()
{
    int N, M;

    scanf("%d %d", &N, &M);
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= M; j++)
            scanf("%1d", &arr[i][j]);

    printf("%d", cal(N, M));
}