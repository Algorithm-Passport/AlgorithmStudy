#include <iostream>
using namespace std;

/*
1일때 1만가능
2일때 00, 11 가능
3일때 2번 경우에 1만 붙이고, 00일때 뒤에 붙인다.
4일때 3의 경우에 3의 경우에 1만 붙이고 2의 경우의 수만큼 1을 붙인다.
이에따라 점화식은 f(n) = f(n-1) + f(n-2) 가 나온다.
*/

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    short arr[1000001];
    cin >> N;
    arr[1] = 1;
    arr[2] = 2;
    for (int i = 3; i <= N; i++)
        arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
    cout << arr[N];
}