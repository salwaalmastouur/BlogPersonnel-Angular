import { Component, OnInit } from '@angular/core';
import { BlogService } from '../blog.service';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-show-blog',
  templateUrl: './show-blog.component.html',
  styleUrls: ['./show-blog.component.scss']
})
export class ShowBlogComponent implements OnInit {
  public blogs;
  public searchUser;
  public following;
  public searchData;
  public isData=true;
  constructor(private blog:BlogService,private loginService:AuthenticationService, private router:Router,private userS:UserServiceService) { }

  ngOnInit() {
    this.blog.getBlog().subscribe(data=> {
      this.blogs = data;
      Object.assign(this.blogs).reverse();
      console.log(data);
    })
    this.blog.showFollowings().subscribe(data=>{
      this.following = data;
      console.log(this.following);
    })
  }
  edit(blog)
  {
    this.router.navigate(['editBlogC', blog.postId]);
  }
  showBlogById(id)
  {
    this.router.navigate(['showBlog',id]);
  }
  checkUser(email)
  {
   for(var i = 0;i<this.following.length;i++)
   {
     if(email===this.following[i].followingId.email)
     return true;
   }
   return false;
  }
  findUser(){
    this.userS.searchUser(this.searchUser).subscribe(data=>{
      this.searchData = data;
      if(this.searchData.length>0)
      this.isData = true;
      else
      this.isData = false;
    })
  }
  openUser(id)
  {
    this.router.navigate(['showProfile',id]);
  }
}
