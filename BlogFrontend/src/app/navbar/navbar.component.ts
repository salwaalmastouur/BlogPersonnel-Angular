import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  user:any;
  isAdmin: string;
  public  uName:string;
  constructor(public regS:RegistrationService, public loginService:AuthenticationService) { }

 
  ngOnInit() {
    this.regS.getUser().subscribe(data=>{
      this.user = data;
      this.uName= this.user.name;
      this.isAdmin = this.user.role;
      console.log(this.isAdmin);

    })
  }
}
