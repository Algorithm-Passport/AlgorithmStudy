const fs = require('fs')
const filePath = process.platform === 'linux' ? 'dev/stdin' : 'input.txt'
let [N, ...words] = fs.readFileSync(filePath).toString().trim().split('\n')
N = Number(N)
let result = 0;
const wordSet = new Set();

for(let i = 0; i < N; i++){
    const word = words[i];
    let prevWord = null;
    let flag = true;

    for(const w of word){
        if(prevWord !== w && wordSet.has(w)){
            flag = false;
            break;
        } else {
            wordSet.add(w)
            prevWord = w;
        }
    }
    if(flag){
        result++;
    }
    wordSet.clear();
}

console.log(result)



