import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { GetcontractComponent } from './getcontract/getcontract.component';
import { AddcontractComponent } from './addcontract/addcontract.component';
import { GetProductComponent } from './get-product/get-product.component';
import { AddProductComponent } from './add-product/add-product.component';
import { GetlandComponent } from './getland/getland.component';
import { AddlandComponent } from './addland/addland.component';
import { AboutComponent } from './about/about.component';
import { AuthGuard } from './auth.gurad';
import { EditlandComponent } from './editland/editland.component';
import { EditproductComponent } from './editproduct/editproduct.component';
import { EditcontractComponent } from './editcontract/editcontract.component';
import { GetaccountComponent } from './getaccount/getaccount.component';
import { EditaccountComponent } from './editaccount/editaccount.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    PagenotfoundComponent,
    GetcontractComponent,
    AddcontractComponent,
    GetProductComponent,
    AddProductComponent,
    GetlandComponent,
    AddlandComponent,
    AboutComponent,
    EditlandComponent,
    EditproductComponent,
    EditcontractComponent,
    GetaccountComponent,
    EditaccountComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      {
        path: 'login', component: LoginComponent
      },
      {
        path: 'getaccount', component: GetaccountComponent,
        canActivate: [AuthGuard], data: {
          expectedRoles: ['admin']
        }
      },
      {
        path:'editaccount/:email',component:EditaccountComponent,
        canActivate:[AuthGuard],data:{
          expectedRoles:['admin']
        }
      },
      {
        path: 'register', component: RegisterComponent,
        canActivate: [AuthGuard], data: {
          expectedRoles: ['admin']
        }
      },
      { path: 'getcontract', component: GetcontractComponent },
      {
        path: 'addcontract', component: AddcontractComponent,
        canActivate: [AuthGuard], data: {
          expectedRoles: ['client']
        }
      },
      {
        path: 'addproduct', component: AddProductComponent,
        canActivate: [AuthGuard], data: {
          expectedRoles: ['product']
        }
      },
      {
        path: 'getproduct', component: GetProductComponent,
        canActivate: [AuthGuard], data: {
          expectedRoles: ['product', 'client']
        }
      },
      {
        path: 'addland', component: AddlandComponent,
        canActivate: [AuthGuard], data: {
          expectedRoles: ['admin']
        }
      },
      {
        path: 'getland', component: GetlandComponent,
        canActivate: [AuthGuard], data: {
          expectedRoles: ['admin']
        }
      },
      {
        path: 'editland/:number', component: EditlandComponent,
        canActivate: [AuthGuard], data: {
          expectedRoles: ['admin']
        }
      },
      {
        path: 'editproduct/:product_id', component: EditproductComponent,
        canActivate: [AuthGuard], data: {
          expectedRoles: ['product']
        }
      },
      {
        path: 'editcontract/:contract_id', component: EditcontractComponent,
        canActivate: [AuthGuard], data: {
          expectedRoles: ['admin']
        }
      },
      { path: 'about', component: AboutComponent },
      { path: '**', component: PagenotfoundComponent }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
