#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int num;
	cin >> num;
	while (num--)
	{
		deque<int> dq;
		bool isRev = false, isErr = false;
		string command, num;
		int len;
		char temp;

		cin >> command;
		cin >> len;
		cin >> num;

		/* 두 자리 이상의 수가 들어올 수 있으므로, 맨 앞자리인 경우에만 push_back */
		for (int i = 1; i < num.length(); i++)
		{
			if (len && (num[i - 1] == '[' || num[i - 1] == ','))
				dq.push_back(atoi(&num[i]));
		}

		/* 각 명령어에 따라서 원소를 관리한다. */
		for (int i = 0; i < command.length(); i++)
		{
			if (command[i] == 'R')
				isRev = !isRev;
			else if (command[i] == 'D')
			{
				if (dq.empty())
				{
					isErr = true;
					break;
				}
				if (isRev)
					dq.pop_back();
				else
					dq.pop_front();
			}
		}

		/* 출력단 */
		if (isErr)
			cout << "error\n";
		else if (dq.empty())
			cout << "[]\n";
		else if (isRev)
		{
			cout << "[";
			while (dq.size() > 1)
			{
				cout << dq.back() << ",";
				dq.pop_back();
			}
			cout << dq.back() << "]\n";
		}
		else
		{
			cout << "[";
			while (dq.size() > 1)
			{
				cout << dq.front() << ",";
				dq.pop_front();
			}
			cout << dq.front() << "]\n";
		}
	}
	return (0);
}