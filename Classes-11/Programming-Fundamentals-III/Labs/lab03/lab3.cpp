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
template<class T>
class stack
{
   linked_list<T> ll;
   
   public:
 
   void push(T d)
   {
      ll.add(0, d);
   }

   T pop()
   {
     T d = top();
     ll.remove(0);
     return d; 
   }

   T top()
   {
      ll.get_first();
   }
};
int main(void)
{
    stack<double> s;
    int n;
    string cmd;
    double d;

    while (true) {
        cin >> cmd >> d;

        cout << "MAIN: cmd = " << cmd << ", d = " << d << endl;

        if (cmd == "push")
            s.push(d);
        else if (cmd == "pop") {
            d = s.pop();
            cout << "MAIN: pop = " << d << endl;
        } else if (cmd == "top") {     // returns the value from top of stack,
            d = s.top();        // but DOES NOT REMOVE the item.
            cout << "MAIN: top = " << d << endl;
        } else if (cmd == "quit")
            exit(0);
    }
}

