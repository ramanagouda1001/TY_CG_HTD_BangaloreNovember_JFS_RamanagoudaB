import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-getcontract',
  templateUrl: './getcontract.component.html',
  styleUrls: ['./getcontract.component.css']
})
export class GetcontractComponent implements OnInit {

  message: string;
  forestResponce: ForestResponce;
  contracts: Contract[];
  constructor(public auth: Authentication,
    public router: Router) {
    this.get();
  }
  ngOnInit() {
  }

  get() {
    this.auth.getContract().subscribe(responce => {
      this.contracts = responce.list;
    });
  }

  deleteContract(contract) {
    this.auth.deleteContract(contract).subscribe(responce => {
      this.forestResponce = responce;
      if (this.forestResponce.statusCode === 201) {
        this.contracts.splice(this.contracts.indexOf(contract), 1);
        this.router.navigateByUrl('/getproduct');
      }
    })
  }


  isLoggedIn() {
    const userDetails = JSON.parse(localStorage.getItem('details'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }
  isAdmin() {
    const userDetails = JSON.parse(localStorage.getItem('details'));
    if (userDetails && userDetails.role === 'admin') {
      return true;
    } else {
      return false;
    }
  }

  isSchedular() {
    const userDetails = JSON.parse(localStorage.getItem('details'));
    if ( userDetails && userDetails.role === 'Schedular') {
      return true;
    } else {
      return false;
    }
  }


  updateContract(contract) {
   this.router.navigate([`editcontract/${contract.contract_no}`],
    {queryParams:{contract_no:contract.contract_no,customer_id:contract.customer_id,
      product_id:contract.product_id,transport_id:contract.transport_id,
      delivery_date:contract.delivery_date,quality:contract.quality}});
  }

  statusContract(contract) {
    this.auth.statusContract(contract).subscribe(responce => {
      console.log(responce);
      this.forestResponce = responce;
      this.message = this.forestResponce.descrption;
      setTimeout(() => {
        this.message = null;
      }, 4000);
    })
  }
}
