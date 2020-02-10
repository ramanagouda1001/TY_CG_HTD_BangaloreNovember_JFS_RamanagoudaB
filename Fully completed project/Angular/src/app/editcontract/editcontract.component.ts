import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-editcontract',
  templateUrl: './editcontract.component.html',
  styleUrls: ['./editcontract.component.css']
})
export class EditcontractComponent implements OnInit {

  forestResponce:ForestResponce;
  contractNo;
  customerId1;
  productId1;
  transportId1;
  deliveryDate1;
  quality1;
  constructor(public auth: Authentication,
              public router: Router,
              public activatedRoute: ActivatedRoute) {
              activatedRoute.params.subscribe(data => {
                this.contractNo = data.contract_no;
              });
              activatedRoute.queryParams.subscribe(data => {
                this.contractNo=data.contract_no;
                this.customerId1 = data.customer_id;
                this.productId1 = data.product_id;
                this.transportId1 = data.transport_id;
                this.deliveryDate1 = data.delivery_date;
                this.quality1 = data.quality;
              });
             }

  ngOnInit() {
  }
  updateContractDetails(form:NgForm){
    this.auth.updateContract(form.value).subscribe(responce => {
      this.forestResponce = responce;
      console.log(responce);
      if (this.forestResponce.statusCode === 201) {
        form.reset();
        this.router.navigateByUrl('/getcontract');
      }
    });

  }

}
