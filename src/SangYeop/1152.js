const input = require('fs').readFileSync('example.txt').toString().trim().split(' ')
// readFileSync('/dev/stdin')
if(input[0] === '') console.log(0)
console.log(input.length);
