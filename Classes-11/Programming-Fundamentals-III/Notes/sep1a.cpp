#include <iostream>

using namespace std;

//void swapValues(int x, int y);

void swapValues(int *x, int *y)
{
   int tmp;

   tmp=*x;
   *x=*y;
   *y=tmp;
}

int main(void)
{
    int a, b;

    a = 2;
    b = 3;

    cout << "a = " << a << ", b = " << b << endl;

    swapValues(&a, &b);

    cout << "a = " << a << ", b = " << b << endl;
}
