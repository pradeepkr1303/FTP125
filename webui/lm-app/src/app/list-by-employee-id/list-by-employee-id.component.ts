import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';
import {EmployeeService} from '../employee.service';
import { Params, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-by-employee-id',
  templateUrl: './list-by-employee-id.component.html',
  styleUrls: ['./list-by-employee-id.component.css']
})
export class ListByEmployeeIdComponent implements OnInit {
  isFound:boolean = false;
  isNotFound:boolean = false;
  employee: Employee;
  value : any;
  empId : number;

  constructor(private employeeService: EmployeeService, private _routeParam: ActivatedRoute) { }

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
