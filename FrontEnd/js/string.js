// //1)charCodeAt
// //return the ascii value of charactaer
// let message='good morining folks'
// console.log('ASCll value='+message.charCodeAt(4));
// //2)charAt
// //return the char at particular index
// console.log(message.charAt(9));
// //3)split
// //used to split based on the parameter
// let splitted=message.split(' ');
// console.log(splitted);
// //4)reverse the string   let splitted=message.split('').reverse().join('');
// //5)includes to check whether a string is present with a string
// console.log(message.includes('good'));
// //6)
// console.log(message.toUpperCase());
// console.log(message.toLowerCase());
// //7)substr
// console.log(message.substr(0,3));
// console.log(message.length);

// var add=function(...n)
// {   
//     let sum=0;
//     for(let num of n)
//     {
//         sum=sum+num;
//     }
//     console.log(sum);
// }
// add(2,3,3,4,5,3,2);
// add(2,3);
 obj={
    id: 12,
    name: 'Rohan',
    age: 23,
    result: 'pass'
};
var{id,name,... Rest}=obj;
console.log(id);
console.log(Rest);


var marks=[20,10,30];
var[OCA,L1,Icompas]=marks;
console.log(OCA);

//every browser use engine
//v8 for chrome
//chakra IE
//spidermonkey firefox
//in brower object model window is super object it has subobject
//screen,navigator,doucment,history,location
// screen object contain property of screen
//navigator object contain all the data related to browser
//document DOM(all the data related to document)
//history browser history
//location all the data related to url