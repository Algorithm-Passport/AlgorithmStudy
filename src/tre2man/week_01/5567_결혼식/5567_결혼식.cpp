#include <iostream>
#include <cstring>
#include <queue>
#include <vector>
using namespace std;

/*
간단한 bfs 문제이다.
2차원 배열을 이용해 풀어도 되지만, 벡터에 push_back을 해주면 크기가 훨씬 작아진다.
탐색할 때마다 친구의 수를 늘려주고, 방문한 배열은 시작 지점부터의 거리를 입력해 준다.
방문한 배열의 거리가 3이 되는 지점을 탐색하는순간, while문을 종료한다.
*/

vector<int> v[501];
queue<int> q;
int visited[501];
int n, m, ans = 0;

void bfs()
{
    q.push(1);
    while (!q.empty())
    {
        int x = q.front();
        q.pop();
        /* 친구의 친구를 넘어서는 경우, 종료 */
        if (visited[x] == 3)
            break;
        for (auto start = v[x].begin(); start != v[x].end(); start++)
        {
            int next = *start;
            if (!visited[next])
            {
                ans++;
                visited[next] = visited[x] + 1;
                q.push(next);
            }
        }
    }
}

int main()
{
    memset(visited, 0, sizeof(visited));
    scanf("%d %d", &n, &m);
    for (int i = 0; i < m; i++)
    {
        int a, b;
        scanf("%d %d", &a, &b);
        v[a].push_back(b);
        v[b].push_back(a);
    }
    visited[1] = 1;
    bfs();
    printf("%d", ans);
}