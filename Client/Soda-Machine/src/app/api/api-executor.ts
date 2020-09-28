import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class ApiExecutor {
    constructor(private _httpExecutor: HttpClient) {
    }

    public postData(url, data): Observable<any> {
        return this._httpExecutor.post(url, data);
    }

    public getData(url, params?) {
        let options = { params: params };
        return this._httpExecutor.get<any>(url, options).pipe(map(data => {
            return data;
        }));
    }

    public updateData(url, data, params?): Observable<any> {
        let options = { params: params };
        return this._httpExecutor.put(url, data, options);
    }

}