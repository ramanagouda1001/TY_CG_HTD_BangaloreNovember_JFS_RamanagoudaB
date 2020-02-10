import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public router:Router) { }

  ngOnInit() {
  }

  isAdmin() {
    const userDetails = JSON.parse(localStorage.getItem('details'));
    if ( userDetails && userDetails.role === 'admin') {
      
      return true;
    } else {
      return false;
    }
  }
  isLoggedIn() {
    const userDetails = JSON.parse(localStorage.getItem('details'));
    if (userDetails) {
        return true;
    } else {
      return false;
    }
  }

  isClient() {
    const userDetails = JSON.parse(localStorage.getItem('details'));
    if ( userDetails && userDetails.role === 'client') {
      return true;
    } else {
      return false;
    }
  }
  isProduct() {
    const userDetails = JSON.parse(localStorage.getItem('details'));
    if ( userDetails && userDetails.role === 'product') {
      return true;
    } else {
      return false;
    }
  }

  isSchedular() {
    const userDetails = JSON.parse(localStorage.getItem('details'));
    if ( userDetails && userDetails.role === 'Schedular') {
      return true;
    } else {
      return false;
    }
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }
}
