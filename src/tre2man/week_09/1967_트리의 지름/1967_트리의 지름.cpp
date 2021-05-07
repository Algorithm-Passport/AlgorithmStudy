#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

/*
1번부터 가장 거리가 긴 노드를 탐색한다.
해당 노드부터 가장 거리가 긴 노드를 탐색한다.
그렇게 되면 해당 거리가 답이 된다.
*/

#define MAX_LEN 100001

typedef struct
{
    int node;
    int len;
} location;

vector<location> map[MAX_LEN];
bool visit[MAX_LEN];

int V, ans = 0, far_max_node = 0;

void dfs(int node, int len)
{
    if (visit[node])
        return;
    visit[node] = 1;
    if (ans < len)
    {
        ans = len;
        //최대길이 업데이트
        far_max_node = node;
    }
    for (int i = 0; i < map[node].size(); i++)
        dfs(map[node][i].node, len + map[node][i].len);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int point_start, point_end, len;

    cin >> V;
    for (int i = 0; i < V - 1; i++)
    {
        cin >> point_start >> point_end >> len;
        map[point_start].push_back({point_end, len});
        map[point_end].push_back({point_start, len});
    }
    /* memeset 을 이용한 배열 초기화 (0으로) 바이트 단위로 초기화 하므로 0,-1 이외의 초기화 불가능*/
    memset(visit, 0, sizeof(visit));
    dfs(1, 0);
    memset(visit, 0, sizeof(visit));
    ans = 0;
    dfs(far_max_node, 0);
    cout << ans;
    return (0);
}