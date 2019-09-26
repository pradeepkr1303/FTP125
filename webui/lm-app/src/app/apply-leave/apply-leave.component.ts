import { Component, OnInit } from '@angular/core';
import { LeaveDetails } from 'src/app/leaveDetails';
import { LeaveDetailsService } from 'src/app/leaveDetails.service';
import { Params, ActivatedRoute} from '@angular/router';



@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css'],
  providers: [ LeaveDetailsService ]
})
export class ApplyLeaveComponent implements OnInit {
  isApplied: boolean = false;
  isNotApplied: boolean = false;
  leaveDetails: LeaveDetails;
  errorMessage: String;
  successMessage: String;

  value: any;
  emplId: number;

  // emplId: string;
  // startDate: string;
  // endDate: string;
  // leaveType: String;
  // reason: String;
  // message: String;

  constructor(private applyLeaveObj: LeaveDetailsService, private _routeParam: ActivatedRoute) { }

  handleSubmit(values: any) {
    console.log("handleSubmit() values");
    values.emplId = this.emplId;
    console.log(values.emplId);
    this.applyLeaveObj.applyLeaveInServer(values).subscribe (
      (data: any) => {
                      this.isApplied = true;
                      this.isNotApplied = false;
                      this.successMessage = data.message;
                      console.log(this.successMessage);
      },
      (err) => {
        this.isApplied = false;
        console.log(err);
        this.isNotApplied = true;
        this.errorMessage = err.error.message;
      }
    );
  }
  // handleReset() {
  //   this.emplId = '';
  //   this.startDate = '';
  //   this.endDate = '';
  //   this.leaveType = '';
  //   this.reason = '';
  // }
  ngOnInit() {
    this.value = this._routeParam.params.subscribe((params:Params) => {
      this.emplId = params["empId"];
    });
  }

}

