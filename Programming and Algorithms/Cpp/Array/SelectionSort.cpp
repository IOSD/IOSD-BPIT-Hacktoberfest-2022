#include <bits/stdc++.h>
using namespace std;

//Swap function
void swap(int *xp, int *yp)
{
	int temp = *xp;
	*xp = *yp;
	*yp = temp;
}

void SelectionSort(int arr[], int n)
{
	int i, j, minIdx;

	for (i = 0; i < n-1; i++)
	{
		minIdx = i;
		for (j = i+1; j < n; j++)
		if (arr[j] < arr[minIdx])
			minIdx = j;

		// Swap the minimum element with the first element
		if(minIdx!=i)
			swap(&arr[minIdx], &arr[i]);
	}
}

void display(int arr[], int size)
{
	for (int i=0; i < size; i++)
		cout << arr[i] << " ";
}


int main()
{
	int arr[] = {64, 25, 12, 22, 11};
	int n = 5;
	SelectionSort(arr, n);
	cout << "Sorted array: \n";
	display(arr, n);
	return 0;
}
