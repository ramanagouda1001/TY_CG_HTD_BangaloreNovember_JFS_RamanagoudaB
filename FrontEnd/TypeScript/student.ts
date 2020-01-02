class students{
    constructor(
        public name:string,
        public age:number,
        public usn:String,
        public pancard?:number//optional and should be present at last nly
    ){

    }
   static  data()
    {

    }
}
 let student1:students={//if u remove static it will show array
     name:'Rohan',
     age:23,
     usn:"3AE15CS093"
 }

 let student2=new students('saif',12,'hi');

 let clearedStudent=[
     new students('ramana',12,'abc'),
     new students('saif',22,'qqqq')

 ];

 console.log(clearedStudent);