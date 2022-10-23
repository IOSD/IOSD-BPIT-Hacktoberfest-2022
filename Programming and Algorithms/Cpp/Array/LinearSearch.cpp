#include <bits/stdc++.h>
using namespace std;

// Linearly search x in arr[]. If x is present then return its location, otherwise it will return -1
int LinearSearch(int arr[], int n, int x)
{
	int i;
	for (i = 0; i < n; i++)
		if (arr[i] == x)
			return i;
	return -1;
}

int main()
{
	int arr[] = { 3, 4, 1, 7, 5,2,8 };
	int n = 7;
	int x = 4;

	int position = LinearSearch(arr, n, x);
	if (position == -1)
		cout <<x << " is not present in the array";
	else
		cout << x<< " found at position " << position;

	return 0;
}
