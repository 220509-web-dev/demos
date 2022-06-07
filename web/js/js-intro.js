// single line comment

/*
  multi
  line
  comment
*/

/**
 * This is documentation comment (goes onto of functions to describe their behavior)
 */
function exampleFunction() {

}

/*
    JavaScript is a loosely-typed language, not untyped!

        Primitive types:
            - string
            - number
            - boolean
            - null (represents the lack of an object value; primitive root value)
            - undefined (an uninitialized value)
            - bigint
            - Symbol (always unique, even if they contain the same value; excellent for UUIDs)

        Structural types:
            - object
                + Array
                + Set
                + Date
                + Map
                + Function
                + user-defined types
 */

// JavaScript is loosely typed, variables can be reassigned to any value (though, you should probably limit this)
var variable1 = 'five';
console.log(variable1);

variable1 = 5;
console.log(variable1);

//--------------

// Symbols are useful as UUIDs since they are ALWAYS unique
let uniqueId_1 = Symbol('test-value');
let uniqueId_2 = Symbol('test-value');
console.log(uniqueId_1 === uniqueId_2); // false

//--------------

// Explore null and undefined
let nullValue = null; // represents the lack of an object value (not quite the same as undefined)
let undefinedValue_1; // literally no value at all, uninitialized
let undefinedValue_2 = undefined; // explicitly assigned undefined value

//--------------

// Functions are used to encapsulate logic so that it can be reused in various places

// standard/named function declarations
function functionA(x, y, z) {
    console.log('This is a named function declaration that takes in some values and returns a value!');
    console.log('x: ' + x); // this concatenates the string "x: " with the number x by converting x into a string
    console.log('y:', y); // this does not convert y to a string since we are using the concatenation operator
    console.log(`z: ${z}`); // string interpolation (introduced in ES6); coerces injected variables into strings

    console.log("JavaScript doesn't care if you use single or double quotes for strings");
    console.log('Most JS developers use single quotes, though.');
    
    return 5;
}

functionA(1, 2, 3); // invokes the function named "functionA"
functionA(); // notice that JS doesn't care that you didn't pass any values in

// Because functions are "first-class members" in JS, which means:
//  - we assign function declarations to variables (those variables can be used to invoke the function)
//  - pass a function to another function as an argument
//  - return a function from another function

// anonymous function declarations
let functionB = function () {
    console.log('This is an anoynmous function declaration!');
    return 5;
}

console.log(functionB); // print the value of the variable "functionB" (do not invoke it!)

let functionB_result = functionB();
console.log(functionB_result);

function myCallbackFunction(someOtherFunction) {
    console.log('This is an example of a callback function (a function that is passed another function as a parameter).');
    someOtherFunction();
}

function otherFunction() {
    console.log('This is a function that will be called back to when "myCallbackFunction" is invoked!');
}

myCallbackFunction(otherFunction);

// this is not passing a function, it is passing the result of functionA's invocation
// myCallbackFunction(functionA()); 

function functionC() {
    console.log('functionC logic goes here.');
    functionD();
}

functionC();

function functionD() {
    console.log('functionD logic goes here.');
}

// Beware of variable hoisting when using the "var" keyword to declare variables
// (Pro tip: just use "let" or "const" instead)

function hoistingVarExample(x) {
    console.log('hoistingVarExample (1): ' + greeting); // undefined
    if (x % 2 == 0) {
        var greeting = 'hello!';
        console.log('hoistingVarExample (2): ' + greeting); // 'hello!'
    }
    console.log('hoistingVarExample (3): ' + greeting); // undefined is x is odd, otherwise prints 'hello!'
}

function hoistingVarExample_whatsActuallyHappening(x) {
    var greeting;
    console.log('hoistingVarExample (1): ' + greeting); // undefined
    if (x % 2 == 0) {
        greeting = 'hello!';
        console.log('hoistingVarExample (2): ' + greeting);
    }
    console.log('hoistingVarExample (3): ' + greeting);
}

hoistingVarExample(2);

function letScopeExample(x) {
    // console.log('letScopeExample (1): ' + greeting); // ReferenceError, variables declared using let/const are not hoisted and therefore greeting is unknown
    if (x % 2 == 0) {
        let greeting = 'hello';
        console.log('letScopeExample (2): ' + greeting);
    }
    // console.log('letScopeExample (3): ' + greeting); // ReferenceError, variables declared using let/const are not visible outside of the block in which they were declared
}

letScopeExample(2);

console.log(window);

// Using "var" in the global scope could bind values to the Browser's window object (which can do weird stuff)
// var location = 'https://www.google.com';

// Throws SyntaxError since "location" is a field of the global window object
// let location = 'https://www.google.com';

function constScopeExample(x) {
    // console.log('constScopeExample (1): ' + greeting); // ReferenceError, variables declared using const are not hoisted and therefore greeting is unknown
    if (x % 2 == 0) {
        const greeting = 'hello';
        console.log('constScopeExample (2): ' + greeting);
    }
    // console.log('constScopeExample (3): ' + greeting); // ReferenceError, variables declared using const are not hoisted and therefore greeting is unknown
}

constScopeExample(2);

const meaningOfLife = 42;
// meaningOfLife = 43; // TypeError, cannot reassign constant variables
// const willAssignLater; // SyntaxError: Missing initializer in const declaration

//---------------------------------

// object literal syntax
let myObject = {

    greeting: 'Hola!',

    greeter: {
        name: 'Bob',
        age: 53
    },

    printGreeting: function() {
        console.log(`${this.greeter.name} (who is ${this.greeter.age} years old) says, "${this.greeting}"`);
    }
    
}

myObject.printGreeting();

const immutableMaybe = {
    someValue: 10,
    anotherValue: 'test',
    nestedObject: {
        nestedValue: 100
    }
}

console.log(immutableMaybe);
// immutableMaybe = {someValue: 30}; // can't reassign const variables
immutableMaybe.someValue = 20; // allowed because we aren't reassigning to "immtuableMaybe"
console.log(immutableMaybe);

//---------------------------------

// Error handling
try {
    immutableMaybe = {};
} catch (err) {
    console.error('caught error with message: ' + err.message);
} finally {
    console.log('this will execute whether or not an error is thrown');
}

//----------------------------------

function Car(make, model, color, year) {

    // Properties/fields
    this.make = make || 'Ford'; // the || is the OR operator being used to provide a default value in case "make" is undefined
    this.model = model || 'Expedition';
    this.color = color || 'Black';
    this.year = year || '2015';

    // Methods
    this.honk = function() {
        console.log('BEEP!');
    }

}

let defaultCar = new Car();
console.log(defaultCar);

let myCar = new Car('Nissan', 'Rogue', 'Grey');
console.log(myCar);

// using ES6 default values
function Truck(make = 'Chevrolet', model = 'S-10', color = 'gold', year = '2005') {

    // Properties/fields
    this.make = make;
    this.model = model;
    this.color = color;
    this.year = year;

    // Methods
    this.honk = function() {
        console.log('BEEP!');
    }

}

let defaultTruck = new Truck();
console.log(defaultTruck);

let myTruck = new Truck('Ford', 'Ranger', 'Red', '2001');
console.log(myTruck);
myTruck.honk();