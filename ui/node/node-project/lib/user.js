"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.User = void 0;
var User = /** @class */ (function () {
    // Just like in JS, classes can only have a single constructor
    function User(id, fn, ln, un, pw) {
        this.id = id;
        this._firstName = fn;
        this.lastName = ln;
        this.username = un;
        this.password = pw;
    }
    Object.defineProperty(User.prototype, "firstName", {
        get: function () {
            return this._firstName;
        },
        set: function (fn) {
            if (fn) {
                this._firstName = fn;
            }
        },
        enumerable: false,
        configurable: true
    });
    return User;
}());
exports.User = User;
