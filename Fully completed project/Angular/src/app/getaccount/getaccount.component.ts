import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-getaccount',
  templateUrl: './getaccount.component.html',
  styleUrls: ['./getaccount.component.css']
})
export class GetaccountComponent implements OnInit {

  accounts: Account[];
  forestResponce: ForestResponce;
  constructor(public auth: Authentication,
              public router: Router) {
    this.getAccount();
   }

  ngOnInit() {
  }

  getAccount() {
    this.auth.getaccount().subscribe(responce => {
      console.log(responce);
      this.accounts = responce.list;
    });
  }

  deleteAccount(account) {
    this.auth.deleteaccount(account).subscribe(responce => {
      this.forestResponce = responce;
      if (this.forestResponce.statusCode === 201) {
        this.accounts.splice(this.accounts.indexOf(account), 1);
      }
    });
  }

  updateAccount(account) {
    this.router.navigate([`editaccount/${account.email}`],
    {queryParams : {email: account.email, password: account.password, role: account.role}});
  }
}
