import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-addland',
  templateUrl: './addland.component.html',
  styleUrls: ['./addland.component.css']
})
export class AddlandComponent implements OnInit {

  constructor(public auth: Authentication) {
   
  }

  message: string;
  forestResponce: ForestResponce;
  ngOnInit() {
  }

  addLandDetails(form: NgForm) {
    this.auth.addLand(form.value).subscribe(responce => {
      this.forestResponce = responce;
      this.message = responce.descrption + '....';
      if (this.forestResponce.statusCode === 201) {
        form.reset();
        setTimeout(() => {
          this.message = null;
        }, 2000);
      }
    });
  }

}
