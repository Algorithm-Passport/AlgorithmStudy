const input = require('fs').readFileSync('example.txt').toString().trim().split('\n')
const N = parseInt(input[0]);
const ps = input.slice(1)

for(let i = 0; i < N; i++){
    const stack = [];
    const ps1 = ps[i].split('');
    for(let j = 0; j < ps1.length; j++){
        if(stack.length === 0){
            if(ps1[j] === ')'){
                stack.push(1);
                break;
            } else {
                stack.push(ps1[j]);
            }
        } else if(stack[stack.length-1] === ps1[j]){
            stack.push(ps1[j]);
        } else {
            stack.pop(ps1[j-1]);
        }
    }
    if(stack.length === 0){
        console.log('YES');
    }else{
        console.log('NO');
    }
}

//--------------------
// input의 문제일 수도
// var fs = require('fs');
// var input = fs.readFileSync('/dev/stdin').toString().split('\n');
// function test(str) {
//     var stack = [];
//     var flag = 0;
//     for (var j = 0; j < str.length; j++) {
//         if (str[j] === '\(') {
//             stack.push(str[j]);
//         }
//         else if (str[j] === '\)') {
//             if (stack.length === 0) {
//                 return false;
//             }
//             else stack.pop();
//         }
//     }
//     if (stack.length == 0) return true;
//     return false;
// };
// for (var i = 1; i <= parseInt(input[0]); i++) {
//     if (test(input[i])) console.log("YES");
//     else console.log("NO");
// }
