import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';
import { Customer } from '../customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
  cust : Customer;
  constructor(private router: Router, private userService:BankServiceService) { 
    this.cust=new Customer();
  }
  
  ngOnInit() {
 
  }

onSubmit(cust: Customer)
{
  this.userService.addCustomer(this.cust).subscribe(result=>{
    console.log(result);
    this.gotoLogin();
  });
}
gotoLogin()
{
  this.router.navigate(['/loginComponent']);
}

newCustomer(mobile,name,password){
  this.cust.customer_name=name;
  this.cust.customer_pswd=password;
  this.cust.customer_phn_num=mobile;
  this.cust.customer_Acc_bal=0;
  this.onSubmit(this.cust);
}
}
