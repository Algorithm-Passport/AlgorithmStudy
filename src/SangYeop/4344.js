const input = require('fs').readFileSync('example.txt').toString().trim().split('\n');
const testCase = Number(input[0]);
for(let i = 1; i <= testCase; i++){
    const test = input[i].split(' ');
    const numberOfTest = test[0];
    const arr = test.slice(1, test.length)
    const numberArr = arr.map(v => Number(v));
    const sum = numberArr.reduce((acc, cur) => {return acc + cur}, 0);
    const average = sum / numberOfTest;
    const filteredArr = numberArr.filter(v => v > average);
    console.log((filteredArr.length / numberOfTest * 100).toFixed(3)+'%')
}

const arr = [1,2,3,4,5,6]
console.log('aaaaa', arr.slice(-3))
console.log('bbbbbb', arr)