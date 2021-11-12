import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpInterceptorService } from './login/auth/basicauth.service';

import { AppComponent } from './app.component';
import {AppRoutingModule, routesList} from "./app-routing.module";
import { UsuarioListComponent } from './usuario-list/usuario-list.component';
import { UsuarioCreateComponent } from './usuario-create/usuario-create.component';

@NgModule({
  declarations: [
    AppComponent,
    routesList,
    UsuarioCreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
      {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
      }
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
