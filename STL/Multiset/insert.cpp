#include <iostream>
#include <set>
#include <string>

using namespace std;

template <typename K>
void print_set(const multiset<K>& s){
    for (const auto& elem : s){
        cout << elem << endl;
    }
}

int main(){
    multiset<string> s;

    s.insert("a");
    s.insert("b");
    s.insert("a");
    s.insert("c");
    s.insert("d");
    s.insert("c");

    print_set(s);
}