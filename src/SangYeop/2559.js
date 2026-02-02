const fs = require('fs')
const filePath = process.platform === 'linux' ? 'dev/stdin' : 'input.txt'
let input = fs.readFileSync(filePath).toString().trim().split('\n');
const [totalLength, K] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

let max = 0;
for(let i = 0; i < K; i++){
    max += arr[i];
}

let newSum = max;

for(let i = K; i < totalLength; i++){
    newSum += arr[i];
    newSum -= arr[i - K];

    if(newSum > max){
        max = newSum;
    }
}
console.log(max)

// | N 크기          | 가능한 접근             |
// | ------------- | ------------------ |
// | N ≤ 2,000     | O(N²) 가능           |
// | N ≤ 100,000   | O(N log N) 또는 O(N) |
// | N ≤ 1,000,000 | 거의 O(N)만 가능        |
