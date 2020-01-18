import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { from } from 'rxjs';

@Component({
  selector: 'app-add-list',
  templateUrl: './add-list.component.html',
  styleUrls: ['./add-list.component.css']
})
export class AddListComponent implements OnInit {

  addItemToList: List;
  constructor() { }

  ngOnInit() {
  }
  addListForm(form: NgForm) {
    this.addItemToList = form.value();
  }

}
