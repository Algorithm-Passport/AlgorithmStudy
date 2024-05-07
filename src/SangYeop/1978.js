const input = require('fs').readFileSync('example.txt').toString().trim().split('\n')
// readFileSync('/dev/stdin')
const N = input[0]
const arr = input[1].split(' ').map(v => Number(v));
let result = 0;
for(let i = 0; i < N; i++){
    const M = arr[i];
    if(M === 0 || M === 1){
        continue;
    }
    if(M === 2){
        result += 1;
        continue;
    }
    let flag = true;
    for(let j = 2; j <= Math.ceil(M / 2); j++){
        if(M % j === 0){
            flag = false;
            break;
        }
        
    }
    if(flag) result += 1;
}
console.log(result)

//아예 함수로 빼서 true false로 리턴하는 것


//--------------------------------------------------------
function p(k) {
    if(k < 2) {
      return false;
    }
    var x = Math.floor(Math.sqrt(k));
    for(var i = 2; i <= x; ++i) {
      if(k % i === 0) {
        return false;
      }
    }
    return true;
  }
  console.log(require('fs').readFileSync('/dev/stdin').toString().trim().split('\n')[1].split(' ').map(function(e) { return parseInt(e); }).filter(function(e) { return p(e); }).length);
  