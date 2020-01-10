import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

  name='rohan';
  flag=false;
  twoWayData;
  constructor() {
  //  setInterval(()=>{
  //    this.flag=!this.flag;
  //  },1000)
   }
  //  clickMe(){
  //    this.flag=!this.flag;
  //  }
    clickMe(input)
    {
      console.log(input.value);
    }
    printData()
    {
      console.log(this.twoWayData);
    }
  ngOnInit() {
  }

}
