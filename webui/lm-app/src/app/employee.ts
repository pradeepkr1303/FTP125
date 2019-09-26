export class Employee {
    empId: number;
    empName: String;
    empPhoneNo: number;
    empEmail: String;
    empDeptNo: number;
    empLeaveBalance: number;
    empManagerId: number;
    constructor(empId: number, empName: String, empPhoneNo: number, empEmail: String, empDeptNo: number, empLeaveBalance: number, empManagerId: number) {
      this.empId = empId;
      this.empName = empName;
      this.empPhoneNo = empPhoneNo;
      this.empEmail = empEmail;
      this.empDeptNo = empDeptNo;
      this.empLeaveBalance = empLeaveBalance;
      this.empManagerId = empManagerId;
    }
}
