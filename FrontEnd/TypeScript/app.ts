console.log("typescript code ");
//typescript also support dynamic typing with help of 'any' type
//command to create ts configuration file tsc --init(all  rules to be follwed to mentioned in this tsc)
// tsc -w stands for watch

let a=100;
a=null;//nullable type(in tsconfig.json strictNullChecks assign to false it will not check for null)
//a='string' error as a is number type
let b;// implicity considered as any 
b='hello';
b=100;
console.log(b);

console.log(a);

let arrayOfString:string[];//only store array od string
arrayOfString=['rohan','1'];

let student:{name:String,age:number};
student={name:'rohan',age:1};
console.log(student.age);


class Sample{
    constructor(
        public name:string,
        public age:number,
        public usn:String,
        public marks:number
        ){
    }
    printDetails():void
    {
        console.log(`name is ${this.name}`);
    }
}
let s=new Sample("rohan",20,"1221",12);
console.log(s.printDetails());
//we cannot declare class number using var let 


//3 types of acess specifier
//private public protected
// by default all ts and class meneber are public 
//if we provide acess specifier for the contract arugment then those argument become class member