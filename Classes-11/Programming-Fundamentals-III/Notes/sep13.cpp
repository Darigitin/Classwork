#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

class node
{
   public:
      typedef int data_t;

      node (data_t d) { data = d; next = NULL; }

      node *next;
      data_t data;
};
int main(void)
{
}

