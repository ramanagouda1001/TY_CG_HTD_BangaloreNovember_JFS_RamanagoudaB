import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-editaccount',
  templateUrl: './editaccount.component.html',
  styleUrls: ['./editaccount.component.css']
})
export class EditaccountComponent implements OnInit {

  forestResponce: ForestResponce;
  message:string;
  email1;
  password1;
  role1;
  constructor(public auth: Authentication,
              public router: Router,
              public activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      this.email1 = data.email;
    })
    activatedRoute.queryParams.subscribe(data => {
      this.email1 = data.email;
      this.password1 = data.password;
      this.role1 = data.role;
    })
  }

  ngOnInit() {
  }

  updateAccountDetails(form: NgForm){
    this.auth.updateaccount(form.value).subscribe(responce =>{
      this.forestResponce= responce;
      if(this.forestResponce.statusCode === 201){
        this.message=responce.descrption;
        setTimeout(()=>{
          this.message=null;
          this.router.navigateByUrl('/getaccount');
        },2000)
      }

    })
  }
}
