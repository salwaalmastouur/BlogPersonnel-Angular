import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BlogService } from '../blog.service';

@Component({
  selector: 'app-myblogs',
  templateUrl: './myblogs.component.html',
  styleUrls: ['./myblogs.component.scss']
})
export class MyblogsComponent implements OnInit {
  public  blog;
  public postId;
  public user;
  public followers;
  public following;
  public isPrivate = false;
  constructor(private router:Router, private Blogs:BlogService) { }

  ngOnInit() {
    this.Blogs.getBlogByUserId().subscribe(data=>{
      this.blog = data;
      Object.assign(this.blog).reverse();
      this.user = this.blog[0].userId.name;
      this.postId = this.blog[0].postId;
      
    })
   this.Blogs.showFollowings().subscribe(data=>{
     this.following = data;
     console.log(this.following);
   })
   this.Blogs.showFollowers().subscribe(data => {
     this.followers = data;
   })
  }
  
  edit(blog){
    this.router.navigate(['editBlogC',blog.postId]);
  }
showProfile(id)
{
  this.router.navigate(['showProfile',id]);
}
showComments(id)
{
 this.router.navigate(['showComments',id]);
}
makePrivate(blog)
{
  this.Blogs.makePrivate(blog).subscribe(data=>{
    alert(data);
    this.isPrivate = true;
    this.ngOnInit();
  })
}
getPrivate(){
  this.Blogs.getBlog().subscribe(data=>{
    this.isPrivate = true;
    this.ngOnInit();
  })
}
getNonPrivate(){
  this.isPrivate = false;
  this.ngOnInit();
}
removePrivate(id)
{
  this.Blogs.removePrivate(id).subscribe(data=>{
    alert(data);
    this.isPrivate = false;
    this.ngOnInit();
  })
}
}
