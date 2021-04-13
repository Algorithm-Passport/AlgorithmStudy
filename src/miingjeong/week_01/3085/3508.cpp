#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <stack>
#include <string>

using namespace std;
int n;
char map[50][50];

int eatCandy() {
	int ret = 1;

	for (int y = 0; y < n; y++) {
		int count = 1;
		for (int x = 1; x < n; x++) { //x축에서 비교를 해줌
			if (map[y][x] == map[y][x - 1]) //전과 같은 것이 있으면
				count++; //count 증가
			else count = 1; //같은 거 없으면 1로 둠
			ret = max(count, ret); //ret은 ret 그대로거나 count
		}
	}

	for (int x = 0; x < n; x++) { //y축에서 비교를 해줌
		int count = 1; //count=1로 초기화
		for (int y = 1; y < n; y++) {
			if (map[y][x] == map[y - 1][x]) //전과 같은 것이 있으면
				count++; //count 증가
			else
				count = 1; //없으면 그대로 1
			ret = max(count, ret); //ret 업데이트
		}
	}
	return ret; //ret반환


}

int main()
{
	cin >> n;
	for (int y = 0; y < n; y++) {
		for (int x=0; x < n; x++) {
			cin >> map[y][x]; //맵을 입력받은 문자로 채워 둔다
		}
	}

	int ans = 0;
	for (int y = 0; y < n; y++) {
		for (int x = 0; x < n; x++) {
			if (x + 1 < n) {
				swap(map[y][x], map[y][x + 1]); //바로 다음 (x축 옆)있는 것과 교환하고
				ans = max(ans, eatCandy()); // ans 를 업데이트 해준다
				swap(map[y][x], map[y][x + 1]); //그리고 다시 원래다로
			}

			if (y + 1 < n) {
				swap(map[y][x], map[y + 1][x]); //바로 다음 (y축 옆)있는 것과 교환하고
				ans = max(ans, eatCandy()); //ans를 업데이트 해준다
				swap(map[y][x], map[y + 1][x]); //그리고 다시 원래대로
			}
		}
	}

	cout << ans; //ans출력
	return 0;

}
