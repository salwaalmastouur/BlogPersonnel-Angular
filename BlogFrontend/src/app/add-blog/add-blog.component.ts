import { Component, OnInit } from '@angular/core';
import { Blog } from '../Blog';
import { BlogService } from '../blog.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-blog',
  templateUrl: './add-blog.component.html',
  styleUrls: ['./add-blog.component.scss']
})
export class AddBlogComponent implements OnInit {
public blog: Blog = new class implements Blog{
  id:number;
  author:string;
  date: Date;
  title:string;
  content:string;
}
  constructor(public blogS:BlogService, public router:Router) { }

  ngOnInit() {
   

  }
  addBlog() {
    console.log(this.blog);
    if (this.blog.title != null && this.blog.content != null) {
      if (this.blog != null) {
        this.blog.date = new Date();
        this.blogS.addBlog(this.blog).subscribe(data => {

          alert('New Blog Added Successfully');
          this.router.navigate(['myblogs']);
        });
      }
    } else {
      alert('Please fill all the details carefully.');
    }
  
  } 
}
