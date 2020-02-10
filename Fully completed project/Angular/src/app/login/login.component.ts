import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Authentication } from '../authentication';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message = null;
  forestResponce: ForestResponce;
  constructor(public auth: Authentication,
              public router: Router) { }

  ngOnInit() {
  }
  login(form: NgForm) {
      this.auth.loginuser(form.value).subscribe(responce => {
        this.forestResponce = responce;
        console.log(responce);
        console.log(form);
        if (this.forestResponce.statusCode === 201) {
          form.reset();
          this.message = responce.descrption + ' Redirecting to Home page...';
          setTimeout(() => {
            this.message = null;
            localStorage.setItem('details', JSON.stringify(responce));
            this.router.navigateByUrl('');
          }, 2000);
        } else {
          this.message = responce.descrption;
          setTimeout(() => {
            this.message = null;
          }, 3000);
        }
      });
  }

}
