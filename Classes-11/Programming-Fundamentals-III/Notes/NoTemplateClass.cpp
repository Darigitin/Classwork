#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

class node 
{
  public:

    node()
    {
        cout << "node: (default)\n";
        data = 0;
    }

    node(int d)
    {
        cout << "node: d = " << d << endl;
        data = d;
    }

    void dump()
    {
        cout << "dump: data = " << data << endl;
    }

    void addTo(int d)
    {
        data += d;
    }

  private:
    int data;
};


int main(void)
{
    node n2(5);
    n2.dump();

    n2.addTo(3);
    n2.dump();
}
