#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;
template<class T>
class node
{
  public:

    node(T d) { next = NULL; data = d; prev = NULL; }

    node *next, *prev;
    T data;
};

template<class T>
class linked_list
{
  private:
  node<T> *head, *tail, *user;

  public:

    linked_list()
    {
        head = NULL;
        tail = NULL;
        user = NULL;
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
       else if (n == 0 && head == NULL)
       {
          node<T> *tptr = new node<T>(d);
          head = tptr;
          tail = head;
          user = head;
       }
       else if (n == 0)
       {
          node<T> *tptr = new node<T>(d);
          tptr->next = head;
          head->prev = tptr;
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
         tptr2->next->prev = tptr2;
	 tptr2->prev = tptr;
       }
       else 
       {
          node<T> *tptr = head;
          while (tptr->next)
          {
             tptr = tptr->next;
          }
          tptr->next = new node<T>(d);
	  tptr->next->prev = tptr;
	  tail = tptr->next;
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
       if (n > size() || head == NULL)
       {
          cout << -1 << endl;
       }
       else if(n == 0 || size() == 1)
       {
          if (head->next)
	  {
             node<T> *tptr = head;
             head = head->next;
	     if (user == tptr)
	     {
	        adv_ptr();
	     }
	     delete head->prev;

	  }
          else 
          {
             delete head;
             head = NULL;
	     tail = NULL;
	     user = NULL;
          }
       }
       else if (n < size())
       {
          node<T> *tptr = head;
	  n = n - 2;

	  for (int c = 0; c<n && tptr->next != NULL; c++)
	  {
             tptr = tptr->next;
	  }
          node<T> *tptr2 = tptr->next;
          tptr->next = tptr2->next;
          node<T> *tptr3 = tptr2->next;
	  tptr3->prev = tptr2->prev;
	  if (tail == tptr2)
	  {
	     tail = tptr;
	  }
	  if (user == tptr2)
	  {
	     adv_ptr();
	  }
          delete tptr2;
       }
       else 
       {
          node<T> *tptr = head;
          n = n - 2;;
          for (int c = 0; c<n && tptr->next != NULL; c++)
          {
	     tptr = tptr->next;
          }
	  if (user == tptr->next)
	  {
	     rew_ptr();
	  }
	  delete tptr->next;
          tptr->next = NULL;
	  tail = tptr;
       } 
  
    }

    void remove_first()
    {
       remove(0);
    }

    void remove_last()
    {
       remove(size());
    }

    void dump()
       {
        node<T> *tptr, *tptr2;

        cout << "    DUMP: (size = " << size() << ", first = " << get_first() << ", last = " << get_last() << ")\n";

        if (head == NULL) {
            cout << "    DUMP: head = NULL    tail = NULL\n\n";
            return;
        }

        tptr = head;
        tptr2 = tail;

        cout << "    DUMP:   head = : " << tptr->data << "    tail = : " << tptr2->data << endl;
        while (tptr->next != NULL) {
            tptr = tptr->next;
            tptr2 = tptr2->prev;
        cout << "    DUMP:   data = : " << tptr->data << "    data = : " << tptr2->data << endl;
        }
        cout << endl;
      }
      void reset_ptr()
      {
         user = head;
      }

      void adv_ptr()
      {
         if (head == NULL || user->next == NULL)
         {
            error();
         }
	 else
	 {
            user = user->next;
	 }
      }

      void rew_ptr()
      {
         if (head == NULL || user->prev == NULL)
	 {
	    error();
	 }
	 else
	 {
            user = user->prev;
	 }
      }

      T getup()
      {
         if (head)
         {
            return user->data;
         }
         return -1;
      }
      void error()
      {
         cout << "-1" << endl;
      }
};
