#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef struct
{
    int x;
    int y;
} loc;

int visited[301][301];
/* 이동 가능한 좌표를 미리 지정해둠 */
loc moves[8] = {{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {-1, -2}, {-2, -1}};
int l, a, b, c, d;

/* 좌표가 맵 크기를 벗어나는지 확인하는 함수 */
int can_move(loc start, loc next)
{
    int sum_x = start.x + next.x;
    int sum_y = start.y + next.y;
    if (sum_x >= 0 && sum_x < l && sum_y >= 0 && sum_y < l)
        return (1);
    else
        return (0);
}

void bfs()
{
    queue<loc> q;
    memset(visited, 0, sizeof(visited));
    
    visited[a][b] = 1;
    q.push({a, b});
    while (!q.empty())
    {
        loc start = q.front();
        /* 목표한 위치에 도달한 경우 */
        if (start.x == c && start.y == d)
        {
            cout << visited[start.x][start.y] - 1 << "\n";
            return;
        }
        q.pop();
        for (int i = 0; i < 8; i++)
        {
            /* 방문이 가능한 좌표인 동시에 방문하지 않았다면, 방문하기 */
            if (can_move(start, moves[i]) && !visited[start.x + moves[i].x][start.y + moves[i].y])
            {
                visited[start.x + moves[i].x][start.y + moves[i].y] = visited[start.x][start.y] + 1;
                q.push({start.x + moves[i].x, start.y + moves[i].y});
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> l >> a >> b >> c >> d;
        bfs();
    }
    return (0);
}