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
Write Preview
Add heading text
Add bold text, <Ctrl+b>
Add italic text, <Ctrl+i>
Add a quote, <Ctrl+Shift+.>
Add code, <Ctrl+e>
Add a link, <Ctrl+k>
Add a bulleted list, <Ctrl+Shift+8>
Add a numbered list, <Ctrl+Shift+7>
Add a task list, <Ctrl+Shift+l>
Directly mention a user or team
Reference an issue, pull request, or discussion
Add saved reply
Attach files by dragging & dropping, selecting or pasting them.
Styling with Markdown is supported
Start a review
Add single comment
Cancel
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
