const randomUtils = require('./RandomUtils');

const map = [[]];
// 初始化
const col = randomUtils.randomNumber.randomInt(20, 30);
const row = randomUtils.randomNumber.randomInt(20, 30);
for (let i = 0; i < row; i++) {
    const hang = []
    for (let j = 0; j < col; j++) {
        hang[j] = 0;
    }
    map[i] = hang;
}


/**
 * 绘制矩形
 * @param stepRow
 * @param stepCol
 * @param start
 * @param map
 * @return 左上定点，右上定点，右下定点，左下定点
 */
function drawRectangle(stepRow, stepCol, start, map) {
    let index = [start[0], start[1]];
    const result = [];
    const checkMapBoundary = (x, y, map) => {
        if (x >= map.length) {
            x = map.length - 1;
        } else if (x < 0) {
            x = 0;
        }
        if (y >= map[0].length) {
            y = map[0].length - 1;
        } else if (y < 0) {
            y = 0;
        }
        return [x, y];
    }
    // 上边
    result.push([index[0], index[1]])
    for (let i = 0; i < stepRow; i++) {
        map[index[0]][index[1]] = 1
        index[1]++;
        index = checkMapBoundary(index[0],index[1], map)

    }
    // 右边
    result.push([index[0], index[1]])
    for (let i = 0; i < stepCol; i++) {
        map[index[0]][index[1]] = 1
        index[0]++;
        index = checkMapBoundary(index[0],index[1], map)

    }
    // 下边
    result.push([index[0], index[1]])
    for (let i = 0; i < stepRow; i++) {
        map[index[0]][index[1]] = 1
        index[1]--;
        index = checkMapBoundary(index[0],index[1], map)

    }
    // 左边
    result.push([index[0], index[1]])
    for (let i = 0; i < stepCol; i++) {
        map[index[0]][index[1]] = 1
        index[0]--;
        index = checkMapBoundary(index[0],index[1], map)
    }
    // 绘制内部,BFS
    const bfs = (x, y, map) => {
        if (x < 0 || y < 0) {
            return;
        }
        if (x >= map.length || y >= map[0].length) {
            return;
        }
        if (map[x][y] === 0) {
            map[x][y] = 2;
            bfs(x + 1, y, map);
            bfs(x - 1, y, map);
            bfs(x, y + 1, map);
            bfs(x, y - 1, map);
        }
    }
    map[result[0][0] + 1][result[0][1] + 1] = 0;
    bfs(result[0][0] + 1, result[0][1] + 1, map)
    return result;
}

function randomPoint(minPoint, maxPoint) {
    return [randomUtils.randomNumber.randomInt(Math.min(minPoint[0], maxPoint[0]) + 2, Math.max(minPoint[0], maxPoint[0]) - 2),
        randomUtils.randomNumber.randomInt(Math.min(minPoint[1], maxPoint[1]) + 2, Math.max(minPoint[1], maxPoint[1]) - 2)]
}


function drawMultipleRectangles(stepRow, stepCol, start, map, len) {
    let drawRectangle1 = drawRectangle(stepRow, stepCol, start, map);
    for (let i = 0; i < len; i++) {
        // 上下左右方向权重
        let direction = randomUtils.randomNumber.randomInt(0, 10);
        if (0 < direction && direction <= 2) {
            // 上
            drawRectangle1 = drawRectangle(stepRow, stepCol, randomPoint(drawRectangle1[0], drawRectangle1[1]), map);
        } else if (2 < direction && direction <= 5) {
            // 右
            drawRectangle1 = drawRectangle(stepRow, stepCol, randomPoint(drawRectangle1[1], drawRectangle1[2]), map);
        } else if (5 < direction && direction <= 8) {
            // 下
            drawRectangle1 = drawRectangle(stepRow, stepCol, randomPoint(drawRectangle1[2], drawRectangle1[3]), map);
        } else if (8 < direction && direction <= 10) {
            drawRectangle1 = drawRectangle(stepRow, stepCol, randomPoint(drawRectangle1[3], drawRectangle1[0]), map);
        }
    }
}

// 初始起点（一般左上角）
const stepRow = 8
const stepCol = 5
const start = [0, 0];
drawMultipleRectangles(stepRow, stepCol, start, map, 8)

// let drawRectangle1 = drawRectangle(stepRow, stepCol, start, map);
// drawRectangle1 = drawRectangle(stepRow, stepCol, randomPoint(drawRectangle1[1], drawRectangle1[2]), map);


console.log(map)
