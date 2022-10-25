#include<stdio.h>
#include<stdlib.h>
typedef struct st
{
	int data;
	struct st *next;
}stack;

stack *top;

//push
void push(int x)
{
    stack *temp,*p;
	temp=(stack *)malloc(sizeof(stack));
	temp->data=x;
	temp->next=NULL; 
	if(top==NULL)
	   top=temp;
	else
	temp->next=top;
	top=temp;	
}
//pop
void pop()
{
	int x;
	stack *p;
	p=top;
	top=p->next;
	x=p->data;
	printf("%d has been popped\n",x);
	free(p);
}
//display
void  display()
{
 stack *p;
 for(p=top;p!=NULL;p=p->next)
 printf("%d\n",p->data);	
}
//size
int size()
{
 stack *p;
 int i;
 for(i=0,p=top;p!=NULL;i++,p=p->next);
 return i;	
}


 int main()
 {
 	int choice,x,k;
 	do{
 		printf("\n-----menu----");
 		printf("\n 1.push\n 2.pop\n 3.display\n 4.size\n 5.exit\n ");
 		printf("enter your choice : ");
 		scanf("%d",&choice);
 	    switch(choice)
 		{
 	case 1:
	        printf("enter the element to be entered: ");
	        scanf("%d",&x);
	        push(x);
        	break;  
	
	case 2: pop();
	        break;
	
	case 3:
	        display();
	        break;
	
	case 4:
	     	k=size();
		    printf("size is %d\n",k);
	     	break;
	
	case 5:
	        printf("exited\n");
	     	break;
    
	default : 
	        printf("invalid choice\n");
			
	   }
       }while(choice!=5);
   }
 
 
