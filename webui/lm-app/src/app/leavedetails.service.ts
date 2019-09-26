import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LeaveDetails } from './leaveDetails';

@Injectable({
  providedIn: 'root'
})
export class LeaveDetailsService {
applyLeaveURL: string;
leaveURL : string;
findURL : string;
approveOrDenyURL : string;
leaveInfo: LeaveDetails;
  constructor(private httpClient: HttpClient) { }
   applyLeaveInServer(value): Observable<any> {
     console.log('apply leave method');
    this.applyLeaveURL = 'http://localhost:8080/FTP125-0.0.1-SNAPSHOT/api/leavedetails/ApplyLeave';
    return this.httpClient.post(this.applyLeaveURL, value);
  }
  getLeaveStatusfromServer(emplId:number) {
    this.leaveURL = 'http://localhost:8080/FTP125-0.0.1-SNAPSHOT/api/leavedetails/GetLeaveStatus/'+emplId;
    return this.httpClient.get(this.leaveURL);
  }
  getPendingleavefromserver(emplId:number) {
    this.findURL = 'http://localhost:8080/FTP125-0.0.1-SNAPSHOT/api/leavedetails/findPendingLeave/'+emplId;
    return this.httpClient.get(this.findURL);
  }
  approveOrDeny(value):Observable<any> {
        this.approveOrDenyURL = 'http://localhost:8080/FTP125-0.0.1-SNAPSHOT/api/leavedetails/approveOrDeny';
    return this.httpClient.put(this.approveOrDenyURL, value);
  }
}
