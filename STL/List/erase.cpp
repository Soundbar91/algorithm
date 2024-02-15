#include <iostream>
#include <list>

using namespace std;

int main(){
    // 리스트 선언
    list<int> lst;

    // 리스트 값 추가
    lst.push_back(10);
    lst.push_back(20);
    lst.push_back(30);
    lst.push_back(40);

    cout << "Before List" << endl;
    for (int i : lst) cout << i << " " ;
    cout << endl;

    // 리스트 값 삭제
    for (list<int>::iterator iter = lst.begin(); iter != lst.end(); iter++){
        if (*iter == 30) {
            lst.erase(iter);
            break;
        }
    }

    cout << "After List" << endl;
    for (int i : lst) cout << i << " " ;
    cout << endl;

    return 0;
}