"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function drawPoint_1(x, y) {
    // some impl here
}
function drawPoint_2(point) {
    // some impl here
}
drawPoint_1(1, 2);
drawPoint_2({ x: 123, y: 987 });
// drawPoint_2({x: 123, y: 987, z: 456});
// inline type declaration
function drawPoint_4d(point) {
}
function testTypeFn(requestFn) {
    // stuff here
}
function testInterfaceFn(requestFn) {
    // stuff here
}
// declaring the shape of functions is nice and clean using types
testTypeFn(function (someUser) {
    console.log('hello, ' + someUser.firstName);
});
// with interfaces it works, but uglier that with types
testInterfaceFn({
    sendStringRequest: function (someString) {
    }
});
// export an object containing everything we want to expose
exports.default = {
    testTypeFn: testTypeFn,
    testInterfaceFn: testInterfaceFn
};
