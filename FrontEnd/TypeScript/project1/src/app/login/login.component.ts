import { Component, OnInit } from '@angular/core';
import { Form, NgForm } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor() { }

  ngOnInit() {
  }
  sumbitFrom(form:NgForm){
    console.log(form);
    form.reset();
  }
}
