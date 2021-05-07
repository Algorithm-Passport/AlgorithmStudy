#include <iostream>
#include <cstring>
using namespace std;

/*
1. 세미 콜론 2개를 0000으로 바꾼다.
2. 맨 앞 또는 맨 뒤에 콜론이 있으면 삭제한다.
3. 0이 비어 있는 경우에 0을 채워준다.
*/

void cal(string n)
{
    /* 생략된 곳 넣을 칸, :의 개수 || 숫자의개수 */
    int insert_index = -1, count = 0;

    /* 1. 콜론 2개를 처리한다. */
    for (int i = 0; n[i]; i++)
    {
        if (n[i] == ':' && n[i + 1] != ':')
            count++;
        if (n[i] == ':' && n[i + 1] == ':')
        {
            insert_index = i;
            i++;
        }
    }
    if (insert_index != -1)
    {
        n.erase(insert_index, 1);
        if (n.front() == ':' || n.back() == ':')
        {
            for (int i = 0; i < 7 - count; i++)
                n.insert(insert_index, ":0000");
        }
        else
        {
            for (int i = 0; i < 6 - count; i++)
                n.insert(insert_index, ":0000");
        }
    }
    /* 2. 맨 앞 또는 맨 뒤의 콜론 제거 */
    if (n[0] == ':')
        n.erase(0, 1);
    if (n.back() == ':')
        n.erase(n.length() - 1, 1);
    /* 3. 빈 칸에 0이 있으면 0을 채운다. */
    count = 0;
    for (int i = 0; i <= n.length(); i++)
    {
        if (n[i] != ':' && n[i] != '\0')
            count++;
        else if (n[i] == ':' || n[i] == '\0')
        {
            if (count != 4)
            {
                for (int j = 0; j < 4 - count; j++)
                    n.insert(i - count, "0");
            }
            i += 4 - count;
            count = 0;
        }
    }
    cout << n;
}

int main()
{
    string n;

    cin >> n;
    cal(n);
    return (0);
}