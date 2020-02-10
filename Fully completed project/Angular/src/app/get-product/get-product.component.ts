import { Component, OnInit } from '@angular/core';
import { Authentication } from '../authentication';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-product',
  templateUrl: './get-product.component.html',
  styleUrls: ['./get-product.component.css']
})
export class GetProductComponent implements OnInit {

  products: Product[];
  selectedProductUpdate: Product;
  forestResponce: ForestResponce;
  constructor(public auth: Authentication,
              public router: Router ) {
    this.getProduct();
  }

  ngOnInit() {
  }

  getProduct() {
    this.auth.getProduct().subscribe( responce => {
        this.products = responce.list;
        console.log(responce);
    });
  }


  deleteProduct(product) {
    this.auth.deleteProduct(product).subscribe(responce => {
      this.forestResponce = responce;
      if (this.forestResponce.statusCode === 201) {
        this.products.splice(this.products.indexOf(product), 1);
      }
    });
  }
  isProduct() {
    const userDetails = JSON.parse(localStorage.getItem('details'));
    if ( userDetails && userDetails.role === 'product') {
      return true;
    } else {
      return false;
    }
  }

  addcontract(product) {
    this.auth.selectedProductForContract = product;
    this.router.navigateByUrl('addcontract');
  }

  updateProduct(product) {
    this.router.navigate([`editproduct/${product.product_id}`],
    {
      queryParams: {product_id: product.product_id, product_name: product.product_name,
        product_date: product.product_date, product_quality: product.product_quality}
    });
  }
}

