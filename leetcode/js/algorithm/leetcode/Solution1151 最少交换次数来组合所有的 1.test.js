const change = require('./Solution1151 最少交换次数来组合所有的 1');

it('demo01', function () {
    expect(change([0,0,0,1,0])).toBe(0)
});

it('demo02', function () {
    expect(change([1,0,1,0,1,0,0,1,1,0,1])).toBe(3)
});
it('demo03', function () {
    expect(change([1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1])).toBe(8)
});
it('demo04', function () {
    expect(change([0,0,0,0])).toBe(0)
});
it('demo05', function () {
    expect(change([1,1])).toBe(0)
});