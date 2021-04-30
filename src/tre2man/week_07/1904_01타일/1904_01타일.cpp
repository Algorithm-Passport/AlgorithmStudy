#include <iostream>
using namespace std;

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