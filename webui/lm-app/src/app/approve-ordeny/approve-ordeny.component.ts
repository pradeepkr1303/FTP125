import { Component, OnInit } from '@angular/core';
import {LeaveDetailsService} from '../leavedetails.service'
import { LeaveDetails } from 'src/app/leavedetails';
import { HttpClientModule} from '@angular/common/http';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Input } from '@angular/core'


@Component({
  selector: 'app-approve-ordeny',
  templateUrl: './approve-ordeny.component.html',
  styleUrls: ['./approve-ordeny.component.css']
})
export class ApproveOrdenyComponent implements OnInit {
  leavedetails:LeaveDetails;
  leavedetail:LeaveDetails;
  isFound : boolean = false;
  isNotFound : boolean = false;
  errorMessage:String;
  success:String;
  approve:boolean = false;
  deny:boolean = false;

  @Input()
  leaveId : number;
  value: any;
  empId: number;


  constructor(private leaveService:LeaveDetailsService, private _routeParam: ActivatedRoute, private routerObj : Router) { 
   
  }

  handleClick(value : any) {
    console.log(value.leaveId);
    value.leaveId = this.leaveId;
    this.leaveService.approveOrDeny(value)
    .subscribe(
                  (data:LeaveDetails) => {
                   console.log("handleClick");
                   this.deny=false;
                    this.approve=true;
                    this.leavedetail=data;
                    this.success=data.message;
                    console.log(this.success);
    },
    (err) => {
      this.approve = false;
      this.deny = true;
      this.errorMessage = err.error.message;
      console.log(this.errorMessage);
      this.routerObj.navigate(["dashboard", this.empId]);
    }
    );
  }
  ngOnInit() {
    
    this.value = this._routeParam.params.subscribe((params:Params) => {
      this.empId = params["empId"];
      
    });

    this.leaveService.getPendingleavefromserver(this.empId)
    .subscribe(
                  (data:any) => {
                   console.log("handlesubmit");
                   this.isFound=true;
                    this.isNotFound=false;
                    this.leavedetails=data;
                    console.log(data);
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
