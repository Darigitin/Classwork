#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

class node {
  public:
    int key;
    string value;

    node *left;
    node *right;

    node(int k, string v)
    {
        key = k;
        value = v;

        left = NULL;
        right = NULL;
    }
};


class bst {
  private:

    node *root;

  public:
    bst()
    {
        root = NULL;
    }
    void put(int k, string v)
    {
       if (root == NULL)
       {
          root = new node(k, v);
       }
       else if (root)
       {
          node* tptr = root;
          int f = 0;
          if (tptr->left || tptr->right)
          {
             f = 1;
          }
          while (f)
	  {
	     if (tptr->left && k < tptr->key)
	     {
	        tptr = tptr->left;
	     }
	     else if (tptr->right && k > tptr->key)
	     {
	        tptr = tptr->right;
	     }
             else 
             {
                f = 0;
             }
	  }
	  if (tptr->key == k)
	  {
	     tptr->key = k;
	     tptr->value = v;
	  }
	  else if (k < tptr->key)
	  {
	     tptr->left = new node(k, v);
	  }
	  else if (k > tptr->key)
	  {
	     tptr->right = new node(k, v);
	  }
       }
    }
    void rdump(node* tptr, int f, int level)
    {
       if (f == 0)
       {
	  if (tptr->left)
	  {
	     rdump(tptr->left, f, level + 1);
	  }
          cout << "DUMP: index = " << tptr->key << ", data = " << tptr->value << ", level = " << level;
          if (tptr->left && tptr->right)
	  {
	     cout << ", lcld = " << tptr->left->key << ", rcld = " << tptr->right->key << endl;
	  }
	  else if (tptr->left)
	  {
	     cout << ", lcld = " << tptr->left->key << endl;
	  }
	  else if (tptr->right)
	  {
	     cout << ", rcld = " << tptr->right->key << endl;
	  }
	  else
	  {
	     cout << endl;
	  }
          if (tptr->right)
          {
             rdump(tptr->right, f, level + 1);
          }
       }
       else if (f == 1)
       {
          if (tptr->right)
	  {
	     rdump(tptr->right, f, level + 1);
	  }
	  cout << "DUMP: index = " << tptr->key << ", data = " << tptr->value << ", level = " << level;
	  if (tptr->left && tptr->right)
	  {
	     cout << ", lcld = " << tptr->left->key << ", rcld = " << tptr->right->key << endl;
	  }
	  else if (tptr->left)
	  {
	     cout << ", lcld = " << tptr->left->key << endl;
	  }
	  else if (tptr->right)
	  {
	     cout << ", rcld = " << tptr->right->key << endl;
	  }
	  else
	  {
	     cout << endl;
	  }
	  if (tptr->left)
	  {
	     rdump(tptr->left, f, level + 1);
	  }
       }
   }
   void dump()
   {
      if (root)
      {
         cout << "DUMP: (root node = " << root->key << ")" << endl;
         rdump(root, 0, 1);
      }
      else
      {
         cout << "DUMP: (root node = " << -1 << ")" << endl;
      }
   }
   void dump_rev()
   {
      if (root)
      {
         cout << "DUMP: (root node = " << root->key << ")" << endl;
         rdump(root, 1, 1);
      }
      else
      {
         cout << "DUMP: (root node = " << -1 << ")" << endl;
      }
   }
   string non_recursive_get(int k)
   {
      if (root)
      {
         node *tptr = root;
         int f = 0;
         if (tptr->left || tptr->right)
         {
            f = 1;
         }
         cout << "GET: examining node(s): ";
         while (f)
         {
            cout << tptr->value << " ";
            if (tptr->left && k < tptr->key)
	    {
	       tptr = tptr->left;
	    }
	    else if (tptr->right && k > tptr->key)
	    { 
	       tptr = tptr->right;
	    }
	    else
	    {
	       cout << endl;
	       f = 0;
	    }
         }
         if (tptr->key == k)
         {
            return tptr->value;
         }
         else
         {
            return "-1";
         }
      }
      else
      {
         return "-1";
      }
      
   }
   string rget(node *tptr, int k, string c, string r)
   {
      if (tptr->left && k < tptr->key)
      {
         r = rget(tptr->left, k, c + " " + tptr->value + " ", r);
      }
      else if (tptr->right && k > tptr->key)
      {
         r = rget(tptr->right, k, c + " " + tptr->value + " ", r);
      }
      if (tptr->key == k)
      {
         cout << "GET: examining node(s): " << c + " " + tptr->value << endl;
	 r = tptr->value;
      }
      return r;

   }
   string recursive_get(int k)
   {
      if (root)
      {
         return rget(root, k, "", "-1");
      }
      else
      {
         return "-1";
      }
   }
   void remove (int k)
   {
      if (root)
      {
         node* tptr = root;
	 int f = 0;
	 if (tptr->left || tptr->right)
	 {
	    f = 1;
	 }
         while(f)
	 {
	    if (k < tptr->key && tptr->left && k != tptr->left->key)
	    {
	       tptr = tptr->left;
	    }
	    else if (k > tptr->key && tptr->right && k != tptr->right->key)
	    {
	       tptr = tptr->right;
	    }
	    else
	    {
	       f = 0;
	    }
	 }
         if (k < tptr->key && tptr->left)
         {
	    if (tptr->left->left && tptr->left->right)
	    {
	       node* tptr2 = tptr->left->left;
	       if (tptr2->right)
	       {
	          while (tptr->right->right)
		  {
		     tptr2 = tptr2->right;
		  }
	       }
	       if (tptr2->right)
	       {
	          tptr->left->key = tptr2->right->key;
		  tptr->left->value = tptr2->right->value;
		  delete tptr2->right;
		  tptr2->right = NULL;
	       }
	       else
	       {
	          tptr->left->key = tptr2->key;
		  tptr->left->value = tptr2->value;
                  tptr->left->left = tptr2->left;
		  delete tptr2;
	       }
	    }
	    else if (tptr->left->left)
	    {
	       node* tptr2 = tptr->left->left;
	       if (tptr2->left && tptr2->right)
	       {
	          node* tptr3 = tptr2->left;
	          if (tptr3->right)
	          {
	             while (tptr3->right->right)
	             {
		        tptr3 = tptr3->right;
		     }
	          }
                  if (tptr3->right)
	          {
	             tptr2->key = tptr3->right->key;
		     tptr2->value = tptr3->right->value;
	             delete tptr3->right;
	             tptr3->right = NULL;
                  }
	          else
	          {
	             tptr2->key = tptr3->key;
		     tptr2->value = tptr3->value;
		     if (tptr3->left)
		     {
		        tptr2->left = tptr3->left;
		     }
		     else
		     {
		        tptr2->left = NULL;
		     }
		     delete tptr3;
	          }
	       }
	       else if (tptr2->left)
	       {
	          tptr->left = tptr2->left;
		  delete tptr2;
	       }
	       else if (tptr2->right)
	       {
	          tptr->left = tptr2->right;
		  delete tptr2;
	       }
               else
	       {
	          tptr->left = tptr2;
	       }
	    }
	    else if (tptr->left->right)
	    {
	       node* tptr2 = tptr->left;
	       tptr->left = tptr2->right;
	       delete tptr2;
	    }
	    else
	    {
	       delete tptr->left;
	       tptr->left = NULL;
	    }
	 }
	 else if (k > tptr->key && tptr->right)
	 {
	    if (tptr->right->left && tptr->right->right)
	    {
	       node* tptr2 = tptr->right->left;
	       if (tptr2->right)
	       {
	          while (tptr2->right->right)
	          {
		     tptr2 = tptr2->right;
		  }
	       }
               if (tptr2->right)
	       {
	          tptr->right->key = tptr2->right->key;
		  tptr->right->value = tptr2->right->value;
	          delete tptr2->right;
	          tptr2->right = NULL;
               }
	       else
	       {
	          tptr->right->key = tptr2->key;
		  tptr->right->value = tptr2->value;
		  delete tptr2;
		  tptr->right->left = NULL;
	       }
	    }
            else if (tptr->right->left)
	    {
	       node* tptr2 = tptr->right->left;
	       if (tptr2->right)
	       {
	          while (tptr2->right->right)
		  {
		     tptr2 = tptr2->right;
		  }
	       }
	       if (tptr2->right)
	       {
	          tptr->right->key = tptr2->right->key;
		  tptr->right->key = tptr2->right->key;
		  delete tptr2->right;
		  tptr2->right = NULL;
	       }
	       else
	       {
	          tptr->right->key = tptr2->key;
		  tptr->right->value = tptr2->value;
		  delete tptr2;
		  tptr->right->left = NULL;
	       }
	    }
	    else if (tptr->right->right)
	    {
	       node *tptr2 = tptr->right;
	       tptr->right = tptr2->right;
	       delete tptr2;
	    }
	    else
	    {
	       delete tptr->right;
	       tptr->right = NULL;
	    }

	 }
	 else if (k == tptr->key)
	 {
	    if (tptr->left && tptr->right)
	    {
	       node* tptr2 = tptr->left;
	       if (tptr2->right)
	       {
	          while (tptr->right->right)
	          {
		     tptr2 = tptr2->right;
		  }
	       }
               if (tptr2->right)
	       {
	          tptr->key = tptr2->right->key;
		  tptr->value = tptr2->right->value;
	          delete tptr2->right;
	          tptr2->right = NULL;
               }
	       else
	       {
	          tptr->key = tptr2->key;
		  tptr->value = tptr2->value;
		  if (tptr2->left)
		  {
		     tptr->left = tptr2->left;
		  }
		  else
		  {
		     tptr->left = NULL;
		  }
		  delete tptr2;
		  
	       }
	    }
	    else if (tptr->left)
	    {
	       root = tptr->left;
	       delete tptr;
	    }
	    else if (tptr->right)
	    {
	       root = tptr->right;
	       delete tptr;
	    }
	    else
	    {
	       root = NULL;
	       delete tptr;
	    }
         }
         else
	 {
	    cout << "-1" << endl;
	 }
      }
      else
      {
         cout << "-1" << endl;
      }
   }
};


int main(void)
{
    bst mybst;

    string cmd;
    int k;
    string v;

    while (true) {
        cin >> cmd >> k >> v;

        cout << "MAIN: cmd= " << cmd << ", key= " << k << ", v= " << v << endl;

        if (cmd == "put") {
            mybst.put(k, v);
        } else if (cmd == "dump") {     // traverse tree in ascending order
            mybst.dump();
        } else if (cmd == "dump_rev") { // traverse tree in descending order
            mybst.dump_rev();
        } else if (cmd == "get") {
            cout << "MAIN: get returns: " << mybst.non_recursive_get(k) << endl;
        } else if (cmd == "rget") {
            cout << "MAIN: rget returns: " << mybst.recursive_get(k) << endl;
        } else if (cmd == "rem") {
            mybst.remove(k);
        } else if (cmd == "quit") {
            exit(0);
        }
    }
}

