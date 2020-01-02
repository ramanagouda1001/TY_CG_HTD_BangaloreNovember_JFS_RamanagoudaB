var n=parseInt(prompt("enter the number"));
var looping=function(n){
    var a=0,b=1,f=1;
    for(var i=0;i<n-1;i++)
        {   
          console.log(a);
          f=a+b;
          a=b;
          b=f;
        }
}
console.log("fibonanci series="+n);
looping(n);

var palindrom=function(n)
{
    var rem,temp,final=0;
    temp=n;
    while(n>0)
    {
        rem = n%10;
		n = parseInt(n/10);
		final = final*10+rem;
    }
    if(final==temp)
    {
        console.log("palindrome");
    }
    else{
        console.log("not");
    }
}
palindrom(n);

var prime=function(n)
{
    for (let i = 2; i <= n; i++) {   // for each i...
        var status=false;
        for (let j = 2; j < i; j++) { // look for a divisor..
          if (i % j == 0) {
              status=true;
              break;
          } // not a prime, go next i
        }
        if(status== false)
        console.log(i);
    }
}
prime(n);


var fact=function(n){
    var fact=1,i=1;
    for(i=i;i<=n;i++)
    {
        fact=fact*i;
    }
    console.log(fact);
}

fact(n);