/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ex1058.cpp                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: gak <marvin@42.fr>                         +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/05/07 17:29:38 by gak               #+#    #+#             */
/*   Updated: 2021/05/07 17:30:20 by gak              ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <iostream>
#include <string.h>
#include <algorithm>
#define MAX_N 50
using namespace std;

int main(){
    int N;
    string friends_each[MAX_N];
    int two_friend_cnt[MAX_N] = {0};
    cin >> N;
    for(int n=0; n<N; n++)
    {
        cin >> friends_each[n];
    }
    for(int n=0; n<N; n++)
    {
        for(int i=0; i<N; i++)
        {
            if(n==i)
            {
                continue;
            }
            if(friends_each[n][i]=='Y')
            {
                two_friend_cnt[n]++;
            }
             else if(friends_each[n][i]=='N')
            {
                for(int j=0; j<N; j++)
                {
                    if((friends_each[n][j] =='Y') && (friends_each[i][j] == 'Y'))
                    {
                        two_friend_cnt[n]++;
                        break;
                    }
                }
            }
        }
    }
    int ans = *max_element(two_friend_cnt,two_friend_cnt+N);
    cout << ans << "\n";
}
