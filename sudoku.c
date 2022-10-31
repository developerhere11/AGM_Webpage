#include <stdio.h>
#include <stdlib.h>

#define N 9

void print(int arr[N][N])
{int i,j;
	for (i = 0; i < N; i++)
	{
		for (j = 0; j < N; j++)
			printf("%d ",arr[i][j]);
		printf("\n");
	}
}

int Safe(int grid[N][N], int r,
					int c, int num)
{
int x,i,j;
	for (x = 0; x <= 8; x++)
		if (grid[r][x] == num)
			return 0;

	for (x = 0; x <= 8; x++)
		if (grid[x][c] == num)
			return 0;

	int sR = r - r% 3,
				sC = c - c% 3;

	for (i = 0; i < 3; i++)
		for (j = 0; j < 3; j++)
			if (grid[i + sR][j +sC] == num)
				return 0;

	return 1;
}
int ss(int grid[N][N], int r, int c)
{
	if (r == N - 1 && c == N)
		return 1;

	if (c == N)
	{
		r++;
		c = 0;
	}

	if (grid[r][c] > 0)
		return ss(grid, r, c + 1);
int num;
	for (num = 1; num <= N; num++)
	{
		if (Safe(grid, r, c, num)==1)
		{
				grid[r][c] = num;
			if (ss(grid, r, c + 1)==1)
				return 1;
		}
		grid[r][c] = 0;
	}
	return 0;
}

int main()
{
	int grid[N][N];
	printf("Enter the values of  grid");
	int i,j;
	for(i=0;i<N;i++)
	{
		for(j=0;j<N;j++)
		{
			scanf("%d",&grid[i][j]);
		}
	}
    printf("The grid is\n ");
	for(i=0;i<N;i++)
	{
		for(j=0;j<N;j++)
		{
			printf("\n %d ",&grid[i][j]);
		}
	}
	if (ss(grid, 0, 0)==1)
		print(grid);
	else
		printf("No solution exists");

	return 0;
}
