import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer:Customer[]
  constructor(public http:HttpClient) {
    this.getDataFromJson();
   }

  ngOnInit() {
  }

    getDataFromJson() {
      this.http.get<Customer[]>('../../assets/customer.json').subscribe(response =>{
        console.log(response);
        this.customer=response;
      });
    }
}
