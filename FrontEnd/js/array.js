var tech=['java','jdbc','hiberante','spring']
//console.log(tech)
// for(var i=0;i<tech.length;i++)
// {
//    console.log(tech[i]); 
// }
for (let i of tech) {
    console.log(i);
}

for(let x in tech)
{
    console.log(tech[x]+"  "+x)
}



//for of it used to iterate only arrays it return the value we specify the task to be performed on each element of 
//array using for of loop and we cannnt iterate object using for of

//for in loop can be iterate arrays as well as objecg
// it return index in case of arrays and return key in case in return object


// methods present in array
//1)forEach
// tech.forEach((value,index)=>{
//     console.log(index);
//     console.log(value)
// });


//foreach
//this method will not return new array it can perform a praticular in each iternation

//2)indexof
//it returns the first occurence index of an elemenet in the arrayc
//console.log(tech.indexOf('spring'));
//3)pop used remove the element from last index
//4)push add the element in the last
//5)shift to remove from zeroth index
//6)unshift add element from starting

// console.log("before pop");
// console.log(tech);
// tech.pop();
// console.log("after pop");
// console.log(tech);  
// tech.push("hello");
// console.log('after push ');
// console.log(tech)
// console.log("after shift");
// tech.shift()
// console.log(tech);
// console.log("after unshift");
// tech.unshift("Spring ","boot")
// console.log(tech);
//7)splice(Starting index,nof elements to be deletedd,elements to be added(optional))
// tech.splice(1,0,'java');
// console.log("after slice for adding");
// console.log(tech)
// tech.splice(3,1);
// console.log("after slice for delete");
// console.log(tech)
//8)reverse array
// console.log(tech.reverse());

//9)filter(IMP IMP IMP)
//one call back function as argument(value,index,array)
//it should return boolean and new new array with filtered created
//sytanx
//filter((value,index,array)=>{
//
//})
// var marks=[35,12,11,10,45,55,66,77];
// console.log(marks);
// var marksfiltered=marks.filter((value,index,array)=>{
//         return value>35;
// });
// console.log(marksfiltered);

// var assigment=[20,20,20,50,40,40,50,60,70,50];
// var assigmentq=assigment.filter((value,index,array)=>{
//     return assigment.indexOf(value)===index;

// })
// console.log(assigmentq)

//10)maps
//one call back function as argument(value,index,array)
//new new array created with the value which we write in return statement
//sytanx
//maps((value,index,array)=>{
//
//})

// var assigment2=assigment.map((value,index,array)=>{
//     return {ind:index,val:value};
// })
// console.log(assigment2);

//11)sort
var marks=[10,33,44,11,21,23,44,32,41];
var sortedascending=marks.sort((a,b)=>{
    return a-b;//ascending ,b-a descending 
})
console.log(sortedascending);
var sorteddescnding=marks.sort((a,b)=>{
    return b-a;//ascending ,b-a descending 
})
console.log(sorteddescnding);
// sorted method is used to sort the elements in array in ascending or descending
//if we have array of alphabets then it will sort according their ascll vall