import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../User';
import {UserService} from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    
    username : string;
    password : string;
     loginForm: FormGroup;
    loading = false;
    submitted = false;
    constructor(private formBuilder: FormBuilder,
        private router: Router,private userService : UserService){
        }
    
     ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(6)]]
        });
    }
    
    onSubmit(){
        this.userService.loginUser(this.loginForm.value.username).subscribe(response=> 
        {
           this.username=response.username;
            this.password=response.password;
            if(this.username==this.loginForm.value.username && this.password==this.loginForm.value.password){
            this.router.navigate(['/loginsuccessful',this.username]);
             console.log("login success");   
            }
            else
                {
                console.log("login failed");
                this.router.navigate(['/loginfailed']);
                }
            
            });
        
}
    
    }
