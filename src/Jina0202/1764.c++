#include <iostream>
#include <string>
using namespace std;

int n, m;
char see[500000][21], hear[500000][21], result[500000][21];
int isSame(int y)
{
	for (int i = 0; i < n; i++) {
		int flag = 1;
		for (int j = 0; hear[i][j]; j++) {
			if (see[y][j] != hear[i][j]) {
				flag = 0;
				break;
			}
		}
		if (flag)return 1;
	}
	return 0;
}
int main()
{
	//입력
	cin >> m >> n;
	for (int y = 0; y < m; y++) {
		cin >> see[y];
	}
	for (int y = 0; y < n; y++) {
		cin >> hear[y];
	}
	//isSame 함수로 듣보잡 명단 구하기, 개수 세기
	int cnt = 0;
	int t = 0;
	//see배열을 기준으로 hear배열과 비교
	for (int y = 0; y < m; y++) {
		int r = isSame(y);
		if (r) {
			cnt++;
			for (int x = 0; see[y][x]; x++) {
				result[t][x] = see[y][x];
			}
			t++;
		}
	}
	//듣보잡 수
	cout << cnt << "\n";
	//사전순 배치
	for (int y1 = 0; y1 < t; y1++) {
		int change = 1;
		for (int y2 = 0; y2 < y1; y2++) {
			for (int x = 0; x < 21; x++) {
				if (result[y2][x] > result[y1][x]) {
					change = 1;
					break;
				}
				else if (result[y2][x] < result[y1][x]) {
					change = 0;
					break;
				}
			}//change=1일때만 SWAP
			if (change) {
				for (int x = 0; x < 21; x++) {
					int temp = result[y1][x];
					result[y1][x] = result[y2][x];
					result[y2][x] = temp;
				}
			}
		}
	}
	//result 배열 출력
	for (int y = 0; y < t; y++) {
		for (int x = 0; result[y][x]; x++) {
			cout << result[y][x];
		}
		cout << "\n";
	}
	return 0;
}
