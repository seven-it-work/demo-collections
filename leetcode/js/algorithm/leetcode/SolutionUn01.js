/**
 *
 * @param position {number[]}
 * @param index {number}
 * @return {number[]}
 * @constructor
 */
function SqrtObj(position, index) {
    this.index = index;
    this.powValue = Math.pow(position[0], 2) + Math.pow(position[1], 2);
}

/**
 *
 * @param positions {number[][]}
 * @param num {number}
 * @return {number[]}
 * @constructor
 */
let SolutionUn01 = function (positions, num) {
    let sqrtList = [];
    for (let i = 0; i < positions.length; i++) {
        sqrtList.push(new SqrtObj(positions[i], i));
    }
    return sqrtList.sort((sqrt1, sqrt2) => {
        return sqrt1.powValue - sqrt2.powValue;
    }).splice(0, num).map(o => o.index).sort();
}

console.log(new SolutionUn01([[1, 3], [-2, 2]], 1));
console.log(new SolutionUn01([[5, -1], [-2, 4], [3, 3]], 2));
