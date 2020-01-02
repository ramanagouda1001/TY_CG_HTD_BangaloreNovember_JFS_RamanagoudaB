var person={
    adhar:'1212121121212'
}

var panCard={
    pancard:123456
}
var student={
    ...panCard,
    ...person,//inherit all the property of person to student
    id:1234,
    name:'rohan',
    degree:'BE',
    phone:'8080808080',
    address:{
        permament:'akki',
        temp:{
            location:'bana',
            location1:'vij'
        }
    }
}
console.log(student)
console.log(student.address.temp.location1);
// console.log(student.name);
// console.log(student['degree']);
// console.log(student['id']);
// console.log(student['phone']);
//... spread operator