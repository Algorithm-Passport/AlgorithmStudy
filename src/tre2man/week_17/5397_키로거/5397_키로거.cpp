#include <bits/stdc++.h>
using namespace std;

/*
문자열의 길이가 최대 100만으로 매우 길다.
링크드 리스트를 이용한 구조 list를 이용한다.
각 상황에 맞추어 조건문을 제시한다.
erase는 반환값을 다시 대입하여 iter의 오류를 막는다.
*/

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int num;
	string input;

	cin >> num;
	while (num--)
	{
		cin >> input;
		list<char> s;
		auto idx = s.begin();

		for (auto c : input)
		{
			if (c == '<' && idx != s.begin())
				idx--;
			else if (c == '>' && idx != s.end())
				idx++;
			else if (c == '-' && idx != s.begin())
				idx = s.erase(--idx);
			else if (isalpha(c) || isdigit(c))
				s.insert(idx, c);
		}
		for (auto c : s)
			cout << c;
		cout << "\n";
	}
	return (0);
}