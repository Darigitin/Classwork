#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;
template<class T>
class node
{
  public:

    node(T d) { next = NULL; data = d; }

    node *next;
    T data;
};

template<class T>
class linked_list
{
  private:
  node<T> *head;

  public:

    linked_list()
    {
        head = NULL;
    }

    int size()
    {
       node<T> *tptr = head;
       int c = 0;
       while (tptr)
       {
          tptr = tptr->next;
	  c++;
       }
       return c;
    }

    void add(int n, T d)
    {
       if (n>size())
       {
          cout << -1 << endl;
       }
       else if (n == 0)
       {
          node<T> *tptr = new node<T>(d);
          tptr->next = head;
          head = tptr;
       }
       else if (n < size())
       {
         node<T> *tptr = head;
	 node<T> *tptr2 = new node<T>(d);
         n--;
	 for (int c = 0; c<n && tptr->next != NULL; c++)
	 {
	    tptr = tptr->next;
	 }
	 tptr2->next = tptr->next;
	 tptr->next = tptr2;
	 
       }
       else 
       {
          node<T> *tptr = head;
          while (tptr->next)
          {
             tptr = tptr->next;
          }
          tptr->next = new node<T>(d);
       }
    }
    void add_last(T d)
    {
       add(size(), d);
    }

    void add_first(T d)
    {
       add(0, d);
    }

    T get(int n)
    {
       node<T> *tptr = head;
       if (n >= size() || head == NULL)
       {
          return -1;
       }
       else 
       {  
          for (int c = 0; c<n && tptr->next != NULL; c++)
          {
             tptr = tptr->next;
          }
          return tptr->data;
       }
    }


    T get_first()
    {
       if (head != NULL)
       {
          return head->data;
       }
       return -1;
    }

    T get_last()
    {
       node<T> *tptr = head;
       if (head != NULL)
       {
          while (tptr->next)
          {
             tptr = tptr->next;
          }
          return tptr->data;
       }
       return -1;
    }

    void remove(int n)
    {
       if (n >= size() || head == NULL)
       {
          cout << -1 << endl;
       }
       else if(n == 0 || size() == 1)
       {
          if (head->next)
	  {
             node<T> *tptr = head;
             head = head->next;   
	  }
          else 
          {
             delete head;
             head = NULL;
          }
       }
       else if (n < size())
       {
          node<T> *tptr = head;
	  n--;

	  for (int c = 0; c<n && tptr->next != NULL; c++)
	  {
             tptr = tptr->next;
	  }
          node<T> *tptr2 = tptr->next;
          tptr->next = tptr2->next;
          delete tptr2;
       }
       else 
       {
          node<T> *tptr = head;
          n--;
          for (int c = 0; c<n && tptr->next != NULL; c++)
          {
	     tptr = tptr->next;
          }
	  delete tptr->next;
          tptr->next = NULL;
       } 
  
    }

    void remove_first()
    {
       remove(0);
    }

    void remove_last()
    {
       remove(size()-1);
    }

    void dump()
       {
        node<T> *tptr;

        cout << "    DUMP: (size = " << size() << ", first = " << get_first() << ", last = " << get_last() << ")\n";

        if (head == NULL) {
            cout << "    DUMP: head = NULL\n\n";
            return;
        }

        tptr = head;

        cout << "    DUMP:   head = : " << tptr->data << endl;
        while (tptr->next != NULL) {
            tptr = tptr->next;
        cout << "    DUMP:   data = : " << tptr->data << endl;
        }
        cout << endl;
      }
};
int main(void)
{
    linked_list<double> ll;
    string cmd;
    double d;
    int i;

    while (true) {
        cin >> cmd >> i >> d;

        cout << "MAIN: cmd = " << cmd << ", i = " << i
             << ", d = " << d << endl;

        if (cmd == "add")
            ll.add(i, d);
        else if (cmd == "addf")
            ll.add_first(d);
        else if (cmd == "addl")
            ll.add_last(d);
        else if (cmd == "rem")
            ll.remove(i);
        else if (cmd == "remf")
            ll.remove_first();
        else if (cmd == "reml")
            ll.remove_last();
        else if (cmd == "get") {
            d = ll.get(i);
            cout << "get returns: " << d << endl;
        } else if (cmd == "getf") {
            d = ll.get_first();
            cout << "getf returns: " << d << endl;
        } else if (cmd == "getl") {
            d = ll.get_last();
            cout << "getl returns: " << d << endl;
        } else if (cmd == "dump")
            ll.dump();
        else if (cmd == "quit")
            exit(0);
    }
}

