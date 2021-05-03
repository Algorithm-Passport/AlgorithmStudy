#include <iostream>
#include <string>
using namespace std;
int N, M;

bool is_valid(string::iterator dest, string::iterator sample)
{
	while(*dest && *sample)
	{
		if(*dest == *sample)
		{
			dest++;
			sample++;
		}
		else
			return (false);
	}
	return (true);
}	

int main(void)
{
	ios::sync_with_stdio(0);
	string s1;
	cin >> N >> M >> s;
	int cnt = 0;
	string s2 = "IOI";
	for (int i = 1; i < N; i++)
	{
		s2 += "OI";
	}
	string::iterator iter2 = s2.begin();
	for (string::iterator iter = s1.begin(); iter != s1.end(); s1++)
	{
		if(is_valid(iter, iter2))
		{
			cnt++;
		}
	}

			
	
	

