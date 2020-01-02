 // console.log(date.getDate());
// console.log(date.getMonth()+1);
// console.log(date.getFullYear());
// console.log(date.getHours());
// console.log(date.getMilliseconds());
// //console.log(date.getTime());

var today=document.getElementById('todays');
setInterval(() => {
    var date=new Date();

    today.innerHTML=`DATE:::${date.getDate()}-${date.getMonth()+1}-${date.getFullYear()} TIME:::${date.getHours()}:${date.getMonth()+1}:${date.getSeconds()}`;
}, 1000);