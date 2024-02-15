#include <iostream>
#include <deque>

using namespace std;

int main(){
    // 덱 선언
    deque<int> dq;

    // 맨 뒤에서 값 추가
    dq.push_back(10);
    dq.push_back(20);

    // 맨 앞에서 값 추가
    dq.push_front(30);
    dq.push_front(40);

    cout << "Before Deque" << endl;
    for (int i : dq) cout << i << " ";
    cout << endl;

    // 맨 앞에서 원소 제거
    dq.pop_front();
    cout << "Pop front" << endl;
    for (int i : dq) cout << i << " ";
    cout << endl;

    // 맨 뒤에서 원소 제거
    dq.pop_back();
    cout << "Pop back" << endl;
    for (int i : dq) cout << i << " ";
    cout << endl;

    return 0;
}