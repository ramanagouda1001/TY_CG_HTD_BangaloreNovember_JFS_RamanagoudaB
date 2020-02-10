import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getland',
  templateUrl: './getland.component.html',
  styleUrls: ['./getland.component.css']
})
export class GetlandComponent implements OnInit {

  selectedToUpdateLand: Authentication;
  forestResponce: ForestResponce;
  lands: Land[];


  constructor(public auth: Authentication,
    public router: Router) {
    this.getLand();
  }

  ngOnInit() {
  }

  getLand() {
    this.auth.getLand().subscribe(responce => {
      this.lands = responce.list;
      console.log(responce);
    });
  }

  updateLand(land) {
    this.router.navigate([`editland/${land.number}`],
      {
        queryParams:
        {
          number: land.number,
          name: land.name, 
          area: land.area, 
          region: land.region, 
          forest_type: land.forest_type
        }
      });
  }


  deleteLand(land) {
    this.auth.deleteLand(land).subscribe(responce => {
      this.forestResponce = responce;
      if (this.forestResponce.statusCode === 201) {
        this.lands.splice(this.lands.indexOf(land), 1);
      }
    });
  }


}
