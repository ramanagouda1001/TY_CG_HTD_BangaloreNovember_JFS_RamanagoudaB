import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-list',
  templateUrl: './get-list.component.html',
  styleUrls: ['./get-list.component.css']
})
export class GetListComponent implements OnInit {

  message;
  lists: List[];

  constructor(public auth: Authentication,
              public router: Router) {
    this.getList();
  }

  getList() {
    this.auth.getList().subscribe(responce => {
      console.log(responce);
      this.lists = responce;
    });
  }
  delete(items) {
    this.lists.splice(this.lists.indexOf(items), 1);
  }



  update(items) {
    this.auth.updateList = items;
    this.router.navigateByUrl('/update');
  }
  ngOnInit() {
  }



  }
