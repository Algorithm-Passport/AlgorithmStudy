#include <iostream>
#include <cstring>
using namespace std;
char p[500000];
char s[1000001];
int n, m;
int cnt = 0;
//배열 p만들기 
void find_p(int n) {
	for (int x = 0; x < 2 * n + 1; x++) {
		if (x % 2 == 0) {
			p[x] = 'I';
		}
		else p[x] = 'O';
	}
}
//배열 p개수 세기
int isExist()
{
	int ls = strlen(s);
	cnt = 0;
	for (int x = 0; x < ls; x++) {
		int flag = 1;
		for (int i = 0; i < 2 * n + 1; i++) {
			if (s[x + i] != p[i]) {
				flag = 0;
				break;
			}
		}
		if (flag)cnt++;
	}
	return cnt;
}
int main()
{
	cin >> n >> m;
	//배열 p 만들기/
	find_p(n);
	//배열 s입력
	cin >> s;
	//배열 p가 몇 개 있는지 isExist에서 센다
	int r = isExist();
	cout << cnt;
	return 0;
}