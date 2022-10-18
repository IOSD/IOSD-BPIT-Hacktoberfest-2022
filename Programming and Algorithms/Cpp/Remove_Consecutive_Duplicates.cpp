#include <iostream>
#include <cstring>
using namespace std;

void removeConsecutiveDuplicates(char input[]) {
    // Write your code here  
    //int j, n = strlen(input);
      int j, n = strlen(input);
    for (int i = j = 0; i < n; i++)
        if (input[i] != input[i+1])
            input[j++] = input[i];
 
    input[j] = '\0';
}

int main() {
    int size = 1e6;
    char str[size];
    cin >> str;
    removeConsecutiveDuplicates(str);
    cout << str;
}
