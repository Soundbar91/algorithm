#include <vector>
#include <set>
#include <iostream>
using namespace std;

int solution(vector<int> nums){
    int answer = 0;
    int numsSize = nums.size();
    set<int> set;
    vector<int>:: iterator iter;

    for (iter = nums.begin(); iter != nums.end(); iter++){
        set.insert(*(iter));
    }

    if (set.size() > numsSize / 2) answer = numsSize / 2;
    else answer = set.size();

    return answer;
}

int main() {
    vector<int> vec = { 3, 1, 2, 3 };
    int result = solution(vec);
    cout << result << endl;

    return 0;
}