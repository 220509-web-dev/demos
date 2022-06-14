import { User } from './lib/user';

// default import
import testFunctions from './lib/interface-example';

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

scopingIsEnforced();

function createAndPrintSomeUser() {
    let me = new User(123, 'Wesley', 'Singleton', 'wsingleton', 'revature');
    console.log(me);
    console.log(me.firstName)
    
    me.firstName = 'Wezley';

    console.log(me);
    console.log(me.firstName)
}

createAndPrintSomeUser();

testFunctions.testTypeFn((someUser: User) => {
    console.log('hello user!')
});