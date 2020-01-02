class   studentss{
    constructor(
        public usn:number
    ){

    }
}


interface trainee extends studentss{
    name:string;
    age:number;
    printdata():void
}
class traning implements trainee{
    name:"rohan";
    age:23;
    usn:222;
    printdata(){
        console.log('hi');
    }
}


let trainee1:trainee={
    name:"rohan",
    age:12,
    usn:23,
    printdata():void
    {
        console.log("");
    }

}
//ts an interaface can extends mutiple classes and all the property of class will be made abstract in interface