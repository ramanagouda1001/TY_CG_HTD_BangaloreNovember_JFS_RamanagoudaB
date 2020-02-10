import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-editproduct',
  templateUrl: './editproduct.component.html',
  styleUrls: ['./editproduct.component.css']
})
export class EditproductComponent implements OnInit {
  forestResponce: ForestResponce;
  // tslint:disable-next-line: variable-name
  product_id1;
  // tslint:disable-next-line: variable-name
  product_name1;
  // tslint:disable-next-line: variable-name
  product_date1;
  // tslint:disable-next-line: variable-name
  product_quality1;
  date: string;
  constructor(public auth: Authentication,
              public router: Router,
              public activatedRoute: ActivatedRoute) {
              activatedRoute.params.subscribe(data => {
                console.log(data);
                this.product_id1 = data.product_id;
              });
              activatedRoute.queryParams.subscribe(data => {

                this.product_name1 = data.product_name;
                this.product_date1 = data.product_date;
                this.product_quality1 = data.product_quality;
              });


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

  updateProductDeatils(form: NgForm) {
    this.auth.updateProduct(form.value).subscribe(responce => {
      this.forestResponce = responce;
      if (this.forestResponce.statusCode === 201) {
        this.router.navigateByUrl('');
      }
    })
  }
}
