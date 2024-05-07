// const input = require('fs').readFileSync('/dev/stdin').toString().split('\n').slice(0,-1);
const input = require('fs').readFileSync('example.txt').toString().trim().split('\n');
const NM = input[0].split(" ");
const [n, m] = NM.map(el => Number(el));

const sequence = [...Array(m)].fill(0);
const visited = [...Array(n+1)].fill(false);
let result = ''

function dfs(k) {
  if (k === m) {
    const arr = [];
    for (let i = 0; i < m; i++){
      arr.push(sequence[i]);
    }
    return result += `${arr.join(' ')}\n`;
  }

  for (let i = 1; i <= n; i++){
    if (!visited[i]) {
      sequence[k] = i;
      visited[i] = true;
      dfs(k + 1);
      visited[i] = false;
    }
  }
}

dfs(0)
console.log(result)