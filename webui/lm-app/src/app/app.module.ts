import { BrowserModule} from '@angular/platform-browser'
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { ListAllEmployeeComponent } from './list-all-employee/list-all-employee.component';
import { ListByEmployeeIdComponent } from './list-by-employee-id/list-by-employee-id.component';
import { LoginComponent } from './login/login.component';
import { NavigateComponent } from './navigate/navigate.component';
import { OptionsComponent } from './options/options.component';

import { ApplyLeaveComponent } from './apply-leave/apply-leave.component';
import { ViewManagerDetailsComponent } from './view-manager-details/view-manager-details.component';
import { CheckLeaveStatusComponent } from './check-leave-status/check-leave-status.component';
import { ApproveOrdenyComponent } from 'src/app/approve-ordeny/approve-ordeny.component';
import { ViewPendingLeaveComponent } from './view-pending-leave/view-pending-leave.component';
import { DashboardComponent } from './dashboard/dashboard.component';

let appRoutes: Routes = [
  {path:"", component:ListAllEmployeeComponent},
  {path:"login/:empId", component:LoginComponent},
  {path:"dashboard/:empId", component:DashboardComponent},
  {path:"listById", component:ListByEmployeeIdComponent}
];



@NgModule({
  declarations: [
    AppComponent, ListAllEmployeeComponent, ListByEmployeeIdComponent, LoginComponent,
    OptionsComponent, ApplyLeaveComponent, ViewManagerDetailsComponent, CheckLeaveStatusComponent,
    ApproveOrdenyComponent, ViewPendingLeaveComponent, NavigateComponent, DashboardComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
