import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CurrentEventsRoutingModule } from './current-events-routing.module';
import { CurrentEventsComponent } from './current-events.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { MatCardModule } from '@angular/material/card';

@NgModule({
  declarations: [CurrentEventsComponent],
  imports: [
    CommonModule,
    CurrentEventsRoutingModule,
    SharedModule,
    MatCardModule,
  ],
})
export class CurrentEventsModule {}
