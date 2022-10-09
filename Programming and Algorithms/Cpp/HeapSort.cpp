#include <bits/stdc++.h>
using namespace std;

void maxHeapify(int arr[], int n, int i)
{
    while (true)
    {
        int greatest = i;
        int left_child_idx = 2 * i + 1;
        int right_child_idx = 2 * i + 2;
        if (left_child_idx < n and arr[left_child_idx] > arr[greatest])
        {
            greatest = left_child_idx;
        }
        if (right_child_idx < n and arr[right_child_idx] > arr[greatest])
        {
            greatest = right_child_idx;
        }
        if (greatest == i)
        {
            return;
            // means not changing already heapify
        }
        else
        {
            swap(arr[i], arr[greatest]);
            i = greatest;
        }
    }
}
// step 1
void buildHeap(int arr[], int n)
{
    // it make the maximum element at the top
    for (int i = (n - 2) / 2; i >= 0; i--)
    {
        maxHeapify(arr, n, i);
    }
}

void heapSort(int arr[], int n)
{
    buildHeap(arr, n); // now all the element at it greatets positon
    // This is O(n)
    // This is O(n* log(n))
    for (int i = n - 1; i >= 0; i--)
    {
        swap(arr[0], arr[i]); // swap the largest element at first with last element
        //  now the new element at index 0 is do not the graeets
        maxHeapify(arr, i, 0);
        //  becasue now size i = n-1;
        // and we only have to heapify Oth element
    }
}

void printArray(int arr[], int n)
{
    for (int i = 0; i < n; ++i)
        cout << arr[i] << " ";
    cout << "\n";
}

int main()
{
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = sizeof(arr) / sizeof(arr[0]);

    heapSort(arr, n);

    cout << "Sorted array is \n";
    printArray(arr, n);
    priority_queue<int, vector<int>, greater<int>> pq;

    pq.push(10);
    pq.push(20);
    // cout<<pq.top()<<endl;
    return 0;
}
