#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

/*
중복되는 숫자가 없어야 하므로 visited에 방문한 기록을 저장함.
부등호를 판별하여 조건에 맞으면 탐색한다.
0 -> 9 순서대로 탐색하므로, 첫번째 수가 최소 마지막 수가 최대값이다.
*/

#define endl "\n"

int k;
int visited[10];
vector<int> v;
string input, temp = "", ans_max = "0", ans_min = "999999999";

void update_ans()
{
    if (temp < ans_min)
        ans_min = temp;
    if (temp > ans_max)
        ans_max = temp;
}

void backtrack(int start)
{
    if (start == k + 1)
    {
        update_ans();
        return;
    }
    for (int i = 0; i <= 9; i++)
    {
        if (!visited[i])
        {
            /* 첫번째 숫자는 뭐든 들어올 수 있다. 예외처리 */
            if (start == 0)
            {
                temp.push_back(i + '0');
                visited[i] = 1;
                backtrack(start + 1);
                temp.pop_back();
                visited[i] = 0;
            }
            /* 탐색하는 숫자가 부등호를 만족하는지? 만족하면 탐색 진행*/
            else if (input[start - 1] == '<' && (temp[start - 1] - '0' < i))
            {
                temp.push_back(i + '0');
                visited[i] = 1;
                backtrack(start + 1);
                temp.pop_back();
                visited[i] = 0;
            }
            else if (input[start - 1] == '>' && (temp[start - 1] - '0' > i))
            {
                temp.push_back(i + '0');
                visited[i] = 1;
                backtrack(start + 1);
                temp.pop_back();
                visited[i] = 0;
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    memset(visited, 0, sizeof(visited));
    char c;
    cin >> k;
    for (int i = 0; i < k; i++)
    {
        cin >> c;
        input.push_back(c);
    }
    backtrack(0);
    cout << ans_max << endl << ans_min;
    return (0);
}