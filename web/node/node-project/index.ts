function log(message: string) {
    console.log(message);
}

log('Hello, TypeScript!');
// log(123); // compilation error, log only accepts string arguments

function scopingIsEnforced() {

    for (let i = 0; i < 10; i++) {
        console.log(i);
    }

    // console.log(i);
}
