import { User } from "./user";

export interface Point_2D {
    x: number,
    y: number
}

export interface Point_3D {
    x: number,
    y: number,
    z: number,
    printCoordinates: () => void
}

function drawPoint_1(x: number, y: number) {
    // some impl here
}

function drawPoint_2(point: Point_2D) {
    // some impl here
}

drawPoint_1(1, 2);
drawPoint_2({x: 123, y: 987});
// drawPoint_2({x: 123, y: 987, z: 456});

// inline type declaration
function drawPoint_4d(point: {a: number, b: number, c: number, d: number}) {

}

// technically, we can use types to define the "shape" of some object
export type CreateUserRequestPayload = {
    user: User,
    creationTime: Date
}

// more often, types are used to define the "shape" of some function
export type SendUserRequest = (user: User) => void;

// using an interface to define the shape of functions is possible, but kinda ugly
interface SendStringRequest {
    sendStringRequest: (someString: string) => void
}

function testTypeFn(requestFn: SendUserRequest) {
    // stuff here
}

function testInterfaceFn(requestFn: SendStringRequest) {
    // stuff here
}

// declaring the shape of functions is nice and clean using types
testTypeFn((someUser: User) => {
    console.log('hello, ' + someUser.firstName);
});

// with interfaces it works, but uglier that with types
testInterfaceFn({
    sendStringRequest: (someString: string) => {
}})

// export an object containing everything we want to expose
export default {
    testTypeFn,
    testInterfaceFn
}