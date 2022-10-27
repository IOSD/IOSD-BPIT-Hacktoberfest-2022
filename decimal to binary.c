#include<stdio.h>
#define max 20
int main()
{
	int stack[max],top=-1;
	int x;
	printf("enter the decimal number: ");
	scanf("%d",&x);
	while(x!=0)
	{
		stack[++top]=(x%2);
		x=x/2;
	}
	printf("\nthe binay number is : ");
	while(top!=-1)
	{
		printf("%d",stack[top--]);
	}
	return 0;
}
