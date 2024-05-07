const input = require('fs').readFileSync('example.txt').toString().trim().split(' ')
// readFileSync('/dev/stdin')
const distanceOfDay = Number(input[0]);
const distanceOfNight = Number(input[1]);
const totalDistance = Number(input[2]);

const a = distanceOfDay - distanceOfNight;
const b = totalDistance % a;
const c = Math.floor(totalDistance / a);
if(b === 0){
    console.log(c - distanceOfNight)
} else {
    console.log(c + distanceOfNight)
}

