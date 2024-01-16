import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { BlogService } from '../blog.service';

@Component({
  selector: 'app-different-user-profile',
  templateUrl: './different-user-profile.component.html',
  styleUrls: ['./different-user-profile.component.scss']
})
export class DifferentUserProfileComponent implements OnInit {

  public blog;
  public user;
  public isFollowing;
  public userId;
  public isData;
  constructor(private userS:UserServiceService,private route:ActivatedRoute, private router:Router, private blogS:BlogService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((params:ParamMap)=>{
      const id = parseInt(params.get('id'));
      this.userS.getUserByUserId(id).subscribe(data=>{
        this.user = data;
        this.userId = this.user.userId;
        if(this.user.email === sessionStorage.getItem('username'))
        this.router.navigate(['profile']);
        else{
        this.userS.checkUserIfFollowing(this.user.userId).subscribe(data=>{
          this.isFollowing = data;
          this.router.navigate(['showProfile',this.userId])
          if(this.isFollowing==='true')
      {
        this.blogS.getBlogByFollowingUserId(this.userId).subscribe(data=>{
            this.blog = data;
          console.log(data);
            if(this.blog.length>0)
            {
                this.isData = true;
    
            }
            else
            {
              this.isData = false;

            }
          
        })
      }
      
        })
      }
      })
      
    });
    
  }
    follow(id)
    {
      this.userS.followUser(id).subscribe(data=>{
        this.isFollowing = false;
        alert(data);
       this.ngOnInit();
      })
    }
    unfollow(id)
    {
      this.userS.unfollow(id).subscribe(data=>{
        alert(data);
        this.isFollowing = true;
        this.ngOnInit();
      })
    }

    showComments(id)
    {
      this.router.navigate(['showComments',id]);
    }
}
