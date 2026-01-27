const fs = require('fs')
const filePath = process.platform === 'linux' ? 'dev/stdin' : 'input.txt'
let input = fs.readFileSync(filePath).toString().trim().split('').map(w=>w.toUpperCase());
const wordMap = new Map();
let result;
let count = 0;

for(const word of input){
    if(wordMap.has(word)){
        wordMap.set(word, wordMap.get(word) + 1);
    } else {
        wordMap.set(word, 1);
    }
}

for([key, value] of wordMap){
    if(value > count){
        count = value;
        result = key;
    } else if (value < count){
        continue;
    } else {
        result = "?";
    }
}

console.log(result)


