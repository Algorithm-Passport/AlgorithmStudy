const fs = require('fs')
const filePath = process.platform === 'linux' ? 'dev/stdin' : 'input.txt'
let arr = fs.readFileSync(filePath).toString().trim().split('\n')
let result = [];

for(let i = 0; i < arr.length - 1; i++){
    let yesOrNo = 'yes'
    let left = 0;
    let right = arr[i].length - 1;
    while(left < right){
        if(arr[i][left] !== arr[i][right]){
            yesOrNo = 'no';
            break;
        }
        left++;
        right--;
    }
    result.push(yesOrNo);
}
console.log(result.join('\n'));
// 배열의 양끝을 사용하는 경우 while, left, right 생각하기