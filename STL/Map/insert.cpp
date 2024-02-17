#include <iostream>
#include <map>
#include <string>

using namespace std;

template <typename K, typename V>
void print_map(map<K, V>& m){
    for (auto iter = m.begin(); iter != m.end(); ++iter){
        cout << iter -> first << " " << iter -> second << endl;
    }
}

int main(){
    // 맵 선언
    map<string, double> list;

    // 맵의 insert 함수는 pair 객체를 인자로 받음
    list.insert(pair<string, double>("박세웅", 2.23));
    list.insert(pair<string, double>("해커", 2.93));
    list.insert(pair<string, double>("피어밴드", 2.95));

    // make_pair 함수로 객체를 만들 수 있음
    list.insert(make_pair("차우찬", 3.04));
    list.insert(make_pair("장원준", 3.05));
    list.insert(make_pair("헥터", 3.09));

    // 배열처럼 바로 선언도 가능
    list["니퍼트"] = 3.56;
    list["박종훈"] = 3.76;
    list["켈리"] = 3.90;
    
    print_map(list);

    cout << "박세웅 방어율은 ? : " << list["박세웅"] << endl;
}