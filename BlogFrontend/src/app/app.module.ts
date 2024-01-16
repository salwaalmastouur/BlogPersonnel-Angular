import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import {FormsModule} from '@angular/forms';
import { AddBlogComponent } from './add-blog/add-blog.component';
import { HttpClientModule } from '@angular/common/http';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { LogoutComponent } from './logout/logout.component';
import { ShowBlogComponent } from './show-blog/show-blog.component';
import { EditBlogComponent } from './edit-blog/edit-blog.component';
import { MyblogsComponent } from './myblogs/myblogs.component';
import { BlogPageComponent } from './blog-page/blog-page.component';
import { DifferentUserProfileComponent } from './different-user-profile/different-user-profile.component';
import { CommentsComponent } from './comments/comments.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    AddBlogComponent,
    UserProfileComponent,
    LogoutComponent,
    ShowBlogComponent,
    EditBlogComponent,
    MyblogsComponent,
    BlogPageComponent,
    DifferentUserProfileComponent,
    CommentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
