import { Injectable } from '@angular/core';
import { Customer } from './customer';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class BankServiceService {
  
  mobile : Customer={customer_phn_num:0,customer_pswd:"",customer_Acc_bal:0,customer_name:""};
  customer:Customer;
mobilenumber:number;
 b:number;
  constructor(private httpClient:HttpClient) { 
    
  }
  addCustomer(cust :Customer ): Observable<boolean>
  {
  return this.httpClient.post<boolean>('http://localhost:9090/minipaytm/',cust);
  }
  login(username, password): Observable<Customer>
  {
      this.mobile.customer_phn_num=username;
      this.mobile.customer_pswd = password;
      let url = 'http://localhost:9090/minipaytm/login';
     return  this.httpClient.post<Customer>(url,this.mobile);
    }
    showbalance():Observable<number>
    {
      let url = 'http://localhost:9050/showbal/'+this.mobilenumber;
      
      return this.httpClient.get<number>(url);
      }
      deposit(amount):Observable<number>
      {
        let url = 'http://localhost:9090/minipaytm/deposit/'+amount;
        return this.httpClient.put<number>(url,this.customer);
        }
        withdraw(amount)
        {
          let url = 'http://localhost:9050/withdrawl/'+this.mobilenumber+'/'+amount;
          return this.httpClient.put<number>(url,""); 
        }
        fundTransfer(destination: string,amount: string):Observable<string>
        {
          let url = 'http://localhost:9050/Transfer/'+this.mobilenumber+'/'+destination+'/'+amount;
          return this.httpClient.put<string>(url,""); 
        }

        getTransactionsByAccountNo():Observable<string[]>{
          let url = 'http://localhost:9050/getTransactions/all/'+this.mobilenumber;
          console.log(url);
          return this.httpClient.get<string[]>(url);
          }
 getAccountNumber(){
    return this.mobilenumber;
  }

  setMobileNumber(mobilenumber:number){
    this.mobilenumber=mobilenumber;
  }
  setCustomer(cust:Customer){
      this.customer=cust;
  }
  getCustomer(){
    return this.customer;
}
}
