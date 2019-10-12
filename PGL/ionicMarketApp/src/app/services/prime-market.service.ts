import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};

@Injectable({
  providedIn: 'root'
})
export class PrimeMarketService {

  private url: string = '192.168.1.36';

  constructor(private httpClient: HttpClient) { }

  getRequest(name: String) {
    return this.httpClient.get('http://' + this.url + ':8080/api/getMod/' + name);
  }

  getAllRequest() {
    return this.httpClient.get('http://' + this.url + ':8080/api/getMods');
  }

  postRequest(postData: SendMod) {
    const postDataParams = new HttpParams()
      .set('name', postData.name)
      .set('quantity', postData.quantity.toString());

    return this.httpClient.post<SendMod>('http://' + this.url + ':8080/api/addMod', postDataParams.toString(), httpOptions);
  }

  deleteRequest(name: String) {
    return this.httpClient.delete('http://' + this.url + ':8080/api/removeMod/' + name);
  }

  putRequest(name: String, putData) {
    const putDataParams = new HttpParams()
      .set('name', putData.name)
      .set('quantity', putData.quantity.toString());

    return this.httpClient.put('http://' + this.url + ':8080/api/updateMod/' + name, putDataParams.toString(), httpOptions);
  }
}

export class SendMod {
  name: string;
  quantity: number;
}
