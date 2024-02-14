#include <iostream>
#include <vector>

using namespace std;

int main(){

    // 벡터 선언
    vector<int> vec;

    // 벡터에 값 추가
    vec.push_back(10);
    vec.push_back(20);
    vec.push_back(30);
    vec.push_back(40);


    // 출력 - 반복자 이용
    for (vector<int>::iterator iter = vec.begin(); iter != vec.end(); ++iter){
        cout << *iter << endl;
    }

    // 임의의 원소 출력 - 반복자 이용
    vector<int>::iterator iter = vec.begin() + 2;
    cout << "3 번째 원소 :: " << *iter << endl;

    return 0;
}
