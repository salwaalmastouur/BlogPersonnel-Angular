import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) { }

  getUserByUserId(id)
  {
    return this.http.get('http://localhost:2019/user/' + id);
  }
  checkUserIfFollowing(id)
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.get('http://localhost:2019/checkUser/' + id, {headers});
  }
  followUser(id)
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.get('http://localhost:2019/followUser/' + id, {headers});
  }
  unfollow(id)
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.delete('http://localhost:2019/Unfollow/' + id, {headers});
  }
  searchUser(user)
  {
    const headers = new HttpHeaders({Authorization: sessionStorage.getItem('basicAuth')});
    return this.http.get('http://localhost:2019/searchUser/' + user, {headers});
  }
}
