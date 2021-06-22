#include <bits/stdc++.h>
using namespace std;

/*
탐색을 시도할 때, 입력 타워보다 스택에 있는 타워가 작을 때는 pop 한다.
왜냐하면, 자기보다 작은 타워에는 수신이 불가능하기 때문이다.
스택에서 입력 타워보다 더 큰 타워를 발견했을 땐 그것이 수신탑이므로, 인덱스를 출력한다.
*/

typedef struct
{
	int idx, val;
} loc;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int num, tower, top, maxnum;
	stack<loc> s;

	cin >> num;

	for (int i = 0; i < num; i++)
	{
		cin >> tower;
		while (!s.empty())
		{
			// 수신탑을 발견했을 때
			if (tower < s.top().val)
			{
				// 인덱스 출력
				cout << s.top().idx << " ";
				break;
			}
			// 수신탑을 찾을 때까지 pop
			s.pop();
		}
		// 수신 탑이 없다면 0
		if (s.empty())
			cout << 0 << " ";
		s.push((loc){i + 1, tower});
	}
	return (0);
}