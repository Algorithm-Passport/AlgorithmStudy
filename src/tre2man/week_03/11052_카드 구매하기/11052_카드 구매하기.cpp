#include <iostream>
using namespace std;

/*
카드 개수가 1개, 2개 ... N개가 될 때의 최댓값을 저장한다.
이전의 값을 이용해 결과를 도출한다.
*/

int input[1001], dp[1001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, max;

    cin >> N;
    input[0] = dp[0] = 0;

    for (int i = 1; i <= N; i++)
        cin >> input[i];
    dp[1] = input[1];
    for (int i = 2; i <= N; i++)
    {
        /* 해당 배열 값 초기화 */
        dp[i] = 0;
        for (int j = 0; j <= i; j++)
        {
            /* 이전 dp값 + 현재 비교하는 입력값과 비교 */
            if (dp[i] < dp[j] + input[i - j])
                dp[i] = dp[j] + input[i - j];
        }
    }
    cout << dp[N];
    return (0);
}