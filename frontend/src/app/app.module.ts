import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AboutComponent } from 'app/about/about.component';
import { AppRoutingModule } from 'app/app-routing.module';
import { AppComponent } from 'app/app.component';
import { CandyEditComponent } from 'app/candy-edit/candy-edit.component';
import { CandyListComponent } from 'app/candy-list/candy-list.component';
import { HeaderComponent } from 'app/header/header.component';
import { LinkBorderComponent } from 'app/link-border/link-border.component';
import { PresentDetailComponent } from 'app/present-detail/present-detail.component';
import { PresentListComponent } from 'app/present-list/present-list.component';
import { PresentNewComponent } from 'app/present-new/present-new.component';
import { PresentNewSelectCandyComponent } from 'app/present-new/select-candy/present-new-select-candy.component';
import { ConfirmationDeleteComponent } from 'app/shared/confirmation-delete/confirmation-delete.component';
import { CandyService } from 'app/shared/services/candy.service';
import { CandyStore } from 'app/shared/services/candy.store';
import { PresentService } from 'app/shared/services/present.service';
import { PresentStore } from 'app/shared/services/present.store';
import { ValidationModule } from 'app/shared/validation/index';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    HeaderComponent,
    CandyListComponent,
    CandyEditComponent,
    ConfirmationDeleteComponent,
    LinkBorderComponent,
    PresentListComponent,
    PresentDetailComponent,
    PresentNewComponent,
    PresentNewSelectCandyComponent
  ],
  entryComponents: [
    CandyEditComponent,
    ConfirmationDeleteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule.forRoot(),
    AppRoutingModule,
    ValidationModule
  ],
  providers: [
    CandyService,
    CandyStore,
    PresentService,
    PresentStore
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }