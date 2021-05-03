#include <iostream>
#include <string>
using namespace std;

int main()
{
	string a = "abcedf";
	for (int i =0; i < 100 ;i++)
	{
		if (a[i])
		{
			cout << a[i];
		}
	}
}
