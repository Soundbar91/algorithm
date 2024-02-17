#include <iostream>
#include <set>

using namespace std;

template<typename T>
void print_set(set<T>& s){
    cout << "[ ";

    for (typename set<T>::iterator iter = s.begin(); iter != s.end(); ++iter){
        cout << *iter << " ";
    }
    
    cout << "]" << endl;
}


int main(){
    // 셋 선언
    set<int> s;

    // 셋 값 추가
    s.insert(10);
    s.insert(50);
    s.insert(20);
    s.insert(40);
    s.insert(30);

    // 셋 출력 - 정렬되서 나옴
    cout << "Print Set" << endl;
    print_set(s);

    // 원소 확인
    cout << "20 in Set" << endl;
    auto iter = s.find(20);
    if (iter != s.end()) cout << "Yes" << endl;
    else cout << "No" << endl;

    cout << "25 in Set" << endl;
    iter = s.find(25);
    if (iter != s.end()) cout << "Yes" << endl;
    else cout << "No" << endl;
}