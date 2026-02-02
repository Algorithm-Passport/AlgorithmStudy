const fs = require('fs')
const filePath = process.platform === 'linux' ? 'dev/stdin' : 'input.txt'
let [len, someString, min] = fs.readFileSync(filePath).toString().trim().split('\n')
let [stringLen, passwordLen] = len.split(' ');
let [A, C, G, T] = min.split(' ');

let result = 0;
let count = {
    'A':0,
    'C':0,
    'G':0,
    'T':0
}

for (let i = 0; i < Number(passwordLen); i++) {
    count[someString[i]]++
}

if(Number(A) <= count['A'] && Number(C) <= count['C'] && Number(G) <= count['G'] && Number(T) <= count['T']){
    result++;
}

for (let i = Number(passwordLen); i < Number(stringLen); i++) {
    console.log(i)
    // 나간 문자
    count[someString[i - Number(passwordLen)]]--;
    // 들어온 문자
    count[someString[i]]++;

    if(Number(A) <= count['A'] && Number(C) <= count['C'] && Number(G) <= count['G'] && Number(T) <= count['T']){
        result++;
    }
}

console.log(result);
// for(let i = 0; i <= Number(stringLen) - Number(passwordLen); i++){
//     const checkWord = someString.slice(i, i + Number(passwordLen));
//     let a = A;
//     let c = C;
//     let g = G;
//     let t = T;
//     for(const w of checkWord){
//         if(w === 'A'){
//             a--;
//         } else if(w === 'C'){
//             c--;
//         } else if(w === 'G'){
//             g--;
//         } else if(w === 'T'){
//             t--;
//         }
//     }
//     if(a > 0 || c > 0 || g > 0 || t > 0){
//         // continue;
//     } else {
//         result++;
//     }
// }



