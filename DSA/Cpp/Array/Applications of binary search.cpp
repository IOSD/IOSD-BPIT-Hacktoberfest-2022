#include <bits/stdc++.h>
#define int long long
using namespace std;

void integer_square_root()
{
    int a, ans = 0;
    cin >> a;
    int low = 1, high = a;
    while (low <= high)
    {
        int mid = (high + low) / 2;
        if (mid * mid <= a)
        {
            ans = mid;
            low = mid + 1;
        }
        else
            high = mid - 1;
    }
    cout << ans << endl;
}

int frequency_of_target(int arr[], int a, int target)
{
    if (lower_bound(arr, arr + a, target) - arr == a)
        return -1;
    else
    {
        int lb = lower_bound(arr, arr + a, target) - arr;
        int ub = upper_bound(arr, arr + a, target) - arr;
        return ub - lb;
    }
}

// upper bound returns the first element present in array greater than the target.
int upper_bound(int arr[], int a, int target)
{
    // return upper_bound(arr,arr+a,target)-arr;
    int high = a - 1, low = 0, ans = -1;
    while (low <= high)
    {
        int mid = (high + low) / 2;
        if (arr[mid] > target)
        {
            ans = mid;
            high = mid - 1;
        }
        else
            low = mid + 1;
    }
    return ans;
}

// lower bound returns the first element present in array greater or equal to the target.
int lower_bound(int arr[], int a, int target)
{
    // return lower_bound(arr,arr+a,target)-arr;
    int high = a - 1, low = 0, ans = -1;
    while (high >= low)
    {
        int mid = (high + low) / 2;
        if (arr[mid] >= target)
        {
            ans = mid;
            high = mid - 1;
        }
        else
            low = mid + 1;
    }
    return ans;
}

int last_occurence(int arr[], int a, int target)
{
    int low = 0, high = a - 1, ans = -1;
    while (low <= high)
    {
        int mid = (high + low) / 2;
        if (arr[mid] == target)
        {
            ans = mid;
            low = mid + 1;
        }
        else if (arr[mid] < target)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return ans;
}

int first_occurence(int arr[], int a, int target)
{
    int high = a - 1, low = 0, ans = -1;
    while (low <= high)
    {
        int mid = (high + low) / 2;
        if (arr[mid] == target)
        {
            ans = mid;
            high = mid - 1;
        }
        else if (arr[mid] > target)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return ans;
}

int find_element(int arr[], int a, int target)
{
    int low = 0, high = a - 1;
    while (low <= high)
    {
        int mid = (high + low) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return -1;
}

int32_t main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    // integer_square_root();
    int a;
    cin >> a;
    int arr[a];
    for (int i = 0; i < a; i++)
        cin >> arr[i];
    sort(arr, arr + a);
    int target;
    cin >> target;
    // cout<<find_element(arr,a,target)<<endl;
    // cout<<first_occurence(arr,a,target)<<endl;
    // cout<<last_occurence(arr,a,target)<<endl;
    // cout<<lower_bound(arr,a,target)<<endl;
    // cout<<upper_bound(arr,a,target)<<endl;
    // cout<<frequency_of_target(arr,a,target)<<endl;
    return 0;
}