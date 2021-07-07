#include <bits/stdc++.h>
using namespace std;

/*
set을 이용했다.
중복이 되지 않으며, 자동정렬이 되는 구조를 이용함.
enter 일때 이름삽입, leave일때 이름제거
*/

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int num;
	string name, stat;
	set<string, greater<string>> s;

	cin >> num;
	while (num--)
	{
		cin >> name;
		cin >> stat;
		if (!stat.compare("enter"))
			s.insert(name);
		else if (!stat.compare("leave"))
			s.erase(name);
	}
	for (auto i : s)
		cout << i << "\n";
}