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

loc moves[4] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
int map[101][101];
int visited[101][101];
int ans = 0;

/* 좌표가 맵 크기를 벗어나는지 확인하는 함수 */
int can_move(loc start, loc next, int N)
{
    int sum_x = start.x + next.x;
    int sum_y = start.y + next.y;
    if (sum_x >= 0 && sum_x < N && sum_y >= 0 && sum_y < N)
        return (1);
    else
        return (0);
}

int bfs(int begin_x, int begin_y, int depth, int N)
{
    queue<loc> q;

    /* 탐색에 실패했을 경우, 0 반환 */
    if (visited[begin_x][begin_y] || map[begin_x][begin_y] <= depth)
        return (0);
    q.push({begin_x, begin_y});
    while (!q.empty())
    {
        loc start = q.front();
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            /* 방문 하지 않았고, 움직일 수 있고, 현재 물의 깊이보다 더 높은 경우에 탐색 */
            if (!visited[start.x + moves[i].x][start.y + moves[i].y])
            {
                if (can_move(start, moves[i], N) && map[start.x + moves[i].x][start.y + moves[i].y] > depth)
                {
                    visited[start.x + moves[i].x][start.y + moves[i].y] = 1;
                    q.push({start.x + moves[i].x, start.y + moves[i].y});
                }
            }
        }
    }
    /* 탐색에 성공하였으므로 1 반환 */
    return (1);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, max_depth = 0;
    cin >> N;
    /* 지도 입력 */
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> map[i][j];
            /* 최대 수면의 높이 갱신 */
            if (map[i][j] > max_depth)
                max_depth = map[i][j];
        }
    }
    /* 깊이 0부터 최대 높이-1 까지 수면 1씩 증가 */
    for (int i = 0; i < max_depth; i++)
    {
        /* 지도 탐색 */
        memset(visited, 0, sizeof(visited));
        int safe = 0;
        for (int j = 0; j <= N; j++)
        {
            for (int k = 0; k < N; k++)
            {
                /* 하나라도 탐색에 성공했을 경우 섬의 개수 +1 */
                if (bfs(j, k, i, N))
                    safe++;
            }
        }
        /* 정답 업데이트 */
        if (safe > ans)
            ans = safe;
    }
    cout << ans;
    return (0);
}