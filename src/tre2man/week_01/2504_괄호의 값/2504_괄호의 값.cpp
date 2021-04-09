#include <iostream>
#include <stdlib.h>
#include <stack>
#include <queue>
#include <vector>
using namespace std;

vector<int> v;
char str[31];

/*
여는 괄호일 때 문자를 숫자로 변환하여 push 
닫는 괄호 1칸짜리, 괄호 없애고 2 또는 3 push
닫는 괄호 사이에 숫자 있을 경우, 곱해서 push
숫자가 연속으로 있을 경우 모두 합쳐준다.

문자 변환
'(' = -1, ')' = -2, '[' = -3, ']' = -4

*/

void cal()
{
    int index = -1, ans = 0;
    while (str[++index])
    {
        /* 여는 괄호일 경우 */
        if (str[index] == '(')
            v.push_back(-1);
        else if (str[index] == '[')
            v.push_back(-3);
        /* 1칸짜리 닫는 괄호일 경우 */
        else if (v.size() > 0 && str[index] == ')' && v.back() == -1)
        {
            v.pop_back();
            v.push_back(2);
        }
        else if (v.size() > 0 && str[index] == ']' && v.back() == -3)
        {
            v.pop_back();
            v.push_back(3);
        }
        /* 괄호 쌍 사이에 숫자가 있는 경우 */
        else if (v.size() > 1 && str[index] == ')' && *(v.end() - 2) == -1)
        {
            int temp = v.back() * 2;
            v.pop_back();
            v.pop_back();
            v.push_back(temp);
        }
        else if (v.size() > 1 && str[index] == ']' && *(v.end() - 2) == -3)
        {
            int temp = v.back() * 3;
            v.pop_back();
            v.pop_back();
            v.push_back(temp);
        }
        /* 위의 모든 경우에 충족하지 않으면 올바르지 못한 괄호열 */
        else
        {
            v.push_back(-1);
            return;
        }
        /* 스택(벡터) 안에 숫자가 연속으로 있을 경우 모조리 더해준다. */
        while (v.size() > 1 && v.back() > 1 && *(v.end() - 2) > 1)
        {
            int temp = v.back() + *(v.end() - 2);
            v.pop_back();
            v.pop_back();
            v.push_back(temp);
        }
    }
}

int main()
{
    scanf("%s", str);
    cal();
    if (v.size() == 1 && v.back() > 1)
        printf("%d", v.back());
    else
        printf("0");
    return (0);
}