import { Component, OnInit } from '@angular/core';
import { LeaveDetails } from  '../leavedetails';
import { LeaveDetailsService } from '../leavedetails.service';
import { Params, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-view-pending-leave',
  templateUrl: './view-pending-leave.component.html',
  styleUrls: ['./view-pending-leave.component.css']
})
export class ViewPendingLeaveComponent implements OnInit {
  isFound : boolean = false;
  isNotFound : boolean = false;
  leavedetails :LeaveDetails[];
  errorMessage:string;
  value: any;
  empId: number;
  leaveid:number;
  renderApproveOrDeny : boolean = false;
  constructor(private leaveService :LeaveDetailsService, private _routeParam: ActivatedRoute) {
   }

  sendLeaveId(value: number): void {
    console.log("Leave id is ");
    console.log(value);
    this.leaveid = value;
    this.renderApproveOrDeny = true;
  }

  ngOnInit() {
    this.value = this._routeParam.params.subscribe((params:Params) => {
      this.empId = params["empId"];
    });

    this.leaveService.getPendingleavefromserver(this.empId)
    .subscribe(
                  (data:any) => {
                   this.isFound=true;
                    this.isNotFound=false;
                    this.leavedetails=data;
    },
    (err) => {
      this.isFound = false;
      this.isNotFound = true;
      this.errorMessage = "There is no Pending leave applications.";
      console.log(this.errorMessage);
    }
    );
  }
 
}
