"use strict";
var students = /** @class */ (function () {
    function students(name, age, usn, pancard //optional and should be present at last nly
    ) {
        this.name = name;
        this.age = age;
        this.usn = usn;
        this.pancard = pancard;
    }
    students.data = function () {
    };
    return students;
}());
var student1 = {
    name: 'Rohan',
    age: 23,
    usn: "3AE15CS093"
};
var student2 = new students('saif', 12, 'hi');
var clearedStudent = [
    new students('ramana', 12, 'abc'),
    new students('saif', 22, 'qqqq')
];
console.log(clearedStudent);
