#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

template<class T> // "T" is a _template parameter_
class node 
{
  public:

    node()
    {
        cout << "node: (default)\n";
        data = 0;
    }

    node(T d)
    {
        cout << "node: d = " << d << endl;
        data = d;
    }

    void dump()
    {
        cout << "dump: data = " << data << endl;
    }

    void addTo(T d)
    {
        data += d;
    }

  private:
    T data;
};


int main(void)
{
    node<int>n1;  // "int" is a _template argument_
    n1.dump();

    node<int>n2(5);
    n2.dump();

    node<float>n3(3.1415);
    n3.dump();

    n2.addTo(3);
    n2.dump();

    n2.addTo(3.5);  // wrong type!  "compiler truncates in this case"
    n2.dump();
}
