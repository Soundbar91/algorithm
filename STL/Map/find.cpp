#include <iostream>
#include <map>
#include <string>

using namespace std;

template <typename K, typename V>
void search_and_print(map<K, V>& m, K key){
    auto iter = m.find(key);
    if (iter != m.end()) cout << key << " --> " << iter -> second << endl;
    else cout << key << "은(는) 목록에 없습니다." << endl;
}

int main(){
    map<string, double> list;

    list["오승환"] = 3.58;
    cout << "------------" << endl;

    search_and_print(list, string("오승환"));
    search_and_print(list, string("류현진"));
}