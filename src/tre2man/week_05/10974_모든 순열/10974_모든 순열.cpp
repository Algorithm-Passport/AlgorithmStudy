#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

/*
백트래킹 알고리즘을 이용하여 탐색한다.
순차적으로 탐색하나, 조건에 맞지 않은 경우의 하위 경우는 탐색을 하지 않는다.
중복되는 숫자가 없어야 하므로 visited 배열에 방문한 경우를 체크하여, 중복을 확인한다.
*/

vector<int> v;
int visited[9];

void back_track(int len, int end)
{
    /* 1로 시작, len = end + 1일 경우 출력 */
     if (len == end + 1)
    {
        for (int i = 0; i < end; i++)
            cout << v[i] << " ";
        cout << "\n";
        return;
    }
    for (int i = 1; i <= end; i++)
    {
        /* 방문하지 않은 노드의 경우 */
        if (!visited[i])
        {
            visited[i] = 1;
            v.push_back(i);
            back_track(len + 1, end);
            v.pop_back();
            visited[i] = 0;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    memset(visited, 0, sizeof(visited));
    int N;
    cin >> N;
    back_track(1, N);
    return (0);
}