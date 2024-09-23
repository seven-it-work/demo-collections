// 2022年7月11日17:02:40

function recursion(numbers, str, result) {
    for (let number of numbers) {
        let temp = str + number;
        if (temp.length !== 4) {
            recursion(numbers, temp, result);
        } else if (temp.length === 4) {
            result.add(temp);
            temp = "";
        }
    }
}

function filterValidityTime(numbers) {
    let resultSet = new Set()
    recursion(numbers, "", resultSet)
    return Array.from(resultSet).filter(re => {
        if (re.substr(0, 2) >= "24") {
            return false;
        }
        return re.substr(2, 2) < "60";
    }).sort();
}


/**
 *
 * @param time {string}
 * @return {string}
 */
var nextClosestTime = function (time) {
    const number = time.replace(":", "");
    const numbers = number.split("");
    const timeList = filterValidityTime(numbers);
    const index = timeList.indexOf(number);
    let closeTimeNumber = "";
    if (index === -1 || index === timeList.length - 1) {
        closeTimeNumber += timeList[0];
    } else {
        closeTimeNumber += timeList[index + 1]
    }
    return closeTimeNumber.slice(0, 2) + ":" + closeTimeNumber.slice(2);
}
module.exports = nextClosestTime;