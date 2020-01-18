import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
    providedIn: 'root'
})
export class Authentication {

    addItemToList:List;
    updateList:List;
   
    api = `https://jsonplaceholder.typicode.com/posts`;

    constructor(public http: HttpClient) {

    }

    getList(): Observable<any> {
        return this.http.get<any>(`${this.api}`);
    }

    updateAccount(items): Observable<any>{
        return this.http.put<any>(`${this.api}`,items);
    }

   
}
