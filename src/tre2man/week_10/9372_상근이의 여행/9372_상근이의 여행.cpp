#include <bits/stdc++.h>
using namespace std;

/*
노드가 n개인 트리 구조는 항상 n-1개의 간선을 갖는다.
트리 구조에서의 간선의 수는 비행기 종류의 최소 개랑 일치한다.
간선의 수가 가장 적은 트리는? -> 최소 신장 트리

-블로그 참조-
최소 신장 트리(MST)
1. 간선의 가중치의 합이 최소
2. n개의 정점을 가지는 그래프에 대해서 n-1의 간선만 사용해야 한다.
3. 사이클이 포함되어서는 안된다.

구현 방법
1. Kruskal MST
2. Prim MST

MST 관련 문제
1. 최소 스패닝 트리 - 백준 1197
2. 네트워크 연결 - 백준 1922

출저
https://gmlwjd9405.github.io/2018/08/28/algorithm-mst.html
*/

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T, N, M, a, b;
    cin >> T;
    while (T--)
    {
        cin >> N >> M;
        cout << (N - 1) << "\n";
        while (M--)
            cin >> a >> b;
    }
    return (0);
}