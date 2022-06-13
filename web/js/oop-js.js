window.onload = () => {

    console.log('window loaded!');
    console.log(this);

    thisExample_namedFunction(); // 'this' is bound to the window
    addition(3, 4); // 'this' is bound to the window

    console.log('-----------------------------------------');


    function Car(make, model, color, year) {

        // Properties/fields
        this.make = make || 'Ford'; // the || is the OR operator being used to provide a default value in case "make" is undefined
        this.model = model || 'Expedition';
        this.color = color || 'Black';
        this.year = year || '2015';

        // Methods
        this.honk = function() {
            console.log('BEEP!');
            console.log(this);
        }

        this.drive = function() {
            console.log('the car is driving...');
        } 

    }

    function Truck(make, model, color, year, shortbed) {

        // Properties/fields
        this.make = make || 'Ford'; // the || is the OR operator being used to provide a default value in case "make" is undefined
        this.model = model || 'Expedition';
        this.color = color || 'Black';
        this.year = year || '2015';
        this.shortbed = shortbed;

        // Methods
        this.honk = function() {
            console.log('BEEP!');
        }

    }

    function Vehicle(type) {

        this.type = type;

        this.drive = function() {
            console.log('the vehicle is driving...');
        } 

    }

    Car.prototype = new Vehicle('car');
    Truck.prototype = new Vehicle('truck');


    let myCar = new Car();
    console.log(myCar);

    let myTruck = new Truck();
    console.log(myTruck);

    console.log('car');
    myCar.drive();
    // myCar.stop();

    console.log('truck');
    myTruck.drive();

    console.log('---------------------------');

    function MyCustomMap() {

        // Maps are key value pairs
        // Use associative array ['wsingleton', {firstName: 'Wezley', lastName: 'Singleton'}]
        let entryArray = [];

        function checkIfKeyExists(key) {
            for (let i = 0; i < entryArray.length; i+=2) {
                if (entryArray[i] === key) {
                    return true;
                }
            }
            return false;
        }

        function mapPut(key, value) {
            if (checkIfKeyExists(key)) {
                for (let i = 0; i < entryArray.length; i+=2) {
                    if (entryArray[i] === key) {
                        entryArray[i + 1] = value;
                    }
                }
            } else {
                entryArray.push(key);
                entryArray.push(value);
            }
            
        }

        function mapGet(key) {
            for (let i = 0; i < entryArray.length - 1; i+=2) {
                if (entryArray[i] === key) {
                    return entryArray[i + 1];
                }
            }
        }

        function printContents() {
            console.log(entryArray);
        }

        return {
            put: mapPut,
            get: mapGet,
            toString: printContents
        }

    }

    let myMap = new MyCustomMap();
    myMap.put('wsingleton', {firstName: 'Wezley', lastName: 'Singleton'});
    myMap.put('aanderson', {firstName: 'Alice', lastName: 'Anderson'});
    myMap.put('ttester', {firstName: 'T.', lastName: 'Tester'});
    console.log(myMap.get('wsingleton'));
    console.log(myMap.get('ttester'));
    myMap.put('ttester', {firstName: 'Timothy', lastName: 'Tester'});
    console.log(myMap.get('ttester'));
    console.log(myMap);
    console.log(myMap.toString());

}

function thisExample_namedFunction() {
    console.log('thisExample_namedFunction invoked!');
    console.log(this);
}

function addition(x, y) {
    console.log('addition invoked!');
    console.log(this); 
}

let someObject = {

    thisExample_objectMethod_anonFunction: function () {
        console.log('thisExample_objectMethod_anonFunction invoked!');
        console.log(this); // 'this' is bound to 'someObject'
    },

    // arrow functions do not adopt the surrounding context for 'this', it stays bound to the global object
    thisExample_objectMethod_arrowFunction: () => {
        console.log('thisExample_objectMethod_arrowFunction invoked!');
        console.log(this); // 'this' is bound to the global object
    },

    thisExample_objectMethod_namedFunction: addition

};

someObject.thisExample_objectMethod_anonFunction();
someObject.thisExample_objectMethod_arrowFunction();
someObject.thisExample_objectMethod_namedFunction(1, 2);

addition(1, 2); // 'this' is bound to the window object

