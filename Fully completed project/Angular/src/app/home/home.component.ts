import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  isLoggedIn() {
    const userDetails = JSON.parse(localStorage.getItem('details'));
    if (userDetails) {
        return false;
    } else {
      return true;
    }
  }
}
