#include <iostream>
#include <vector>
using namespace std;

/*
각 상태에서의 증가 부분 수열(최대 길이)의 합을 저장한다.
마지막에는 최댓값을 출력한다.
*/

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, temp, ans = 0;
    vector<int> input, sum;

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> temp;
        input.push_back(temp);
    }
    /* 각 상태에서의 최대 길이 증가 부분 수열의 합 입력하기 */
    for (int i = 0; i < N; i++)
    {
        sum.push_back(input[i]);
        for (int j = 0; j <= i; j++)
        {
            if (input[i] > input[j])
                sum[i] = max(sum[i], input[i] + sum[j]);
        }
    }
    /* 최댓값 추려내기 */
    for (int i = 0; i < N; i++)
        if (sum[i] > ans)
            ans = sum[i];
    cout << ans;
    return (0);
}