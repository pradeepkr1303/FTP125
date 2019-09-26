import { Employee } from './employee';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class EmployeeService {
    constructor(private http: HttpClient) {
    }
getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>('http://localhost:8080/FTP125-0.0.1-SNAPSHOT/api/employees');
}
getEmpDetailsById(empId): Observable<Employee> {
    return this.http.get<Employee>('http://localhost:8080/FTP125-0.0.1-SNAPSHOT/api/employees/'+empId);
}
getManagerDetailsfromServer(empId:number) {
    let findURL:string = ("http://localhost:8080/FTP125-0.0.1-SNAPSHOT/api/employees/manager/"+empId);
    return this.http.get(findURL);
} 
}
