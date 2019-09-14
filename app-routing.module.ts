import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateAccountComponent } from './create-account/create-account.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { DepositComponent } from './deposit/deposit.component';
import { PrintTransactionComponent } from './print-transaction/print-transaction.component';
import { ShowBalanceComponent } from './show-balance/show-balance.component';
import { HomeComponent } from './home/home.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: 'createaccount', component: CreateAccountComponent },
  { path: 'fundtransfer', component: FundTransferComponent },
  { path: 'deposit', component: DepositComponent },
  { path: 'printtransaction', component: PrintTransactionComponent },
  { path: 'showbalance', component: ShowBalanceComponent },
  { path: 'withdraw', component: WithdrawComponent  },
  { path: 'homecomponent', component: HomeComponent},
  { path: 'loginComponent', component: LoginComponent},
  { path:'',redirectTo:'loginComponent', pathMatch:'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
