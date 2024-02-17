#include <iostream>
#include <map>
#include <string>

using namespace std;

template <typename K, typename V>
void print_map(map<K, V>& m){
    for (const auto& kv : m){
        cout << kv.first << " " << kv.second << endl;
    }
}

int main(){
    map<string, double> list;

    list.insert(make_pair("박세웅", 2.23));
    list.insert(make_pair("박세웅", 2.93));
    
    print_map(list);
    cout << "박세웅 방어율은 ? " << list["박세웅"] << endl;
}