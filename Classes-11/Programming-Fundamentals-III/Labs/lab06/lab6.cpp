#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

class heap
{
   private:
   
   int *ar;

   public:
   
   int l, count;

   heap(int s)
   {
      ar = new int[s];
      count = 0;
      l = s;
   }
   void put(int d)
   {
      count++;
      if (l == count)
      {
         int *newar = new int[l*2];
	 
	 for (int c = 1; c < l; c++)
	 {
	    newar[c] = ar[c];
	 }
	 l = l*2;
	 delete[] ar;
	 ar = newar;

      }
      ar[count] = d;
      int store, i = count;
      while (i/2 != 0 && ar[i] > ar[i/2])
      {
         int p = i/2;
	 store = ar[i];
	 ar[i] = ar[p];
	 ar[p] = store;
	 i = p;
      }
   }
   int pop()
   {
      cout << "count is " << count << endl;
      int store = ar[1];
      ar[1] = ar[count];
      ar[count] = -1;
      count--;
      int i = 1;
      while (i*2 <= count && ar[i] < ar[i*2] || ar[i] < ar[i*2+1])
      {
         if (ar[i*2] > ar[i*2+1])
	 {
	    int s = ar[i*2];
	    ar[i*2] = ar[i];
	    ar[i] = s;
	    i = i*2;
	 }
	 else 
	 {
	    int s = ar[i*2+1];
	    ar[i*2+1] = ar[i];
	    ar[i] = s;
	    i = i*2+1;
	 }
         
      }
      return store;
      
   }
    void dump()
    {
        for (int i=1; i<= count; i++) {
            cout << "    DUMP: node at index [" << i << "] = " << ar[i] << endl;
        }
        cout << endl;
    }
};

int main(void)
{
    heap myheap(4);

    string cmd;
    int d;

    while (true) {
        cin >> cmd >> d;

        cout << "MAIN: cmd = " << cmd << ", d = " << d << endl;

        if (cmd == "put") {
            myheap.put(d);
        } else if (cmd == "pop") {
            int i = myheap.pop();
            cout << "pop returns: " << i << endl;
        } else if (cmd == "dump")
            myheap.dump();
        else if (cmd == "quit")
            exit(0);
    }
}

