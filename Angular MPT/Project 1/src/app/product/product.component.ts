import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product:Product[]
  constructor(public http:HttpClient) {
    this.getProduct();
   }

  ngOnInit() {
  }

  getProduct(){
    this.http.get<Product[]>('../../assets/product.json').subscribe(response =>{
      console.log(response);
      this.product=response;
    });
  }
 

}
