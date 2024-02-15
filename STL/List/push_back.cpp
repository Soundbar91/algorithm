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

    // 리스트 출력
    for (list<int>::iterator iter = lst.begin(); iter != lst.end(); ++iter){
        cout << *iter << endl;
    }

    return 0;
}