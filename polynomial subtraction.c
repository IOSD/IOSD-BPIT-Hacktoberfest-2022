#include<stdio.h>
#include<stdlib.h>
#include<process.h>
typedef struct poly
{
	int co;
	int ex;
	struct poly *next;
}PNODE;

//insertion
PNODE* insert(PNODE *h,int c,int e)
{
	PNODE *p,*temp;
	temp=(PNODE*)malloc(sizeof(PNODE));
	temp->co=c;
	temp->ex=e;
	temp->next=NULL;
	if(h==NULL)
	  h=temp;
	else
	{
	  for(p=h;p->next!=NULL;p=p->next);
	  p->next=temp;	
	} 
	return h;
}

//display
void display(PNODE *h)
{
	PNODE *p;
	printf("The polynomial is = ");  
	if(h==NULL)
	  printf("empty\n");
	else
	{
	for(p=h;p!=NULL;p=p->next)
	{
		if(p->co >= 0)
		{
			printf("+ %dx^%d ",p->co,p->ex);
		}
		else
		{	
		   printf(" %dx^%d ",p->co,p->ex);
		}
	}
	printf("\n");	
	}  
	
}

//creation of node            
PNODE* create(PNODE *h)
{   
    int n,i,c,e; 
	printf("enter the no. of terms: ");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
	  printf("enter the coefficient and exponent: ");
	  scanf("%d %d",&c,&e);
	  h=insert(h,c,e);
	}
	display(h);
	return h;	
}


//subtraction
PNODE* subtract(PNODE *h1,PNODE *h2)
{
    PNODE *h=NULL,*p,*t;
    p=h1;
    t=h2;
    while(p!=NULL && t!=NULL)
    {
     if(p->ex > t->ex)
     {
     	h=insert(h,p->co,p->ex);
     	p=p->next;
	 }
        
      else if(t->ex > p->ex)
      {
      	h=insert(h,t->co,t->ex);
      	t=t->next;
	  }
	  else
	  {
	  	h=insert(h,p->co - t->co,p->ex);
	  	p=p->next;
	  	t=t->next;
	  }
      }  
        while(t!=NULL)
        {
        	h=insert(h,t->co,t->ex);
        	t=t->next;
		}
	    while(p!=NULL)
		{
		  	h=insert(h,p->co,p->ex);
		  	p=p->next;
		}   
	
	display(h);
	return h;
}

int main()
{    
    PNODE *h1=NULL,*h2=NULL,*h=NULL;
	int ch;
	printf("\n\t\t-----creation of first polynomial-----\n"); 
	h1=create(h1);
	printf("\n\t\t-----creation of second polynomial-----\n"); 
	h2=create(h2);
	printf("\nAFTER SUBTRACTION\n");
	h=subtract(h1,h2);
	return 0;
}
