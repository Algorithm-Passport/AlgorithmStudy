const fs = require('fs')
const filePath = process.platform === 'linux' ? 'dev/stdin' : 'input.txt'
let [doc, word] = fs.readFileSync(filePath).toString().trim().split('\n')

// doc를 word로 잘라서 비교하면 될듯? 뭔가 슬라이딩 윈도우 느낌
// 내가 지금 어렵다고 느끼는 포인트는 doc를 어떻게 순회를 하면서 word와 비교를 해야하나

let result = 0;
const wordLen = word.length;
let jump = 1;

for(let i = 0; i < doc.length; i+= jump){
    if(word === doc.slice(i, wordLen + i)){
        result++;
        jump = wordLen;
    } else {
        jump = 1;
    }
}

console.log(result);

// 비교는 하고 있는데 계속 자릴고 변하는 것때문에 제대로 정착을 못함
// 자르지 않고 하나씩 가면 너무 많이가버려서 할 수가없다.
// 아 그러면 길이만큼 넘어가면 되지!

// 새로운 국면. 되야하는 것 같은데 틀렸다고 나온다. 예시는 다맞았다.
// 알았다 => 일치하지 않는 경우에도 제시어 길이 만큼 넘겨서 문제 => 일치하지 않으면 하나 일치하면 단어길이만큼 넘긴다

// gpt - “조건에 따라 이동량이 달라지는 인덱스 스캔”
// let count = 0;
// let i = 0;
// const len = word.length;
//
// while (i <= doc.length - len) {
//     if (doc.slice(i, i + len) === word) {
//         count++;
//         i += len;   // 🔑 핵심: 겹치지 않게 점프
//     } else {
//         i++;        // 한 칸 이동
//     }
// }
//
// console.log(count);