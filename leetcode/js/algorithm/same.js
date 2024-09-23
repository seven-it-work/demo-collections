/**
 *
 * @param str1 字符串1
 * @param str2 字符串2
 * @return boolean 匹配结果
 */
function same(str1, str2) {

}

//电梯轿厢(Elevator)与电梯按钮(Elevator Button)是聚合关系
//电梯轿厢(Elevator)与电梯按钮(Elevator Button)是组合关系
//电梯轿厢(Elevator)与楼层按钮(Floor Button)是组合关系
//电梯轿厢(Elevator)与楼层按钮(Floor Button)是聚合关系
let s1 = '电梯轿厢与电梯按钮是聚合关系';
let s2 = '电梯轿厢(Elevator)与电梯按钮(Elevator Button)是组合关系';
let sp = [
    '电梯轿厢(Elevator)与电梯按钮(Elevator Button)是聚合关系',
    '电梯轿厢(Elevator)与电梯按钮(Elevator Button)是组合关系',
    '电梯轿厢(Elevator)与楼层按钮(Floor Button)是组合关系',
    '电梯轿厢(Elevator)与楼层按钮(Floor Button)是聚合关系']

/**
 *
 * @param x {string}
 * @param y {string}
 * @return {number}
 */
function obtainTheRecognitionDegree(x, y) {
    let z = 0;
    x = x.toUpperCase();
    y = y.toUpperCase();
    x = x.replace('_', '');
    y = y.replace('_', '');
    if (typeof x == "string") {
        x = x.split("");
        y = y.split("");
    }
    const s = x.length + y.length;
    x.sort();
    y.sort();
    let a = x.shift();
    let b = y.shift();
    while (a !== undefined && b !== undefined) {
        if (a === b) {
            z++;
            a = x.shift();
            b = y.shift();
        } else if (a < b) {
            a = x.shift();
        } else if (a > b) {
            b = y.shift();
        }
    }
    return z / s * 200;
}

/**
 * 获取最匹配的一个
 * @param  str1 {string}
 * @param strList {[string]}
 */
function getMustSame(str1, strList) {
    return strList.sort((s1, s2) => obtainTheRecognitionDegree(str1, s1) - obtainTheRecognitionDegree(str1, s2)).pop();
}

console.log(getMustSame(s1, sp))
console.log(obtainTheRecognitionDegree("电梯轿厢与电梯按钮是聚合关系", "电梯轿厢(Elevator)与电梯按钮(Elevator Button)是聚合关系"))