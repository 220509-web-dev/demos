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
