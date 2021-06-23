#include <stdio.h>

int	main()
{
	int N, M, i = 0;

	scanf("%d %d", &N, &M);
	

	return (0);
}
/*
힙 : https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html
위상정렬, 우선순위 큐 정의
https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=mirzzz79&logNo=110023485592
그래프 용어 정리
https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=minichuuuuu&logNo=220808115381
1.모든 일의 선행 필요조건 관계를 따라 그래프를 그린다.

(방향 그래프 완성)

2. 각 일에 대해 indegree를 센다.(자신으로 들어오는 간선의 개수)

3. indegree가 0인 일을 모두 찾아 우선순위 큐에 넣는다

4. 우선순위 큐에서 일 하나를 꺼낸다.

(위상정렬의 결과 출력을 위해 이때 꺼내진 일을 출력하면 된다.)

5. 방금 꺼낸 일에 연결된 모든 일들의 indegree를 1씩 감소시킨다.

6. indegree가 감소된 일들 중 indegree가 0인 일이 있으면 우선순위 큐에 넣어준다.

7. 우선순위 큐가 빌 때까지 4~6을 반복한다.
*/