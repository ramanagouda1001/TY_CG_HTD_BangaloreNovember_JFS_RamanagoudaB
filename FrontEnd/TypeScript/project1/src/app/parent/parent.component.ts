import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit,OnDestroy {

  dataFromChild;
  student = {
    name: 'rohan',
    age: '20',
    marks : '122'
  };


  getChildData(data)
  {
    this.dataFromChild=data;
  }
  constructor() { }

  ngOnInit() {
    console.log("HELLO FROM ONINIT");
  }

  ngDoCheck() {
    console.log("DO CHECK");
  }
  ngOnDestroy() {
    console.log("DESTORY");
  }
  ngAfterContentInit() {
    console.log("HELLO FROM AFterCONTENT");
  }
  
}
