import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
    providedIn: 'root'
})
export class Authentication {

    selectedLandToUpdate: Land;
    selectedProductUpdate: Product;
    selectedProductForContract: Product;
    selectedContractUpdate: Contract;

    api = `http://localhost:8080`;

    constructor(public http: HttpClient) {

    }

    loginuser(user): Observable<any> {
        return this.http.post<any>(`${this.api}/auth`, user);
    }

    register(user): Observable<any> {
        return this.http.post<any>(`${this.api}/addaccount`, user);
    }

    getaccount(): Observable<any> {
        return this.http.get<any>(`${this.api}/getlistaccount`);
    }

    deleteaccount(account): Observable<any> {
        return this.http.post<any>(`${this.api}/deleteaccount`, account);
    }

    updateaccount(account): Observable<any> {
        return this.http.put<any>(`${this.api}/updateaccount`, account);
    }



    getContract(): Observable<any> {
        return this.http.get<any>(`${this.api}/listofcontract`);
    }

    addContract(contract): Observable<any> {
        return this.http.post<any>(`${this.api}/addcontract`, contract);
    }

    updateContract(contract): Observable<any> {
        return this.http.post<any>(`${this.api}/updatecontract`, contract);
    }

    deleteContract(contract: Contract) {
        return this.http.delete<any>(`${this.api}/deletecontract/${contract.contract_no}`);
    }

    addProduct(product): Observable<any> {
        return this.http.post<any>(`${this.api}/addproduct`, product);
    }

    getProduct(): Observable<any> {
        return this.http.get<any>(`${this.api}/getallproduct`);
    }

    updateProduct(product): Observable<any> {
        return this.http.post<any>(`${this.api}/updateproduct`, product);
    }

    deleteProduct(product: Product): Observable<any> {
        return this.http.delete<any>(`${this.api}/deleteprodct/${product.product_id}`);
    }


    getLand(): Observable<any> {
        return this.http.get<any>(`${this.api}/getland`);
    }

    addLand(land): Observable<any> {
        return this.http.post<any>(`${this.api}/addland`, land);
    }

    deleteLand(land: Land): Observable<any> {
        return this.http.delete<any>(`${this.api}/deleteland/${land.number}`);
    }

    updateLand(land): Observable<any> {
        return this.http.post<any>(`${this.api}/updateland`, land);
    }

    statusContract(contract: Contract): Observable<any> {
        return this.http.post<any>(`${this.api}/statusContract`, contract);
    }

}
