import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Authentication } from '../authentication';

@Component({
  selector: 'app-update-list',
  templateUrl: './update-list.component.html',
  styleUrls: ['./update-list.component.css']
})
export class UpdateListComponent implements OnInit {

  constructor(public auth: Authentication) { }

  ngOnInit() {
  }

  updateList(from: NgForm) {
    this.auth.updateAccount(from.value).subscribe( responce => {
        console.log(responce);
    });
  }
}
