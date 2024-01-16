import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AddBlogComponent } from './add-blog/add-blog.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthguardService } from './authguard.service';
import { ShowBlogComponent } from './show-blog/show-blog.component';
import { EditBlogComponent } from './edit-blog/edit-blog.component';
import { MyblogsComponent } from './myblogs/myblogs.component';
import { BlogPageComponent } from './blog-page/blog-page.component';
import { DifferentUserProfileComponent } from './different-user-profile/different-user-profile.component';
import { CommentsComponent } from './comments/comments.component';

export const MAIN_ROUTES: Routes = [
    {
      path: "",
      redirectTo: 'home',
      pathMatch: 'full',
    },
    {
      path: "home",
      component: HomeComponent,
    },
    {
      path:"login",
      component:LoginComponent
    },
    {
      path:"signup",
      component:SignupComponent
    },
    {
      path:"addBlog",
      component: AddBlogComponent
    },
    {
      path:"profile",
      component: UserProfileComponent
    },
    {
      path:"logout",
      component:LogoutComponent,
      canActivate:[AuthguardService]
    },
    {
      path:"blog",
      component:ShowBlogComponent
    },
    {
      path:"editBlogC/:id",
      component:EditBlogComponent
    },
    {
      path:"myblogs",
      component:MyblogsComponent
      
    },
    {
      path:"showBlog/:id",
      component:BlogPageComponent
    }
    ,
    {
      path:"showProfile/:id",
      component:DifferentUserProfileComponent
    },
    {
      path:"showComments/:id",
      component:CommentsComponent
    }
]