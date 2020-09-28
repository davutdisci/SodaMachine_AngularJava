import { Injectable } from '@angular/core';
import { ApiExecutor } from './api-executor';
import { Observable } from 'rxjs';
import { IProduct } from '../models/i-product';

@Injectable({
    providedIn: 'root'
})
export class ProductApi {

    public url = 'http://localhost:8080/api/';

    constructor(private apiExecutor: ApiExecutor) {
    }

    public getProducts(): Observable<IProduct[]> {
        let url = this.url + 'get-all-products';
        return this.apiExecutor.getData(url);
    }

    public dispenseProduct(dispensedProduct, couponCode?): Observable<any> {
        let url = this.url + 'dispense-product';
        
        //header parameter to check the coupon code
        let params = { couponCode: couponCode }
        return this.apiExecutor.updateData(url, dispensedProduct, params);
    }

}