import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  constructor(private http: HttpClient) {
  }
  addBlog(blog)
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.post('http://localhost:2019/addBlog', blog, {headers});
  }
  getBlog(){
    return this.http.get('http://localhost:2019/getBlogs');
  }
  getBlogById(id)
  {

    return this.http.get('http://localhost:2019/getBlogById/' + id);
  }
  getBlogByUserId()
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.get('http://localhost:2019/getBlogByUserId', {headers});
  }
  editBlog(blog)
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.post('http://localhost:2019/editBlog', blog, {headers});
  }
  delete(id)
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.delete('http://localhost:2019/deleteBlog/' + id, {headers});
  }
  showFollowers(){
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.get('http://localhost:2019/showFollowers', {headers});
  }
  showFollowings(){
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.get('http://localhost:2019/showFollowing', {headers});
  }
  getUserById(id)
  {
    return this.http.get('http://localhost:2019/getUserById/' + id);
  }
  getBlogByFollowingUserId(id)
  {
    return this.http.get('http://localhost:2019/getBlogByFollowingUserId/' + id);
  }
  makePrivate(blog)
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.get('http://localhost:2019/archivePost/' + blog, {headers});
  }
  removePrivate(id)
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.get('http://localhost:2019/removePrivate/' + id, {headers});
  }
}
