import { Component, OnInit } from '@angular/core';
import { Router, Params, ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { empty } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  employee : Employee;
  message: string = "";

  isLogin:boolean = false;
  isNotLogin:boolean = true;

  isFound:boolean = false;
  isNotFound:boolean = true;

  value: any;
  empId: number;

  constructor(private routerObj : Router, private employeeService: EmployeeService, private _routeParam: ActivatedRoute) { }

  handleSubmit(info: any) {
    console.log("Handle function working");

    this.employeeService.getEmpDetailsById(this.empId)
    .subscribe(
                  (data:any) => {
                  console.log("handlesubmit emp detail by id");
                  this.isFound=true;
                  this.isNotFound=false;
                  this.employee=data;
                  console.log(data);
                  if ( (this.isFound && !this.isNotFound) && ( this.empId == this.employee.empId && info.pwd == this.employee.empPhoneNo)) {
                    this.isLogin = true;
                    this.isNotLogin = false;
                    this.routerObj.navigate(["dashboard", this.empId]);
                  } else {
                    this.message = "Sorry Employee id or Password is incorrect";
                  }
    },
    (err) => {
      this.isFound = false;
      this.isNotFound = true;
      console.log("Cant read");
    });

   

    // for (var _i = 0; _i < this.empIds.length; _i++) {
    //   if(info.empId == this.empIds[_i]) {
    //     if(info.pwd == this.pwds[_i]) {
    //       localStorage.setItem("empId", ""+this.empIds[_i]);
    //       localStorage.setItem("pwd", this.pwds[_i]);
    //       console.log(localStorage.getItem("empId"));
    //       console.log(localStorage.getItem("pwd"));
    //       this.isLogin = true;
    //       this.isNotLogin = false;
    //       this.routerObj.navigate(["navigate/options"]);
    //       break; 
    //     }
    //   }
    // }
    if(!this.isLogin && this.isNotLogin) {
      this.message = "Sorry Employee id or Password is incorrect";
    }
    // if(info.empId == "1000" && info.pwd == "12345") {
    //   this.routerObj.navigate(["menu/listAllEmployeeDetails"]);
    // }
  }

  ngOnInit() {
    this.value = this._routeParam.params.subscribe((params:Params) => {
      this.empId = params["empId"];
    });
  }

}
