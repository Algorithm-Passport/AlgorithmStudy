#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

/*
연산자는 4개로 제한되어 있다.
주어진 모든 연산자를 사용해야 하므로, 탐색할 시에 해당 칸 1씩 빼줌
*/

#define endl "\n"

int arr[11];
int cal[4];
int min_num = 1000000000, max_num = -1000000000;
vector<int> back_cal;

void cal_ans(int num)
{
    /*
    연산자에 따라서 다른 계산 
    초기값은 주어진 숫자의 처음값
    */
    int ans = arr[0];
    /* 부호는 숫자보다 1 적다. */
    for (int i = 0; i < num - 1; i++)
    {
        if (back_cal[i] == 0)
            ans += arr[i + 1];
        else if (back_cal[i] == 1)
            ans -= arr[i + 1];
        else if (back_cal[i] == 2)
            ans *= arr[i + 1];
        else if (back_cal[i] == 3)
            ans /= arr[i + 1];
    }
    if (ans < min_num)
        min_num = ans;
    if (ans > max_num)
        max_num = ans;
}

void back_track(int count, int num)
{
    if (count == num - 1)
    {
        cal_ans(num);
        return;
    }
    for (int i = 0; i < 4; i++)
    {
        /* 사용할 수 있는 부호가 있을 경우에 탐색 진행 */
        if (cal[i])
        {
            cal[i]--;
            back_cal.push_back(i);
            back_track(count + 1, num);
            cal[i]++;
            back_cal.pop_back();
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    memset(arr, 0, sizeof(arr));
    memset(cal, 0, sizeof(cal));
    int N;
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> arr[i];
    for (int i = 0; i < 4; i++)
        cin >> cal[i];
    back_track(0, N);
    cout << max_num << endl << min_num;
}