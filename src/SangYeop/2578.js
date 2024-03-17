const input = require('fs').readFileSync('example.txt').toString().trim().split('\n');
const table = input.slice(0,5).map(v => v.split(" ").map(Number));
const orderOfNumber = input.slice(5,10).map(v => v.split(" ").map(Number)).flatMap(v=>v)

function checkRow(table){
    let count = 0;
    for(let i = 0; i < table.length; i++){
        if(table[i].reduce((acc, cur) => acc+cur) === 0){
            count += 1;
        }
    }
    return count
}
function checkColumn(table){
    let bingo = 0;
    for(let i = 0; i < table.length; i++){
        let count = 0;
        for(let j = 0; j < table[i].length; j++){
            if(table[j][i] === 0){
                count += 1;
            }
        }
        if(count === 5){
            bingo += 1;
        }
    }
    return bingo;
    
}
function checkDiagonal(table){
    const rightBingo = [];
    const leftBingo = [];
    let result = 0;
    for(let i = 0; i < table.length; i++){
        rightBingo.push(table[i][i]);
        leftBingo.push(table[i][4-i]);
    }
    if(rightBingo.reduce((acc, cur)=> acc+ cur) === 0) result += 1;
    if(leftBingo.reduce((acc, cur)=> acc+ cur) === 0) result += 1;
    return result;
}

let answer = 1;
for(const number of orderOfNumber){
    for(let j = 0; j < 5; j++){
        for(let k = 0; k < 5; k++){
            if(number === table[j][k]){
                let result = 0; 
                table[j][k] = 0;
                result += checkRow(table)
                result += checkColumn(table);
                result += checkDiagonal(table);
                if(result >= 3){
                    console.log(answer)
                    return;
                }
            };
        }
    }
    answer += 1;
}
// 이중 배열 순회 및 처리, 빙고에서 체크되는 숫자는 어떻게 처리해야 좋은지?
// 답을 확인 후, 느낌점 1. 가로 세로 대각선이 빙고인 것을 각각의 함수로 생각할 수 있다. 

// 1. 하나의 순회에서 하기 곤란하다면 나눠서 생각하자
// 2. 배열의 세로와 대각선을 어떻게 보는지 알자.
// 3. 무식하게 구현하는 것에 대해서 일단 해보면서 생각하자.