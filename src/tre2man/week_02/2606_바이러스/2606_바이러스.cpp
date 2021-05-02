#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

vector<int> v[101];
queue<int> q;
bool visited[101];

int bfs()
{
    int ans = 0;

    q.push(1);
    visited[1] = true;
    while (!q.empty())
    {
        int x = q.front();
        q.pop();
        for (auto start = v[x].begin(); start != v[x].end(); start++)
        {
            /* 감염되는 경우 */
            if (!visited[*start])
            {
                q.push(*start);
                ans++;
                visited[*start] = true;
            }
        }
    }
    return (ans);
}

int main()
{
    int M, N, a, b;
    memset(visited, 0, sizeof(visited));
    scanf("%d %d", &M, &N);
    for (int i = 0; i < N; i++)
    {
        /* 노드 정보 입력 */
        scanf("%d %d", &a, &b);
        v[a].push_back(b);
        v[b].push_back(a);
    }
    printf("%d", bfs());
    return (0);
}