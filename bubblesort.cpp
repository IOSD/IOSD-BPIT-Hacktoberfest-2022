#include<iostream>
#include<bits\stdc++.h>
using namespace std;
#include<vector>
void bubblesort(vector<int>&arr)
{
    for(int i=0;i<arr.size();i++)
    {
         bool swaped=false;
        for(int j=0;j<arr.size()-i-1;j++)
        {
            if(arr[j]>arr[j+1])
            { 
               bool swaped=true;
//     swaping the element when condition is satisfied        
                swap(arr[j+1],arr[j]);
            }
        }
    
         if( swaped==true){
             break;
         }
    }
//  for traversal of array
     for(int ele:arr){
        cout<<ele<<" "; 
    }
}
// creating main function 
int main()
{
    vector<int>arr={2,5,9,3,8,6,2};

//   calling function bubblesort 
     cout<<"Sorted array : ";
    bubblesort(arr);
    return 0;
}
    
