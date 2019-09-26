import { Component, OnInit } from '@angular/core';
import { Router, Params } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from 'src/app/employee.service';
import { Employee } from 'src/app/employee';

@Component({
  selector: 'app-view-manager-details',
  templateUrl: './view-manager-details.component.html',
  styleUrls: ['./view-manager-details.component.css']
})
export class ViewManagerDetailsComponent implements OnInit {
  isFound : boolean = false;
  isNotFound : boolean = false;
  employee : Employee;
  errorMessage : string;
  value : any;
  empId : number;

  constructor(private routerObject:Router, private employeeService:EmployeeService, private _routeParam : ActivatedRoute) { }

  ngOnInit() {
    this.value = this._routeParam.params.subscribe((params:Params) => {
      this.empId = params["empId"];
    });

    this.employeeService.getManagerDetailsfromServer(this.empId).subscribe(
      (data:any) => {
        this.isFound = true;
        this.isNotFound = false;
        this.employee = data;
      },
      (err) => {
        this.isFound = false;
        this.isNotFound = true;
        this.errorMessage = err.error.message;
        console.log(this.errorMessage);
      }
    );
  }

  ngOnDestroy() {
    this.value.unsubscribe();
  }
}
