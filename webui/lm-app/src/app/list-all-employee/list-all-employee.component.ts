import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';
import {EmployeeService} from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-all-employee',
  templateUrl: './list-all-employee.component.html',
  styleUrls: ['./list-all-employee.component.css']
})
export class ListAllEmployeeComponent implements OnInit {

  constructor(private employeeService: EmployeeService, private routerObj : Router) { }

  employees: Employee[];

  getEmployees(): void {
    this.employeeService.getEmployees().subscribe(data=>this.employees=data,err=>console.log(err));
  }

  handleSubmit(empId: number): void {
    //console.log(empId);
    this.routerObj.navigate(["login", empId]);
  }

  ngOnInit(): void {
    this.getEmployees();
  }

}
