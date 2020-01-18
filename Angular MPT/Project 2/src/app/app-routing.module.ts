import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GetListComponent } from './get-list/get-list.component';
import { AddListComponent } from './add-list/add-list.component';
import { UpdateListComponent } from './update-list/update-list.component';


const routes: Routes = [
  {path: 'get', component: GetListComponent},
  {path: 'add', component: AddListComponent},
  {path:'update',component:UpdateListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
