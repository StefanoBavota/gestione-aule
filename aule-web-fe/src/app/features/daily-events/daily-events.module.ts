import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DailyEventsRoutingModule } from './daily-events-routing.module';
import { DailyEventsComponent } from './daily-events.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { MatCardModule } from '@angular/material/card';

@NgModule({
  declarations: [DailyEventsComponent],
  imports: [
    CommonModule,
    DailyEventsRoutingModule,
    SharedModule,
    MatCardModule,
  ],
})
export class DailyEventsModule {}
