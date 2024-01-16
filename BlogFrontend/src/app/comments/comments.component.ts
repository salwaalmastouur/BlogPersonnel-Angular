import { Component, OnInit } from '@angular/core';
import { CommentService } from '../comment.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { BlogService } from '../blog.service';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {
  public commentList;
  public blogData;
  public isComment;
  public user = sessionStorage.getItem("username");
  constructor(public coms:CommentService, public route:ActivatedRoute,public blogS:BlogService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((params:ParamMap) => {
      const id = parseInt(params.get('id'));
      this.coms.showComment(id).subscribe(data=>{
        this.commentList = data;
        if(this.commentList.length>0)
        this.isComment = true;
        else
        this.isComment = false;
        this.blogS.getBlogById(id).subscribe(data=>{
          this.blogData = data;
          console.log(this.blogData);
        })
        console.log(this.commentList);
      })
    })
  }
deleteComment(id)
{
  return this.coms.deleteComments(id).subscribe(data=>{
    alert(data);
    this.ngOnInit();
  })
}
}
