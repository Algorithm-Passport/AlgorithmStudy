const input = require('fs').readFileSync('example.txt').toString().trim().split('\n');
const n = input.shift()
const stats = input.map(v => v.split(" ").map(Number))

let result;





if(result === 0) console.log(result);
console.log(result)

// 어려움: 1. 팀을 나누는 것부터 어렵다. 2. 나눈 팀을 어떻게 순회하면서 계산을 할 것인가