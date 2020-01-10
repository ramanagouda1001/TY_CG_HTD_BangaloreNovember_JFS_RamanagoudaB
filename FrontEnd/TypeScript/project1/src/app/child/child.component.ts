import { Component, OnInit, Input, Output,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  @Input() dateFromParent;

  @Output() childEvent=new EventEmitter();
  constructor() { }

  ngOnInit() {
  }

  sendData(name) {
    this.childEvent.emit(name);
  }
}
