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

    // 출력
    for (size_t i = 0; i < vec.size(); i++) {
        cout << "vec 의 " << i + 1 << " 번째 원소 :: " << vec[i] << endl;
    }

    return 0;
}
