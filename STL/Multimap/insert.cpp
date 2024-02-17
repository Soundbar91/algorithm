#include <iostream>
#include <map>
#include <string>

using namespace std;

template <typename K, typename V>
void print_map(const multimap<K, V>& m){
    for (const auto& kv : m){
        cout << kv.first << " " << kv.second << endl;
    }
}

int main(){
    multimap<int, string> m;

    m.insert(make_pair(1, "hello"));
    m.insert(make_pair(1, "hi"));
    m.insert(make_pair(1, "ahihi"));
    m.insert(make_pair(2, "bye"));
    m.insert(make_pair(2, "baba"));

    print_map(m);

    cout << "------------------" << endl;
    cout << m.find(1)->second << endl;
}