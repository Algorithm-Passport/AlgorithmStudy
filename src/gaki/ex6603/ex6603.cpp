#include <iostream>
#include <algorithm>
#include <vector>
#include <string.h>
using namespace std;

int N;
vector <int> numSet;
int ans[6] = {0,};
int visit[14] = {0,};

void    initAll(void) {
    memset(ans, 0, sizeof(ans));
    memset(visit, 0, sizeof(visit));
}

void    printAns(void) {
    for (int i = 0; i < 6; i++) {
        cout << ans[i] << ' ';
    }
    cout << endl;
}

void    rec(int fill, int j, int len) {
    if (fill == 6) {
        printAns();        
    }
    else {
        for (int start = j + 1; start <= len - 6 + fill; start++) {
            ans[fill] = numSet[start];
            visit[start] = 1;
            rec(fill + 1, start, len);
            visit[start] = 0;
        }
    }
}

int     main(void)
{
	int		count = 0;

    while (1) {
        cin >> N;
		numSet.clear();
		initAll();
        if (N == 0)
            break ;
		if (count != 0)
			cout << endl;
        for (int i = 0; i < N; i++) {
            int temp;
            cin >> temp;
            numSet.push_back(temp);
        }

        int len = numSet.size(); // 8개의 숫자면 값은 8 ;
        
        for (int j = 0; j <= len - 6; j++) {
            ans[0] = numSet[j];
            visit[j] = 1;
            rec(1, j, len);
            visit[j] = 0;
        }
		count++;
    }
}