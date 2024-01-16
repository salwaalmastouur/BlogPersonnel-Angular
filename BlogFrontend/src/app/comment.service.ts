import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  addComment(comment, id) {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.post('http://localhost:2019/addComments/' + id, comment, {headers});
  }
  showComment(id) {
    return this.http.get('http://localhost:2019/showComments/' + id);
  }
  deleteComments(id)
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.delete('http://localhost:2019/deleteComment/' + id,{headers});
  }
}
