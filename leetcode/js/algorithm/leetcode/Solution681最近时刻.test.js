const nextClosetTime = require('./Solution681最近时刻');

it('demo01', function () {
    expect(nextClosetTime("19:34")).toBe("19:39")
});

it('demo02', function () {
    expect(nextClosetTime("23:59")).toBe("22:22")
});
it('demo03', function () {
    expect(nextClosetTime("01:34")).toBe("01:40")
});

it('demo04', function () {
    expect(nextClosetTime("02:42")).toBe("02:44")
});
