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

	for (int i = 0; i < m; i++) { //map ä�� �ֱ�
		cin >> map[i][0] >> map[i][1];
	}
	for (int i = 0; i < m; i++) {
		if (map[i][0] == 1) {  //���� �� ó�� 1�̸�
			int check = map[i][1]; //�� 1 �� ���ڸ� check�� �޾Ƽ�
			list[check] = 1; //list�迭�� check�ش��ϴ� ��° �迭 1�� ä���
			for (int j = 0; j < m; j++) { //���� �̹� ä�� �� ���¶��(ģ���� ģ�����)
				if (map[j][0] == check) //��ó�� ���̰� check������ ģ�����
					list[map[j][1]] = 1; //�� ���� �ش��ϴ� ��° ģ������ 1�� ä���
				else if (map[j][1] == check) //�ݴ�� �Ǿ� �ִ� ��Ȳ���� üũ
					list[map[j][0]] = 1;
			}
		}
	}


	for (int i = 2; i <= n; i++) { //1�ΰ� ���� ���ʹϱ�
		if (list[i] == 1) { //1�� ä���������� result�� ����
			//printf("%d i\n", i);
			result++;
		}
	}

	cout << result << "\n";
	return 0;

}
