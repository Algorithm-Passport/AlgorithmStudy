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
		for (int x = 1; x < n; x++) { //x�࿡�� �񱳸� ����
			if (map[y][x] == map[y][x - 1]) //���� ���� ���� ������
				count++; //count ����
			else count = 1; //���� �� ������ 1�� ��
			ret = max(count, ret); //ret�� ret �״�ΰų� count
		}
	}

	for (int x = 0; x < n; x++) { //y�࿡�� �񱳸� ����
		int count = 1; //count=1�� �ʱ�ȭ
		for (int y = 1; y < n; y++) {
			if (map[y][x] == map[y - 1][x]) //���� ���� ���� ������
				count++; //count ����
			else
				count = 1; //������ �״�� 1
			ret = max(count, ret); //ret ������Ʈ
		}
	}
	return ret; //ret��ȯ


}

int main()
{
	cin >> n;
	for (int y = 0; y < n; y++) {
		for (int x=0; x < n; x++) {
			cin >> map[y][x]; //���� �Է¹��� ���ڷ� ä�� �д�
		}
	}

	int ans = 0;
	for (int y = 0; y < n; y++) {
		for (int x = 0; x < n; x++) {
			if (x + 1 < n) {
				swap(map[y][x], map[y][x + 1]); //�ٷ� ���� (x�� ��)�ִ� �Ͱ� ��ȯ�ϰ�
				ans = max(ans, eatCandy()); // ans �� ������Ʈ ���ش�
				swap(map[y][x], map[y][x + 1]); //�׸��� �ٽ� �����ٷ�
			}

			if (y + 1 < n) {
				swap(map[y][x], map[y + 1][x]); //�ٷ� ���� (y�� ��)�ִ� �Ͱ� ��ȯ�ϰ�
				ans = max(ans, eatCandy()); //ans�� ������Ʈ ���ش�
				swap(map[y][x], map[y + 1][x]); //�׸��� �ٽ� �������
			}
		}
	}

	cout << ans; //ans���
	return 0;

}
