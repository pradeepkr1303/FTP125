export class LeaveDetails {
    leaveId: number;
    leaveType: string;
    startDate: Date;
    endDate: Date;
    noOfDays: number;
    leaveStatus: string;
    reason: string;
    managerComments: string;
    emplId: number;
    message: string;
    constructor (leaveId: number, leaveType: string, startDate: Date,  endDate: Date, noOfDays: number, leaveStatus: string,
            reason: string, managerComments: string, emplId: number, message: string) {
        this.leaveId = leaveId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfDays = noOfDays;
        this.leaveStatus = leaveStatus;
        this.reason = reason;
        this.emplId = emplId;
        this.message = message;
    }
}



