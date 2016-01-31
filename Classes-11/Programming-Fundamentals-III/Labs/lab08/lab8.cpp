#include <iostream>
#include <string>

using namespace std;

class mergesort
{
  public:
    mergesort(int a[], int n)
    {
        rmergesort(a, n);
    }


    void rmergesort(int a[], int n)
    {
        int bn = n/2;
        int cn = n - n/2;
        int b[bn];
	int c[cn];
        if (n < 2)        //the list0 has fewer than two items:  return
	{
	   return;
	}
	int i = 0;
        int k = 0;
        while (i < bn)   //copy first half of list0 to list1
	{
	   b[i] = a[i];
	   i++;
	}
        
	while (i < n)     //copy second half of list0 to list2
	{
	   c[k] = a[i];
           k++;
	   i++;
	}
        cout << "BREAKING DOWN: list =   DUMP: (size = " << n << ", first = " << a[0] << ", last = " << a[n-1] << ")" << endl;
	cout << "    DUMP:   head = : " << a[0] << endl;
        for (int z = 1; z < n; z++)
        {
	   cout << "    DUMP:   data = : " << a[z] << endl;
	}
        if (bn > 1)     //list1 has more than one element
        {                //call rmergesort with list1
	   rmergesort(b, bn);
	}
        if (cn > 1)    //list2 has more than one element
        {               //call rmergesort with list2
	   rmergesort(c, cn);
	}
	int j = 0;
        k = 0;
        i = 0;
                       //(merge list1 and list2 into list0)
        while (bn != 0 && cn != 0) //there are items in both lists:
        {                                  //compare first items from two lists
	   if (b[k] < c[j])                                //put smaller one in combined list
	   {
	      a[i] = b[k];
              k++;
              i++;
              bn--;
	   }
	   else
	   {
	      a[i] = c[j];
              j++;
              i++;
              cn--;
	   }
	}

        while (bn != 0 || cn != 0) //copy remaining items of longer list to combined list
	{
	   if (bn != 0)
	   {
	      a[i] = b[k];
              bn--;
	      k++;
              i++;
	   }
	   else
	   {
	      a[i] = c[j];
              cn--;
              j++;
              i++;
	   }

	}
	cout << "MERGED: list =    DUMP: (size = " << n << ", first = " << a[0] << ", last = " << a[n-1] << ")" << endl;
	cout << "    DUMP:   head = : " << a[0] << endl;
        for (int z = 1; z < n; z++)
        {
	   cout << "    DUMP:   data = : " << a[z] << endl;
	}
    }
};
int main(void)
{
    int ar[100];

    int i, v, len;

    for (i=0; i<100; i++) {
        cout << "enter a number (-1 to quit): ";
        cin >> v;

        if (v < 0) break;

        ar[i] = v;
    }

    len = i;

    cout << "main:  before sort:\n";
    for (i=0; i<len; i++) {
        cout << "main:  ar[" << i << "] = " << ar[i] << endl;
    }

    mergesort ms(ar, len);

    cout << "main:  after sort:\n";
    for (i=0; i<len; i++) {
        cout << "main:  ar[" << i << "] = " << ar[i] << endl;
    }
}

