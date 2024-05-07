const input = require('fs').readFileSync('example.txt').toString().trim().split('\n');
// readFileSync('/dev/stdin')
const firstLine = input[0];
const secondLine = input[1];
const result = [];
let sum = 0;
for(let i = secondLine.length - 1; i >= 0; i--) {
    result.push(firstLine * secondLine[i])
}

for(let i = 0; i < result.length; i++){
    console.log(result[i])
    sum += result[i] * (10**i)
    if(i === result.length - 1){
        console.log(sum);
    }
}