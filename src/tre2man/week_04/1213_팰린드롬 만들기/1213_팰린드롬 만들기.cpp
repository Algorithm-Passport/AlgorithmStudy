#include <iostream>
#include <cstring>
#include <vector>
using namespace std;

/*
재귀함수를 이용해서 풀이

안되는 경우의 수
2개 이상의 서로 다른 문자가 홀수 개 있을 경우

되는 경우의 수
1. 모든 문자가 짝수 개 있을 경우
2. 1개의 문자가 홀수 개 있을 경우

1의 경우에는 오름차순으로 n/2개씩 순서대로 출력 후 내림차순으로 n/2개씩 출력한다.
2의 경우에는 홀수 개 있는 문자가 중간에 1개 들어가야 하고, 나머지는 1의 순서대로 출력한다.
*/

#define alpha_len 26

int ans[alpha_len + 1];
int odd = -1;
string s;

void print_ans(int n)
{
    /* 마지막이고 홀수 개 있는 문자 존재 시 1개 출력, 문자열의 중간에 위치, 재귀함수 탈출*/
    if (n == 27)
    {
        if(odd != -1)
            printf("%c", odd + 64);
        return;
    }
    /* 답을 반으로 나눌 시 좌측 문자열 */    
    for (int i = 1; i <= ans[n] / 2; i++)
        printf("%c", n + 64);
    /* 다음 알파벳 호출 */
    print_ans(n + 1);
    /* 답을 반으로 나눌 시 우측 문자열 */
    for (int i = 1; i <= ans[n] / 2; i++)
        printf("%c", n + 64);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    memset(ans, 0, sizeof(ans));
    cin >> s;
    for (int i = 0; i < s.length(); i++)
        ans[s[i] - 64]++;
    for (int i = 1; i <= alpha_len; i++)
    {
        if (ans[i] % 2 && odd != -1)
        {
            cout << "I'm Sorry Hansoo";
            return (0);
        }
        if (ans[i] % 2 && odd == -1)
            odd = i;
    }
    print_ans(1);
    return (0);
}