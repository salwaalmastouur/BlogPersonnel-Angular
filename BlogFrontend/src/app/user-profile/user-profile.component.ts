import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  userss : any;
  public  name;
  public  mobileNo;
  public email;
  public password;
  public M;
  public E;
  public A;
  public G;
  public R;
  public N;
  constructor(private regS: RegistrationService, private router:Router) { }

  ngOnInit() {
    this.regS.getUser().subscribe(data=>{

      this.userss = data;
      this.name = this.userss.name;
      this.email = this.userss.email;
      this.mobileNo = this.userss.mobileNo;
      this.password = this.userss.password;
      this.M=this.userss.mobileNo;
      this.E= this.userss.email;
      this.A=this.userss.address;
      this.G=this.userss.gender;
      this.R = this.userss.role;
      this.N = this.userss.name;
      
    })
  }
  editUser(){
    this.regS.editUser(this.userss).subscribe(data=>{
      this.ngOnInit();
    })
  }
}
