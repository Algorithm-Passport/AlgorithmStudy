#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
int N, M;
using namespace std;

int binarySearch(vector<string>::iterator v, int size, string d)
{
    int s = 0; //시작
    int e = size - 1; //끝
    int m;
    while (s <= e) {
        m = (s + e) / 2;
        if (*(v + m) == d) return m;
        else if (*(v + m) > d) e = m - 1;
        else s = m + 1;
    }
    return -1;
}

int main(void)
{
    ios::sync_with_stdio(0);
    cin >> N >> M;
    vector<string> v1;
    vector<string> ret;

    for (int i = 0; i < N; i++)
    {
        string s1;
        cin >> s1;
        v1.push_back(s1);
    }
	sort(v1.begin(), v1.end());

	for (int j  = 0; j < M; j++)
	{
		string s2;
		cin >> s2;
		if(binarySearch(v1.begin(), v1.size(), s2) != -1)
		{
			ret.push_back(s2);
		}
	}
	sort(ret.begin(), ret.end());

    cout << ret.size() << '\n';
    vector<string>::iterator iter;
    for (iter = ret.begin(); iter != ret.end(); iter++)
    {
        cout << *iter << '\n';
    }
}
