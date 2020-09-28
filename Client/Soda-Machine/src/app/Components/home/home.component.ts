import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { SelectItem } from 'primeng/api';
import { PrimeNGConfig } from 'primeng/api';
import { CouponApi } from 'src/app/api/coupon.api';
import { ProductApi } from 'src/app/api/product.api';
import { ICouponCode } from 'src/app/models/i-coupon-code';
import { IProduct } from 'src/app/models/i-product';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {

  public products: IProduct[];
  public productPrice: number;
  public productCode: string;
  public couponCode: string;
  public couponObject: ICouponCode;
  public isCouponCodeValid: boolean = false;

  constructor(
    private _primengConfig: PrimeNGConfig,
    private _productApi: ProductApi,
    private _notificatonService: ToastrService,
    private _couponApi: CouponApi) { }

  // This method is to get the soda types and other products from backend server
  ngOnInit() {
    this._primengConfig.ripple = true;
    this._productApi.getProducts().subscribe(products => {
      this.products = products;
    })
  }
  
  // This is to get the product price based on the productCode
  public OnSearchProduct(inputItem: string) {
    setTimeout(() => {
      let product = this.products.find(product => product.productCode === inputItem)
      product ? this.productPrice = product.productPrice : this.productPrice = null;
    }, 1000)
  }

  // This method is to dispense the product from server and update inventory with coupon
  public DispenseProduct() {
    let dispensedProduct = this.products.find(product => product.productCode === this.productCode);
    this._productApi.dispenseProduct(dispensedProduct, this.isCouponCodeValid ? this.couponObject.couponCode : null).subscribe(result => {
      this._notificatonService.success(`The product ${dispensedProduct.productName} is successfully dispensed`, 'Success', {
        timeOut: 2000
      });
    }, error => {
      this._notificatonService.error(`The product you selected is out of inventory`, 'Error', {
        timeOut: 2000
      });
    })
  }

  // This method is to check the server database if there is a valid copon code
  public ApplyCouponCode() {
    this._couponApi.getCouponCode(this.couponCode).subscribe(result => {
      if (result[0] && result[0].couponCode) {
        this.couponObject = result[0];
        let resultDate = new Date(result[0].endDate);
        let today = new Date;
        //This is to check the expiration of copon code and how many it is used so far
        if (today < resultDate && result[0].couponAmount - result[0].usedAmount > 0) {
          this.isCouponCodeValid = true;
          this._notificatonService.success(`The coupon code is valid and verified`, 'Success', {
            timeOut: 2000
          });
        }

      } else {
        this.couponObject = null;
        this.isCouponCodeValid = false;
        this._notificatonService.error(`The coupon code is not verified`, 'Error', {
          timeOut: 2000
        });
      }

    })
  }
}
