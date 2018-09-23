import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../User';
import {UserService} from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
    
    user : User;
    response : String;
     registerForm: FormGroup;
    loading = false;
    submitted = false;
    constructor(private formBuilder: FormBuilder,
        private router: Router,private userService : UserService){
        this.response=null;
        debugger;
        }
    
     ngOnInit() {
        this.registerForm = this.formBuilder.group({
            firstName: ['', Validators.required],
            lastName: ['', Validators.required],
            username: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(6)]]
        });
    }
    
    onSubmit(){
        this.user= new User(null,this.registerForm.value.username,
                this.registerForm.value.password,this.registerForm.value.firstName,this.registerForm.value.lastName);
        this.userService.registerUser(this.user).subscribe(response=> 
        {
            this.router.navigate(['/registrationsuccessful']);
            });
        
        }
}
