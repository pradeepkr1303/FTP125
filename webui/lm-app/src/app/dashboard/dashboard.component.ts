import { Component, OnInit } from '@angular/core';
import { Params, ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  value: any;
  empId: number;
  employee: Employee;

  isFound: boolean = false;
  isNotFound: boolean = true;

  constructor(private _routeParam: ActivatedRoute, private employeeService: EmployeeService) { }

  ngOnInit() {
    this.value = this._routeParam.params.subscribe((params:Params) => {
      this.empId = params["empId"];
    });

    this.employeeService.getEmpDetailsById(this.empId)
    .subscribe(
                  (data:any) => {
                  this.isFound=true;
                  this.isNotFound=false;
                  this.employee=data;
    },
    (err) => {
      this.isFound = false;
      this.isNotFound = true;
      console.log("Cant read");
    });
  }
}

