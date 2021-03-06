#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

template<class T>
class node
{
  public:
    node(int i, T d) {
        nextrow = NULL;
        prevrow = NULL;
        nextcol = NULL;
        prevcol = NULL;

        index = i;
        data  = d;
    }

    int    index;
    T      data;

    node<T> *nextrow;
    node<T> *prevrow;
    node<T> *nextcol;
    node<T> *prevcol;
};


template<class T>
class sparseArray
{
  private:
    node<T> *root;

  public:

    sparseArray()
    {
        root=new node<T>(-1, -1);
    }


    void put(int r, int c, T d)
    {
       if (root->nextrow == NULL)
       {
         node<T> *tptr = new node<T>(r, -1);
	 root->nextrow = tptr;
	 tptr->prevrow = root;
	 node<T> *tptr2 = new node<T>(c, d);
	 tptr->nextcol = tptr2;
	 tptr2->prevcol = tptr;
       }
       else
       {
          node<T> *tptr = root;
          while (tptr->nextrow && r > tptr->index)
          {
	     tptr = tptr->nextrow;
          }
          if (r > tptr->index)
          {
             node<T> *tptr2 = new node<T>(r, -1);
             tptr2->prevrow = tptr;
             tptr->nextrow = tptr2;
	     node<T> *tptr3 = new node<T>(c, d);
	     tptr2->nextcol = tptr3;
	     tptr3->prevcol = tptr2;
          }
	  else if (tptr->index > r)
	  {
	     node<T> *tptr2 = new node<T>(r, -1);
	     tptr2->nextrow = tptr;
	     tptr2->prevrow = tptr->prevrow;
	     tptr->prevrow->nextrow = tptr2;
             tptr->prevrow = tptr2;
	     node<T> *tptr3 = new node<T>(c, d);
	     tptr3->prevcol = tptr2;
	     tptr2->nextcol = tptr3;
          }
	  if (tptr->index == r)
	  {
             tptr = tptr->nextcol;
	     while (tptr->nextcol && c > tptr->index)
	     {
	        tptr = tptr->nextcol;
	     }
	     if (tptr->index < c)
	     {
	        node<T> *tptr2 = new node<T>(c, d);
		tptr2->prevcol = tptr;
		tptr->nextcol = tptr2;
	     }
	     else if (tptr->index > c)
	     {
	        node<T> *tptr2 = new node<T>(c, d);
		tptr2->prevcol = tptr->prevcol;
		tptr2->nextcol = tptr;
		tptr->prevcol->nextcol = tptr2;
		tptr->prevcol = tptr2;
	     }
	     else if (tptr->index == c)
	     {
	        tptr->data = d;
	     }
	  }

       }
    }

    T get(int r, int c)
    {
       if (root->nextrow == NULL)
       {
          return -1;
       }
       else
       {
          node<T> *tptr = root;
	  while (tptr->nextrow && r > tptr->index)
	  {
	     tptr = tptr->nextrow;
	  }
	  if (tptr->index == r)
	  {
	     tptr = tptr->nextcol;
	     while (tptr->nextcol && c > tptr->index)
	     {
	        tptr = tptr->nextcol;
	     }
	     if (tptr->index == c)
	     {
	        return tptr->data;
	     }
	     else
	     {
	        return -1;
	     }
	  }
	  else
	  {
	     return -1;
	  }
       }
    }
    



    void remove(int r, int c)
    {
       if (root->nextrow == NULL)
       {
          cout << "-1" << endl;
       }
       else
       {
          node<T> *tptr = root;
          while (tptr->nextrow && r > tptr->index)
	  {
	     tptr = tptr->nextrow;
	  }
	  if (tptr->index == r)
	  {
             tptr = tptr->nextcol;
	     while (tptr->nextcol && c > tptr->index)
	     {
	        tptr = tptr->nextcol;
	     }
	     if (tptr->index == c)
	     {
	        if (tptr->nextcol == NULL)
		{
		   tptr->prevcol->nextcol = NULL;
		   delete tptr;
		   tptr = tptr->prevcol;
		}
                else 
		{
		   if (tptr->nextcol)
                   {
	              tptr->prevcol->nextcol = tptr->nextcol;
		   }
                   if (tptr->prevcol)
		   {
		      tptr->nextcol->prevcol = tptr->prevcol;
		   }
		   node<T> *tptr2 = tptr->prevcol;
		   delete tptr;
                   tptr = tptr2;
	        }
		if (tptr->data == -1 && tptr->nextcol == NULL)
		{
		   tptr->prevrow->nextrow = tptr->nextrow;
		   if (tptr->nextrow)
		   {
		      tptr->nextrow->prevrow = tptr->prevrow;
		   }
		   node<T> *tptr2 = tptr->prevrow;
		   delete tptr;
		}
	     }
	     else
	     {
	        cout << "-1" << endl;
	     }
	  }
	  else if (tptr->index != c)
	  {
	     cout << "-1" << endl;
	  }
	  else if (tptr->index != r)
	  {
	     cout << "-1" << endl;
	  }
       }
    }

    void dump()
    {
        node<T> *rowptr, *colptr;

        rowptr  = root;

        while (rowptr->nextrow != NULL) {
            rowptr  = rowptr->nextrow;
            cout << "    DUMP:   row = " << rowptr->index << endl;
            colptr = rowptr;
            while (colptr->nextcol != NULL) {
                colptr = colptr->nextcol;
                cout << "    DUMP:   col =    " << colptr->index 
                     << " data = " << colptr->data << endl;
            }
        } 
        cout << endl;
    }

    void rdump()
    {
       node<T> *rowptr, *colptr;

       rowptr = root;
       while (rowptr->nextrow !=NULL) 
       {
          rowptr = rowptr->nextrow;
       }
       while (rowptr->prevrow != NULL)
       {
          colptr = rowptr;
          cout << "    DUMP:   row = " << rowptr->index << endl;
          while (colptr->nextcol != NULL)
	  {
	     colptr = colptr->nextcol;
	  }
	  while (colptr->prevcol != NULL)
	  {
	     cout << "    DUMP:   col =   " << colptr->index
	          << " data = " << colptr->data << endl;
	     colptr = colptr->prevcol;
	  }
	  rowptr = rowptr->prevrow;
       }
       cout << endl;
    }
};


int main(void)
{
    sparseArray<int> sa;
    string cmd;
    int d, r, c;

    while (true) {
        cin >> cmd >> r >> c >> d;

        cout << "MAIN: cmd = " << cmd << ", r = " << r << ", c = " 
             << c << ", d = " << d << endl;

        if (cmd == "put") {
            sa.put(r, c, d);
        } else if (cmd == "get") {
            int i = sa.get(r, c);
            cout << "get returns: " << i << endl;
        } else if (cmd == "rem") {
            sa.remove(r, c);
        } else if (cmd == "dump") {
            sa.dump();
        } else if (cmd == "rdump") {
            sa.rdump();
        } else if (cmd == "quit") {
            exit(0);
        } else {
            cout << "-1" << endl;
        }
    }
}
