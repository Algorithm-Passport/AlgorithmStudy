#include <iostream>
#include <string>
#include <stack>
using namespace std;
stack<int> bracket;
int bracket_cnt[2];

// -1 (
// -2 )
// -3 [
// -4 ]

int main(void)
{
	bracket.push(0);
	int index = 0;
	while (1)
	{
		char c;
		scanf("%c", &c);
		if (c == '\n')
			break;
		if (c == '(')
		{
			bracket_cnt[0]++;
			bracket.push(-1);
		}
		else if (c == ')')
		{
			bracket_cnt[0]--;
			if (bracket_cnt[0] < 0)
			{
				cout << 0 << '\n';
				return (0);
			}

			if (bracket.top() == - 1)
			{
				bracket.pop();
				if (bracket.top() > 0)
				{
					int temp = bracket.top();
					bracket.pop();
					bracket.push(2 + temp);
				}
				else
					bracket.push(2);
			}

			else if (bracket.top() < 0)
			{
				cout << 0 << '\n';
				return (0);
			}

			else if (bracket.top() > 0)
			{
				int temp = bracket.top();
				bracket.pop();
				if (bracket.top() != -1)
				{
					cout << 0 << '\n';
					return (0);
				}
				bracket.pop();
				if (bracket.top() > 0)
				{
					int temp2 = bracket.top();
					bracket.pop();
					bracket.push(temp * 2 + temp2);
				}
				else if (bracket.top() <= 0)
					bracket.push(temp * 2);
			}
		}		

		else if (c == '[')
		{
			bracket_cnt[1]++;
			bracket.push(-3);
		}
		else if (c == ']')
		{
			bracket_cnt[1]--;
			if (bracket_cnt[1] < 0)
			{
				cout << 0 << '\n';
				return (0);
			}

			if (bracket.top() == -3)
			{
				bracket.pop();
				if (bracket.top() > 0)
				{
					int temp = bracket.top();
					bracket.pop();
					bracket.push(3 + temp);
				}
				else
					bracket.push(3);
			}

			else if (bracket.top() < 0)
			{
				cout << 0 << '\n';
				return (0);
			}

			else if (bracket.top() > 0)
			{
				int temp = bracket.top();
				bracket.pop();
				if (bracket.top() != -3)
				{
					cout << 0 << '\n';
					return (0);
				}
				bracket.pop();
				if (bracket.top() > 0)
				{
					int temp2 = bracket.top();
					bracket.pop();
					bracket.push(temp * 3 + temp2);
				}
				else if (bracket.top() <= 0)
					bracket.push(temp * 3);
			}
		}
	}
	if (bracket_cnt[0] + bracket_cnt[1] != 0)
	{
		cout << 0 << '\n';
		return (0);
	}
	else
	{
		cout << bracket.top() << '\n';
		return (0);
	}
}







