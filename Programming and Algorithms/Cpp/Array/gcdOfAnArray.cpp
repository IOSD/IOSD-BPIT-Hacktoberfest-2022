#include <bits/stdc++.h>
using namespace std;

signed main()
{
    int n;
    cin >> n;

    int arr[n + 1];
    for (int i = 1; i <= n; i++)
        cin >> arr[i];

    int GCD = arr[1];
    for (int i = 2; i <= n; i++)
        GCD = __gcd(GCD, arr[i]);

    cout << "GCD of the array is : " << GCD;
}
