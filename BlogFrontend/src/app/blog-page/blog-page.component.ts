import { Component, OnInit } from '@angular/core';
import { BlogService } from '../blog.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Comments } from '../Comments';
import { CommentService } from '../comment.service';

@Component({
  selector: 'app-blog-page',
  templateUrl: './blog-page.component.html',
  styleUrls: ['./blog-page.component.scss']
})
export class BlogPageComponent implements OnInit {
  public postId;
  public blog;
  public commentList;
  public count;
  public currentUser = sessionStorage.getItem("username");
  public comments:Comments = new class implements Comments{
    commentId:number;
    commentContent:string;
    date:Date;
  }
  constructor(public blogS:BlogService, public route:ActivatedRoute,public router:Router, public commS:CommentService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((params:ParamMap)=>{
      const id = parseInt(params.get('id'));
      this.postId = id;
    })
    this.blogS.getBlogById(this.postId).subscribe(data=>{
      this.blog = data;
    })
   this.commS.showComment(this.postId).subscribe(data=>{
     this.commentList = data;
     Object.assign(this.commentList).reverse();
     console.log(this.commentList);
    this.count = this.commentList.length;
   })
 

  }
  showProfile(id)
  {
    this.router.navigate(['showProfile',id]);
  }
  addComment(){
  
    if(this.comments.commentContent!=null)
    {
      this.comments.date = new Date(); 
      this.commS.addComment(this.comments,this.postId).subscribe(data=>{
        alert("Comment Added Successfully");
        this.ngOnInit();
      })
    }
  }
  deleteComment(commentId)
    {
        this.commS.deleteComments(commentId).subscribe(data=>{
          alert(data);
          this.ngOnInit();
        })
    }
}
