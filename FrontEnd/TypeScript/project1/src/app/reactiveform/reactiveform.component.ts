import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArrayName, FormArray, FormGroupName } from '@angular/forms';
@Component({
  selector: 'app-reactiveform',
  templateUrl: './reactiveform.component.html',
  styleUrls: ['./reactiveform.component.css']
})
export class ReactiveformComponent implements OnInit {

  registerForm:FormGroup;
  constructor() { }

  ngOnInit() {
    this.registerForm = new FormGroup({
      name: new FormControl(null, [Validators.required, Validators.minLength(5)]),
      email: new FormControl(null, [Validators.required, Validators.email, Validators.minLength(5)]),
      password: new FormControl(null, [Validators.minLength(5), Validators.maxLength(7)]),
      age: new FormControl(null, Validators.maxLength(3)),
      skills:new FormArray([
          this.getvalidskill()
      ])
    });
  }
  getvalidskill() {
    return new FormControl(null,Validators.minLength(3));
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
