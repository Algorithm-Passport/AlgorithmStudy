#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <stack>
#include <string>

using namespace std;
int n;
int m;
int map[10001][2] = { 0 };
int list[501] = { 0 };
int result = 0;

int main()
{
	cin >> n;
	cin >> m;

	for (int i = 0; i < m; i++) { //map 채워 넣기
		cin >> map[i][0] >> map[i][1];
	}
	for (int i = 0; i < m; i++) {
		if (map[i][0] == 1) {  //만약 맨 처음 1이면
			int check = map[i][1]; //그 1 옆 숫자를 check로 받아서
			list[check] = 1; //list배열에 check해당하는 번째 배열 1로 채우기
			for (int j = 0; j < m; j++) { //만약 이미 채워 진 상태라면(친구의 친구라면)
				if (map[j][0] == check) //맨처음 아이가 check상태인 친구라면
					list[map[j][1]] = 1; //그 옆에 해당하는 번째 친구에도 1로 채우고
				else if (map[j][1] == check) //반대로 되어 있는 상황에도 체크
					list[map[j][0]] = 1;
			}
		}
	}


	for (int i = 2; i <= n; i++) { //1인건 빼고 부터니까
		if (list[i] == 1) { //1로 채워져있으면 result를 증가
			//printf("%d i\n", i);
			result++;
		}
	}

	cout << result << "\n";
	return 0;

}
