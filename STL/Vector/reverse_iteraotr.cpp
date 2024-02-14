#include <iostream>
#include <vector>

using namespace std;

// 벡터 출력 함수
void print_vector(vector<int>& vec){
    for (vector<int>::iterator iter = vec.begin(); iter != vec.end(); ++iter){
        cout << *iter << endl;
    }
}

int main(){

    // 벡터 선언
    vector<int> vec;

    // 벡터에 값 추가
    vec.push_back(10);
    vec.push_back(20);
    vec.push_back(30);
    vec.push_back(40);

    cout << "Before Vector" << endl;
    print_vector(vec);

    cout << "After Vector" << endl;

    // 역반복자 선언 및 출력
    vector<int>::reverse_iterator r_iter = vec.rbegin();
    for (; r_iter != vec.rend(); r_iter++) {
        cout << *r_iter << endl;
    }

    return 0;
}
