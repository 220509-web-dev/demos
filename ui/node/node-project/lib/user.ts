export class User {
    
    // fields or methods with no explicitly declared access modifier are implicitly public
    public id: number;
    
    // private fields are only accessible within this class's scope
    // convention for private fields is to prepend a _ to the name
    private _firstName: string;

    // protected fields are only accessible within this class's scope and any child classes
    protected lastName: string;

    username: string;
    password: string;

    // Just like in JS, classes can only have a single constructor
    constructor(id: number, fn: string, ln: string, un: string, pw: string) {
        this.id = id;
        this._firstName = fn;
        this.lastName = ln;
        this.username = un;
        this.password = pw;
    }

    public get firstName() {
        return this._firstName;
    }

    public set firstName(fn: string) {
        if (fn) {
            this._firstName = fn;
        }
    }

}