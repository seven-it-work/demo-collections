new Promise(function (resolve, reject) {
        resolve();
        setTimeout(function () {
            console.log(1);
        }, 0);
        console.log(2);
    }
).then(function () {
    console.log(3)
}).then(function () {
    console.log(4)
})
console.log(5)