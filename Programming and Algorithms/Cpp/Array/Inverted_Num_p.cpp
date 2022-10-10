#include<iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int i = n;
    while(i > 0){
        for(int j = 1; j <= i; j++){
            cout<<i;
        }
        cout<<endl;
        i--;
    }
}
