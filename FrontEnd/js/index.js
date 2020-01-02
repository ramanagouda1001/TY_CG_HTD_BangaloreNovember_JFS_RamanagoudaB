// // console.log("I am from extenal");
// // variable 
// var a;
// //intialisation
// a=100;

// console.log("value of a="+a);

// //typeof used to find the value;
// console.log("type of a"+typeof(a));

// var name="Rohan";
// console.log(name);
// console.log('type of name is='+typeof(name))

// var age=67;
// //`` they are called templete literals
// //using templete literals we can have mutiple line string as well as emdedeed expression using string interpolation
// // in order templte literals we will be using back ticks
// //in order to have emdedded expression in the String we will be making use of string interpolations and syntax is ${expression}
// //and should be present in the back ticks

// var details=`The name is ${name} and age is ${age}`
// console.log(details);

// console.log(`${10+12}`)

// var sampleTest=`Lorem ipsum dolor sit amet consectetur adipisicing elit. Cupiditate blanditiis, ratione ut consequatur labore quia at placeat delectus consequuntur officiis, rerum, beatae vitae tenetur consectetur iusto fugit esse facere molestias!`;

// console.log(sampleTest);


// //just declare without instialing it it will be consider as undefined
// var qqq;

// console.log(typeof(qqq));

// var empty=null;
// console.log(typeof empty);


// //== it will check the data but igonre datatypes
// //====it will check the data as well as datatypes
// if(true=='true')
// {
//     console.log("true block");
// }
// else{
//     console.log("flase block");
// }
// javascript is synchorised (line by line excution)
// //whem it comes to webapi its behaves unsynchorised

//alert('Are you fine');
// var varchar=confirm('Are you fine');
// if(console.log(varchar))
// {
//     console.log("user is selected");
// }
// else{
//     console.log("USer is rejected")
// }

// var user_input=prompt('Enter the name');
// console.log(user_input);


//js is script lanuage as it does not complie
//js behave as programming lanaguae with node.js
//document.write("Hello ji");

// types of fuction
// 1)naming fuction
//2)anonyonmous function
//3)function exception
//4)immediate invoke function exception
//syntax
// var a;
// function demo(){
//     console.log(a);
//     var b=100;
//     console.log("HELLO I AM RAMANAGOUDA");
// }
// //throw as b is local vaiable
// //console.log(b);
// demo();

// function add(a,b){
//     return a+b;
// }
// console.log(add(1,2));

// var test=function()
// {
//     console.log("RAMANAGOUDA hello");
// }
// test();

//immediate invoke fuction
// (function(a,b)
// {
//     console.log(a+b);
//     console.log('ITFE running');
// }(12,22))


//passing a function as a argument is knonw as call back fuction

// function sample(x){
//     console.log("first");
//     x();
//     console.log("second");
// }
// sample(function(){
//     console.log("HEllo");
// })

//timeout
// console.log("start");
// setTimeout(function(){
//     console.log("10 done")
// },10000);

// console.log("end");
// console.log("strart");
// var i=0;
// setInterval(function() {
//     console.log(i);
//     i++;
//     console.log("1 second done");
// }, 1000);
// console.log("end");


//ECMA european computer manufacture asscaotion
//fat arrow function

// var test=(a,b)=>{
//     return (a+b);
// }
//or
// var test=(a,b)=>a*b;

// // console.log(test(2,5));

// if(true)
// {
//     //let a=100;//always block scope

//     var a=100//function scope
//    //dynamic  a="str";
// }
// let a=100;

// a='xyz';
// console.log(a);

//js is dynamic lanauage beacuse var a=100(int) a="str"(String)

// using var we redeclare the variable var a,var a ok
//using let we cannot redecalre thr variable let a,let a not ok 

const a='100'
//a=12;
console.log(a);