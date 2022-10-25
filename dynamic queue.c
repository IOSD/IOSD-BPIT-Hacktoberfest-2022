#include<stdio.h>
#include<stdlib.h>
typedef struct qt
{
	int data;
	struct qt *next;
}queue;

//display
void display(queue **f,queue **r)
{
	queue *p;
    if(*r==NULL)
       printf("empty\n");
    else
    {
  	
  	  for(p=(*f);p!=NULL;p=p->next)
  	    printf("%d-->",p->data);
      printf("NULL\n");
    }		
}

//insertion
void Qinsert(queue **f,queue **r,int x)
{
	queue *temp,*p;
	temp=(queue *)malloc(sizeof(queue));
	temp->data=x;
	temp->next=NULL;
	if(*r==NULL)
	   *r=*f=temp;
	else
	{
		 (*r)->next=temp;
		 *r=temp;
	}   
	display(&*f,&*r); 
}

int main()
{
	queue *f=NULL,*r=NULL;
	int choice,x,k;
 	do{
 		printf("\n-----menu----");
 		printf("\n 1.insert\n 2.delete\n 3.display\n 4.size\n 5.exit\n ");
 		printf("enter your choice : ");
 		scanf("%d",&choice);
 	    switch(choice)
 		{
 	case 1:
	        printf("enter the element to be entered: ");
	        scanf("%d",&x);
	        Qinsert(&f,&r,x);
        	break;  
	
//	case 2: Qdelete();
//	        break;
	
	case 3:
	        display(&f,&r);
	        break;
	
//	case 4:
//	     	k=size(*f,*r);
//		    printf("size is %d\n",k);
//	     	break;
	
	case 5:
	        printf("exited\n");
	     	break;
    
	default : 
	        printf("invalid choice\n");
			
	   }
       }while(choice!=5);
}
