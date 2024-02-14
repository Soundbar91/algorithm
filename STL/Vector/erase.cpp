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

    // 3번째 원소 삭제
    vec.erase(vec.begin() + 3);

    cout << "After Vector" << endl;
    print_vector(vec);
}
