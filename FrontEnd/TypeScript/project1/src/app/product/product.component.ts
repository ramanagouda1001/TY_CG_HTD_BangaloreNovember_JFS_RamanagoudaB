import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor(public data: DataService) { }
    deleteLateComer(name){
    this.data.products.splice(this.data.products.indexOf(name),1);
  }
  ngOnInit() {
  }
}
