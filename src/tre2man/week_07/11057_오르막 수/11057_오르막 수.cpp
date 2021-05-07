#include <iostream>
using namespace std;

/*
모든 경우의 수에 대하여 세어보았다.
1 1 1 1 ...
1 2 3 4 ...
1 3 6 10...
1 4 10 20...
해당 칸의 숫자는 위의숫자 + 좌측숫자 로 나타내어진다.
N번째줄의 숫자의 합이 답이다.
*/

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, arr[1001][10], flag = 1, ans = 0;
    cin >> N;
    for (int i = 0; i <= 9; i++)
        arr[1][i] = 1;
    for (int i = 2; i <= N; i++)
    {
        arr[i][0] = 1;
        for (int j = 1; j <= 9; j++)
            arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 10007;
    }
    for (int i = 0; i <= 9; i++)
        ans += arr[N][i];
    cout << ans % 10007;
}