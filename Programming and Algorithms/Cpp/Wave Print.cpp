#include <iostream>
using namespace std;

void wavePrint(int **input, int nRows, int mCols)
{
    int i,j=0;    //i - iteration through the rows and j - iteration through columns
    while(j<mCols){
        if(j%2==0){     //for even values of j like 0,2,4...
            for(i=0;i<nRows;i++){
                cout<<input[i][j]<<" ";
                if(i==(nRows-1)){
                    break;    //to come out of the loop and increment j
                }
            }
            j++;
        }else{      //for odd values of j like 1,3,5...
            for(i=(nRows-1);i>=0;i--){
                cout<<input[i][j]<<" ";
                if(i==0){
                    break;
                }
            }
            j++;
        }
    }
}

int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int row, col;
		cin >> row >> col;
		int **input = new int *[row];
		for (int i = 0; i < row; i++)
		{
			input[i] = new int[col];
			for (int j = 0; j < col; j++)
			{
				cin >> input[i][j];
			}
		}
		wavePrint(input, row, col);
		cout << endl;
	}
}
