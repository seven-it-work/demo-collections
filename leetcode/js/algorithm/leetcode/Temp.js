
/**
 * 匹配度算法
 * @param str1 字符串1
 * @param str2 字符串1
 */
function isSame(str1, str2, likeAvailable) {
    // console.log("字符是否相同", str1, str2)
    if (str1 === str2) {
        return true;
    } else if ((str1 = formatStr(str1)) === (str2 = formatStr(str2))) {
        return true
    } else if (str1.includes(str2) || str2.includes(str1)) {
        return true
    } else if (likeAvailable && str1.length > 2 && str2.length > 2) {
        let count = 0;
        for (let i = 0; i < 100; i++) {
            const number = randomNum(2, str1.length - 2);
            const s = str1.substring(number, number + 2);
            if (str2.includes(s)) {
                count++;
            }
        }
        return count >= 30;
    }
    return false;
}


/**
 * 生成 [n,m] 的随机整数。
 * @param minNum
 * @param maxNum
 * @returns {number}
 */
function randomNum(minNum, maxNum) {
    switch (arguments.length) {
        case 1:
            return parseInt(Math.random() * minNum + 1, 10);
            break;
        case 2:
            return parseInt(Math.random() * (maxNum - minNum + 1) + minNum, 10);
            break;
        default:
            return 0;
            break;
    }
}

function formatStr(str) {
    // console.log("去除特殊字符", str)
    return str.replace(/[\n\t\r ，。、：“”‘’；《》（）【】？！`一]/g, "").toLowerCase()
}



console.log(isSame("下面的场景，属于模板方法（Template Method）的典型应用场景有",
    "下面关于模板方法正确的是：",
    true))