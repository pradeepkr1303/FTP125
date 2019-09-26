import { Component, OnInit } from '@angular/core';
import { Router, Params, ActivatedRoute } from '@angular/router';;
import { LeaveDetailsService } from 'src/app/leavedetails.service';
import { LeaveDetails } from 'src/app/leavedetails'

@Component({
  selector: 'app-check-leave-status',
  templateUrl: './check-leave-status.component.html',
  styleUrls: ['./check-leave-status.component.css']
})
export class CheckLeaveStatusComponent implements OnInit {
  isFound : boolean = false;
  isNotFound : boolean = false;
  leaveDetails : LeaveDetails[];
  errorMessage : string;
  value: any;
  empId: number;
  ceoOrNot : boolean = false;

  constructor(private routerObject:Router, private leaveDetailsService:LeaveDetailsService, private _routeParam: ActivatedRoute) { }

  ngOnInit() {
    this.value = this._routeParam.params.subscribe((params:Params) => {
      this.empId = params["empId"];
    });

    if(this.empId == 1000) {
      this.ceoOrNot = true;
    }

    this.leaveDetailsService.getLeaveStatusfromServer(this.empId).subscribe(
      (data:any) => {
        this.isFound = true;
        this.isNotFound = false;
        this.leaveDetails = data;
      },
      (err) => {
        this.isFound = false;
        this.isNotFound = true;
        this.errorMessage = err.error.message;
        console.log(this.errorMessage);
      }
    );
  }

}
