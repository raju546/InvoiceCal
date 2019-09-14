import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { Router } from '@angular/router';
import { BankServiceService } from '../bank-service.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  customer: Customer;
  mobile:number;
  password:String;
  constructor(private router: Router, private userService:BankServiceService) { 
    
  }
    
  ngOnInit() {
 
  }

  loginForm= new FormGroup(
    {
      userMobileNo: new FormControl(),
      userPassword: new FormControl()
    }
  );

  onSubmit(loginForm:FormGroup)
  {
    console.log("login");
    this.mobile=this.loginForm.controls['userMobileNo'].value;
    this.password=this.loginForm.controls['userPassword'].value;
    this.userService.login(this.mobile,this.password).subscribe(data=>{
      this.customer=data;
      this.userService.setCustomer(data);
      if(data != null)
      this.router.navigate(['/homecomponent']);
      else
      alert("Wrong credentials");
      });
  
  }

}
