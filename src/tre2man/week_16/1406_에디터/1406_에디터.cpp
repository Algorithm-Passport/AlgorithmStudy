#include <bits/stdc++.h>
using namespace std;

/*
이 문제는 링크드 리스트가 적용되어 있는 자료 구조를 사용했다.
최대 60만개의 데이터를 한 번에 이동하기에는 시간이 너무 오래 걸린다.
list::erase 함수를 사용 시 맨 뒤에 있는 원소를 삭제 후, iter 연산이 불가능해진다.
왜냐하면 연속된 자료 구조가 아니여서 -- 연산으로 이전 원소로 이동하지 못한다.
erase 함수의 반환값을 이용하여 iter를 이동할 수 있다.
*/

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int num;
	char cmd, add;
	string temp;

	cin >> temp;
	list<char> l(temp.begin(), temp.end());
	auto idx = l.end();
	cin >> num;
	while (num--)
	{
		cin >> cmd;
		if (cmd == 'P')
			cin >> add;
		if (cmd == 'L' && (idx != l.begin()))
			idx--;
		else if (cmd == 'D' && (idx != l.end()))
			idx++;
		else if (cmd == 'B' && (idx != l.begin()))
			idx = l.erase(--idx);
		else if (cmd == 'P')
			l.insert(idx, add);
	}
	for (auto i = l.begin(); i != l.end(); i++)
		cout << *i;
	return (0);
}