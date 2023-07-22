import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { HomepageComponent } from './homepage.component';
import { HomepageRoutingModule } from './homepage-routing.module';

@NgModule({
  providers: [],
  declarations: [HomepageComponent],
  imports: [CommonModule, HomepageRoutingModule, SharedModule, FormsModule],
})
export class HomepageModule {}
