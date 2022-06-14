"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var user_1 = require("./lib/user");
// default import
var interface_example_1 = require("./lib/interface-example");
function log(message) {
    console.log(message);
}
log('Hello, TypeScript!');
// log(123); // compilation error, log only accepts string arguments
function scopingIsEnforced() {
    for (var i = 0; i < 10; i++) {
        console.log(i);
    }
    // console.log(i);
}
scopingIsEnforced();
function createAndPrintSomeUser() {
    var me = new user_1.User(123, 'Wesley', 'Singleton', 'wsingleton', 'revature');
    console.log(me);
    console.log(me.firstName);
    me.firstName = 'Wezley';
    console.log(me);
    console.log(me.firstName);
}
createAndPrintSomeUser();
interface_example_1.default.testTypeFn(function (someUser) {
    console.log('hello user!');
});
