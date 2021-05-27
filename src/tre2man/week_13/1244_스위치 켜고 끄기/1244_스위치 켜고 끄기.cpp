#include <bits/stdc++.h>
using namespace std;

void vprint(vector<int> v)
{
	for (int i = 0; i < v.size(); i++)
	{
		if (i && (i % 20 == 0))
			cout << "\n";
		if (v[i] == -1)
			cout << "0";
		else
			cout << "1";
		if (i != v.size() - 1)
			cout << " ";
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int switchs, k, snum, gen, num;
	vector<int> v;

	cin >> switchs;
	for (int i = 0; i < switchs; i++)
	{
		cin >> k;
		if (!k)
			k = -1;
		v.push_back(k);
	}
	cin >> snum;
	for (int i = 0; i < snum; i++)
	{
		cin >> gen >> num;
		if (gen == 1)
		{
			for (int j = 0; j < switchs; j++)
			{
				if ((j + 1) % num == 0)
					v[j] *= -1;
			}
		}
		else
		{
			v[num - 1] *= -1;
			for (int j = 0; num - j - 1 >= 0 && num + j - 1 < switchs; j++)
			{
				if (v[num - j - 1] != v[num + j - 1])
					break;
				else
				{
					v[num - j - 1] *= -1;
					v[num + j - 1] *= -1;
				}
			}
		}
	}
	vprint(v);
	return (0);
}