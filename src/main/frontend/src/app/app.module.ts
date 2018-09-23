import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { RegisterSuccessComponent } from './registrationsuccessful/registersuccess.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {UserService} from './user.service';
import { HttpClientModule } from '@angular/common/http'; 
import {LoginComponent} from './login/login.component';
import {LoginSuccessComponent} from './loginsuccessful/loginsuccess.component';
import {LoginFailComponent} from './loginfailed.component';
import {ViewNotesComponent} from './viewnotes/viewnotes.component';

const routes: Routes = [
  { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent }, 
  { path : 'registrationsuccessful', component : RegisterSuccessComponent },
  { path : 'loginsuccessful/:id', component : LoginSuccessComponent },
  { path : 'loginfailed', component : LoginFailComponent },
  { path : 'viewnotes', component : ViewNotesComponent }
];

@NgModule({
  declarations: [
    AppComponent,
      RegisterComponent,
      RegisterSuccessComponent,
      LoginComponent,
      LoginSuccessComponent,
      LoginFailComponent,
      ViewNotesComponent
  ],
  imports: [
    BrowserModule,
      RouterModule.forRoot(routes),
      FormsModule, ReactiveFormsModule,
      HttpClientModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
