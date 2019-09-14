import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {

  constructor(private router: Router, private userService: BankServiceService) { }
  amont: number;
  ngOnInit() {
  }
  deposit(amount: any) {

this.userService.deposit(amount).subscribe(data => {
  this.amont = data;
    });

}

}
