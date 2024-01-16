import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { BlogService } from '../blog.service';

@Component({
  selector: 'app-edit-blog',
  templateUrl: './edit-blog.component.html',
  styleUrls: ['./edit-blog.component.scss']
})
export class EditBlogComponent implements OnInit {
  blog:any;
  public postId;
  public title;
  public content;

  constructor(private router:Router,private blogS:BlogService,private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe((params:ParamMap) =>{
      const id = parseInt(params.get('id'));
      this.postId = id;

    })
    this.blogS.getBlogById(this.postId).subscribe(data=> {
      this.blog = data;
      this.title = this.blog.title;
      this.content = this.blog.content;
    })
  }
  edit(){
    
    this.blogS.editBlog(this.blog).subscribe(data=>{
      this.blog = data;
      alert("Blog Has Been Updated");
      this.router.navigate(['myblogs']);
    })
  }

  delete(postId){
    this.blogS.delete(postId).subscribe(data=>{
      alert("Blog has been Deleted");
      this.router.navigate(['myblogs']);
    })
  }
}
