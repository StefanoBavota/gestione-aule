import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WeeklyClassEventsRoutingModule } from './weekly-class-events-routing.module';
import { WeeklyClassEventsComponent } from './weekly-class-events.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { FullCalendarModule } from '@fullcalendar/angular';
import { MatCardModule } from '@angular/material/card';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@NgModule({
  declarations: [WeeklyClassEventsComponent],
  imports: [
    CommonModule,
    WeeklyClassEventsRoutingModule,
    SharedModule,
    FullCalendarModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    MatIconModule,
  ],
})
export class WeeklyClassEventsModule {}
