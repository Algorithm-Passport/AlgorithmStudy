#include <iostream>
#include <cstring>

/*
부호가 +,- 밖에 없으므로 +로 연결되어 있는 모든 곳을 묶으면 된다.
+만 있는 수식이면 모두 더해주고, -가 중간에 있으며 - 이후의 숫자들은 모두 빼준다.
*/

/* 특정 지점부터 부호가 NULL이 나올 때까지의 숫자를 반환한다. */
int atoi_s(char *c)
{
    char *temp = c;
    while (*temp)
    {
        if (*temp == '+' || *temp == '-')
            *temp = '\0';
        return (atoi(c));
        temp++;
    }
    return (0);
}

int main()
{
    int ans = 0, sum = 0, flag = 0;
    char in[100];
    char *s = in;

    scanf("%s", in);
    ans = atoi_s(s);
    /* 모든 문자를 탐색 */
    while (*s)
    {
        if (*s == '-')
        {
            ans -= atoi_s(s + 1);
            flag = 1;
        }
        if (*s == '+')
        {
            if (flag)
                ans -= atoi_s(s + 1);
            else
                ans += atoi_s(s + 1);
        }
        s++;
    }
    printf("%d", ans);
}