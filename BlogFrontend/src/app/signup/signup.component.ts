import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';
import { User } from 'User';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  public user: User  = new class implements User{
    id: number;
    active: boolean;
    email: string;
    gender: string;
    mobileNo: number;
    name: string;
    password: string;
    role: string;
  }
  constructor(public register: RegistrationService, public router: Router ) { }

  ngOnInit() {
  }
  alertUser(){
    this.register.addUsers(this.user).subscribe(data=>{
      alert("Registered!");
     this.router.navigate(['login']);
    })
   
  }
}
