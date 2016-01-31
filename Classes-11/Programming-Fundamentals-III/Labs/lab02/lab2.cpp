#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

class node
{
  public:
    typedef int data_t;

    node(data_t d) { next = NULL; data = d; }

    node *next;
    data_t data;
};


class linked_list
{
  private:
    node *head;

  public:

    linked_list()
    {
        head = NULL;
    }

    int size()
    {
       node *tptr = head;
       int c = 0;
       while (tptr)
       {
          tptr = tptr->next;
	  c++;
       }
       return c;
    }

    void add(int n, node::data_t d)
    {
       if (n>size())
       {
          cout << -1 << endl;
       }
       else if (n == 0)
       {
          node *tptr = new node(d);
          tptr->next = head;
          head = tptr;
       }
       else if (n < size())
       {
         node *tptr = head;
	 node *tptr2 = new node(d);
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
          node *tptr = head;
          while (tptr->next)
          {
             tptr = tptr->next;
          }
          tptr->next = new node(d);
       }
    }
    void add_last(node::data_t d)
    {
       add(size(), d);
    }

    void add_first(node::data_t d)
    {
       add(0, d);
    }

    node::data_t get(int n)
    {
       node *tptr = head;
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


    node::data_t get_first()
    {
       if (head != NULL)
       {
          return head->data;
       }
       return -1;
    }

    node::data_t get_last()
    {
       node *tptr = head;
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
             node *tptr = head;
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
          node *tptr = head;
          n--;

	  for (int c = 0; c<n && tptr->next != NULL; c++)
	  {
             tptr = tptr->next;
	  }
          node *tptr2 = tptr->next;
          tptr->next = tptr2->next;
          delete tptr2;
       }
       else 
       {
          node *tptr = head;
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
        node *tptr;

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
    linked_list ll;
    string cmd;
    int i, d;

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
