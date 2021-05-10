/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ex1325.cpp                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: gak <marvin@42.fr>                         +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/05/07 08:43:24 by gak               #+#    #+#             */
/*   Updated: 2021/05/07 17:29:15 by gak              ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include<iostream>
#include<vector>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#include<algorithm>

using namespace std;

#define MAX 10001

int N, M;
vector <int> vec[MAX];
vector <int> check;
bool visit[MAX];
int cnt;

void DFS(int node_num) {
	visit[node_num] = true;

	for (int i = 0; i < vec[node_num].size(); i++) {
		int node_nextNum = vec[node_num][i];

		if (!visit[node_nextNum]) {
			cnt++;
			DFS(node_nextNum);
		}
	}
}

void init() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
}

int main() {
	init();
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int Start_point, End_point;
		cin >> Start_point >> End_point;
		vec[End_point].push_back(Start_point);
	}
	
	int node_count = 0;

	for (int i = 1; i <= N; i++) {
		memset(visit, false, sizeof(visit));
		cnt = 0;
		
		DFS(i);
		if (node_count == cnt)
			check.push_back(i);

		else if (node_count < cnt) {
			node_count = cnt;
			check.clear();
			check.push_back(i);
		}
	}
	
	sort(check.begin(), check.end());
	for (int i = 0; i < check.size(); i++)
		cout << check[i] << " ";
	
	return 0;
}
