import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  forestResponce: ForestResponce;
  message:string
  constructor(public auth: Authentication,
              public router: Router) { }

  ngOnInit() {
  }

  registerform(form: NgForm) {
    this.auth.register(form.value).subscribe(responce => {
      this.forestResponce = responce;
      console.log(responce);
      if (this.forestResponce.statusCode === 201) {
          form.reset();
          
          this.message = responce.descrption + ' Redirecting to Home page...';
          setTimeout(() => {
            this.message = null;
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
