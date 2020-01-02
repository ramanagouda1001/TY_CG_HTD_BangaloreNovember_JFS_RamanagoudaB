"use strict";
console.log("typescript code ");
//typescript also support dynamic typing with help of 'any' type
//command to create ts configuration file tsc --init(all  rules to be follwed to mentioned in this tsc)
// tsc -w stands for watch
var a = 100;
a = null; //nullable type(in tsconfig.json strictNullChecks assign to false it will not check for null)
//a='string' error as a is number type
var b; // implicity considered as any 
b = 'hello';
b = 100;
console.log(b);
console.log(a);
var arrayOfString; //only store array od string
arrayOfString = ['rohan', '1'];
var student;
student = { name: 'rohan', age: 1 };
console.log(student.age);
var Sample = /** @class */ (function () {
    function Sample(name, age, usn, marks) {
        this.name = name;
        this.age = age;
        this.usn = usn;
        this.marks = marks;
    }
    Sample.prototype.printDetails = function () {
        console.log("name is " + this.name);
    };
    return Sample;
}());
var s = new Sample("rohan", 20, "1221", 12);
console.log(s.printDetails());
//we cannot declare class number using var let 
//3 types of acess specifier
//private public protected
// by default all ts and class meneber are public 
//if we provide acess specifier for the contract arugment then those argument become class member
