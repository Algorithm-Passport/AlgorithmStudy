#include <iostream>
using namespace std;

/*
1개 또는 3개만 가져갈 수 있다.
모든 경우의 수는 1 또는 3의 합으로 만들수 있다.
1 또는 3을 최소로 사용해야 한다.
숫자의 개수가 홀수일 경우 상근 승, 짝수일 경우 창영 승
*/

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    int arr[1001];

    cin >> n;
    /* 1부터 3까지는 정해져 있다. */
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 1;
    /* 4부터는 이전의 값들을 이용한다. */
    for (int i = 4; i <= n; i++)
        arr[i] = min(arr[i - 1], arr[i - 3]) + 1;
    if (arr[n] % 2)
        cout << "SK";
    else
        cout << "CY";
    return (0);
}