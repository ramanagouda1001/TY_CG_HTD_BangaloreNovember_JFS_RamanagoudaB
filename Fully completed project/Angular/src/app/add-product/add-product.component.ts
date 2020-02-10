import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Authentication } from '../authentication';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  date;
  forestResponce: ForestResponce;
  message: string;
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


  addProductDetails(form: NgForm) {
    this.auth.addProduct(form.value).subscribe(responce => {
      this.forestResponce = responce;
      this.message = responce.descrption + '....';
      if (this.forestResponce.statusCode === 201) {
        form.reset();
        setTimeout(() => {
          this.message = null;
        }, 2000);
      } else {
        form.reset();
        setTimeout(() => {
          this.message = null;
        }, 2000);

      }
    });
  }
}
