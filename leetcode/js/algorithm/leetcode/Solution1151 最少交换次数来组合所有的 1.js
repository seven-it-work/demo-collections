/**
 *
 * @param data {[number]}
 * @return {number}
 */
var change = function (data) {
    const windowSize = data.filter(number => number === 1).length;
    let left = 0;
    let right = 0;
    let zeroCount = 0;
    let minZeroCount = Number.MAX_VALUE
    while (right < data.length) {
        if (data[right] === 0) {
            zeroCount++
        }
        if (right - left + 1 === windowSize) {
            minZeroCount = Math.min(minZeroCount, zeroCount);
            if (data[left] === 0) {
                zeroCount--;
            }
            left++;
        }
        right++;
    }
    return minZeroCount===Number.MAX_VALUE?0:minZeroCount;
}
var change2 = function (data) {
    const oneSize = data.filter(number => number === 1).length;

}
module.exports = change;

[1,2].slice(0,1)