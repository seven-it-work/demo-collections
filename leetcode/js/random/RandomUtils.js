const BASE_STR = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"

const randomStr = {
    /**
     * 随机字符串
     * @param min 字符串最小长度
     * @param max 字符串最大长度
     * @param baseStr 基础字符串
     * @returns {string} 随机字符串
     */
    randomStr: (min = 1, max = Number.MAX_VALUE, baseStr = BASE_STR) => {
        let result = "";
        for (let i = 0; i < randomNumber.randomInt(min, max); i++) {
            result += (baseStr + "").charAt(randomNumber.randomInt(0, baseStr.length))
        }
        return result;
    },

    /**
     * 随机字符串
     * @param len 字符串长度
     * @param baseStr 基础字符串
     * @returns {string} 随机字符串
     */
    randomStrByLen: (len = 1, baseStr = BASE_STR) => {
        return randomStr.randomStr(len, len, baseStr);
    }
}

const randomList = {
    /**
     * 随机数组
     * @param min 数组的最小长度
     * @param max 数组的最大长度，如果小于min，则=min
     * @param baseList 从基础数组中取值
     * @returns {*[]} 随机数组结果
     */
    randomList: (min = 0, max = 0, baseList = []) => {
        if (max < min) {
            max = min
        }
        const size = randomNumber.randomInt(min, max);
        const result = []
        for (let i = 0; i < size; i++) {
            const index = randomNumber.randomInt(0, baseList.length - 1);
            result.push(baseList[index]);
        }
        return result;
    },

    /**
     * 随机数组
     * @param len 数组的长度
     * @param baseList 基础数组
     * @returns {*[]} 返回结果
     */
    randomListByLen: (len = 1, baseList = []) => {
        return randomList.randomList(len, len, baseList);
    },

    /**
     * 随机数组，在基础数组中获取，不会重复获取
     * @param len 数组长度
     * @param baseList 基础数组
     * @returns {*[]} 随机数组
     */
    randomListNotRepeating: (len = 1, baseList = []) => {
        let sortBase = baseList.sort(() => randomBool() ? -1 : 1);
        return sortBase.slice(0, len);
    }
}

/**
 * 随机boolean
 * @returns {boolean} true/false
 */
function randomBool() {
    return randomNumber.randomInt(0, 1) === 0;
}

const randomNumber = {
    /**
     * 获取从min到max的随机整数，包含[min,max]
     * @param min 最小值
     * @param max 最大值
     * @returns {number} 随机结果
     */
    randomInt: (min = 1, max = Number.MAX_VALUE) => {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    },
    /**
     * 获取从min到max的随机小数，包含[min,max]
     * @param min 最小值
     * @param max 最大值
     * @param decimalPlaces 小数位数，如果小于1则认为是整数
     * @returns {number} 随机结果
     */
    randomDecimal: (min = 1, max = Number.MAX_VALUE, decimalPlaces = 1) => {
        if (decimalPlaces < 1) {
            // 认为取整
            return randomNumber.randomInt(min, max);
        }
        const pow = Math.pow(10, decimalPlaces);
        return Math.round((Math.random() * (max - min + 1) + min) * pow) / pow;
    }
}

module.exports = {randomNumber, randomBool, randomList, randomStr}
