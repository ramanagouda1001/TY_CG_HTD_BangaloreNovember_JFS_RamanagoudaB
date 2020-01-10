import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { DataBindingComponent } from './data-binding/data-binding.component';
import { LateComersComponent } from './late-comers/late-comers.component';
import { HeaderComponent } from './header/header.component';
import { ProductComponent } from './product/product.component';
import { ImagesComponent } from './images/images.component';
import { ColorDirective } from './color.directive';
import { ParentComponent } from './parent/parent.component';
import { ChildComponent } from './child/child.component';
import { BikeComponent } from './bike/bike.component';
import { BikeDetailsComponent } from './bike-details/bike-details.component';
import { CarComponent } from './car/car.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { LoginComponent } from './login/login.component';
import { ReactiveformComponent } from './reactiveform/reactiveform.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { ReactivefromversionComponent } from './reactivefromversion/reactivefromversion.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DataBindingComponent,
    LateComersComponent,
    HeaderComponent,
    ProductComponent,
    ImagesComponent,
    ColorDirective,
    ParentComponent,
    ChildComponent,
    BikeComponent,
    BikeDetailsComponent,
    CarComponent,
    CarDetailsComponent,
    LoginComponent,
    ReactiveformComponent,
    ReactivefromversionComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AngularFontAwesomeModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path: 'latecomer', component: LateComersComponent},
      {path: 'product', component: ProductComponent},
      {path: 'images', component: ImagesComponent},
      {path: 'parent', component: ParentComponent},
      {path: 'bike', component: BikeComponent},
      {path:'car',component:CarComponent},
      {path:'loginform',component:LoginComponent},
      {path:'register',component:ReactiveformComponent},
      {path:'registerversion',component:ReactivefromversionComponent   }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
