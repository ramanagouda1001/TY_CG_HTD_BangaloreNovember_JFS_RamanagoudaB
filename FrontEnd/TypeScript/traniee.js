"use strict";
var studentss = /** @class */ (function () {
    function studentss(usn) {
        this.usn = usn;
    }
    return studentss;
}());
var traning = /** @class */ (function () {
    function traning() {
    }
    traning.prototype.printdata = function () {
        console.log('hi');
    };
    return traning;
}());
var trainee1 = {
    name: "rohan",
    age: 12,
    usn: 23,
    printdata: function () {
        console.log("");
    }
};
//ts an interaface can extends mutiple classes and all the property of class will be made abstract in interface
