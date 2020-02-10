import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addcontract',
  templateUrl: './addcontract.component.html',
  styleUrls: ['./addcontract.component.css']
})
export class AddcontractComponent implements OnInit {

  date;
  message: string;
  forestResponce: ForestResponce;
  constructor(public auth: Authentication,
              public router: Router) {
    const today = new Date();
    const date = today.getDate();
    const year = today.getFullYear();
    const month = today.getMonth() + 1;
    if (today.getMonth() > 8) {
      this.date = year + '-' + month + '-' + date;
    } else {
      this.date = year + '-' + '0' + month + '-' + date;
    }
  }

  ngOnInit() {
  }

  addContractDetails(form: NgForm) {
    this.auth.addContract(form.value).subscribe(response => {
      console.log(form.value);
      this.forestResponce = response;
      this.message = response.descrption + '....';
      if (this.forestResponce.statusCode === 201) {
        form.reset();
        setTimeout(() => {
          this.message = null;
          this.router.navigateByUrl('');
        }, 2000);
      }
    });
  }
}
