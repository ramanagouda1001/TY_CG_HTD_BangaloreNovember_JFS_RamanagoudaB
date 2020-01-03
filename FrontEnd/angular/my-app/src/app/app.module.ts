import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import  {RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SectionComponent } from './section/section.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactusComponent } from './contactus/contactus.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { DemoComponent } from './demo/demo.component';
import { RamanagoudaComponent } from './ramanagouda/ramanagouda.component';
import { RohanComponent } from './rohan/rohan.component';
import { DilipaComponent } from './dilipa/dilipa.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SectionComponent,
    FooterComponent,
    HomeComponent,
    AboutComponent,
    ContactusComponent,
    RegisterComponent,
    LoginComponent,
    PageNotFoundComponent,
    DemoComponent,
    RamanagoudaComponent,
    RohanComponent,
    DilipaComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path:'',component:HomeComponent},
      {path:'about',component:AboutComponent},
      {path:'contact',component:ContactusComponent,
      children:[
        {path:'rohan',component:RohanComponent},
        {path:'ramanagouda',component:RamanagoudaComponent},
        {path:'dilipa',component:DilipaComponent}]
    },
      {path:'register',component:RegisterComponent},
      {path:'login',component:LoginComponent},
      {path:'**',component:PageNotFoundComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
