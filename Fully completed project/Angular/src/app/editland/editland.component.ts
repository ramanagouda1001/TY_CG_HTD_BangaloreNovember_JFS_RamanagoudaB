import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-editland',
  templateUrl: './editland.component.html',
  styleUrls: ['./editland.component.css']
})
export class EditlandComponent implements OnInit {

  number1;
  name1;
  area1;
  region1;
  // tslint:disable-next-line: variable-name
  forest_type1;

  forestResponce: ForestResponce;
  constructor(public auth: Authentication,
              public router: Router,
              public activatedRouter: ActivatedRoute) {
                activatedRouter.params.subscribe(data => {
                  this.number1 = data.number;
                });
                activatedRouter.queryParams.subscribe(data => {
                  this.name1 = data.name;
                  this.area1 = data.area;
                  this.region1 = data.region;
                  this.forest_type1 = data.forest_type;
                });
               }

  ngOnInit() {
  }

  updateLandDetails(form: NgForm) {
    this.auth.updateLand(form.value).subscribe(responce => {
      this.forestResponce = responce;
      if (this.forestResponce.statusCode === 201) {
        form.reset();
        this.router.navigateByUrl('/getland');
      }
    });
  }
}
