const input = require('fs').readFileSync('example.txt').toString();

function fac(n){
    if(n === 0 || n === 1){
        return 1;
    }else{
        return fac(n - 1) * n;
    }
}
console.log(fac(input));

// const fs = require('fs');
// const input = parseInt(fs.readFileSync('/dev/stdin').toString().trim());