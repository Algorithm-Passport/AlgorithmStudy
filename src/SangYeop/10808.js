const fs = require('fs')
const filePath = process.platform === 'linux' ? 'dev/stdin' : 'input.txt'
const word = fs.readFileSync(filePath).toString().trim().split('').map(s => s.charCodeAt(0) - 97);
const result = Array(26).fill(0);

for(let w of word){
    result[w]++;
}

console.log(result.join(" "));