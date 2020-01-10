import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-late-comers',
  templateUrl: './late-comers.component.html',
  styleUrls: ['./late-comers.component.css']
})
export class LateComersComponent implements OnInit {
  person = 'Akshay';

  lateComers = ['diliapa', 'rohan', 'ramanagouda', 'arun'];
  constructor() { }
  flag = true;
  deleteLateComer(name: string) {
    this.lateComers.splice(this.lateComers.indexOf(name), 1);
  }
  ngOnInit() {
  }

}
