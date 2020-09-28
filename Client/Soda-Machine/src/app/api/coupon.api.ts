import { Injectable } from '@angular/core';
import { ApiExecutor } from './api-executor';
import { Observable } from 'rxjs';
import { ICouponCode } from '../models/i-coupon-code';


@Injectable({
    providedIn:'root'
})
export class CouponApi{

    public url = 'http://localhost:8080/api/';

    constructor(private apiExecutor: ApiExecutor ){
    }

    public getCouponCode(couponCode: string):Observable<ICouponCode[]>{
        let url = this.url + `get-coupon-code`;
        let params ={couponCode: couponCode};
        return this.apiExecutor.getData(url,params);
    }
}