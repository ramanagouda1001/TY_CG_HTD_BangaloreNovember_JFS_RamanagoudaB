import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-reactivefromversion',
  templateUrl: './reactivefromversion.component.html',
  styleUrls: ['./reactivefromversion.component.css']
})
export class ReactivefromversionComponent implements OnInit {

  registerForm:FormGroup;
  constructor(public fb:FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      name: this.fb.control(null, [Validators.required, Validators.minLength(5)]),
      email: this.fb.control(null, [Validators.required, Validators.email, Validators.minLength(5)]),
      password:this.fb.control(null, [Validators.minLength(5), Validators.maxLength(7)]),
      age: this.fb.control(null, Validators.maxLength(3)),
      skills:this.fb.array([
          this.getvalidskill()
      ])
    });
  }
  getvalidskill() {
    return this.fb.control(null,Validators.minLength(3));
  }
  addskill() {
    return this.skills.push(this.getvalidskill());
  }
  deleteskill(i:number){
    this.skills.removeAt(i);
  }
  sumbitForm() {
    console.log(this.registerForm.value);
    this.registerForm.reset();
  }
  get email() {
    return this.registerForm.get('email');
  }
  get password() {
    return this.registerForm.get('password');
  }
  get age() {
    return this.registerForm.get('age');
  }
  get skills() {
    return this.registerForm.get('skills') as FormArray;
  }

}
