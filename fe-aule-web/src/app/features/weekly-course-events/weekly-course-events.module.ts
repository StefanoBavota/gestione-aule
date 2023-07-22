import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WeeklyCourseEventsRoutingModule } from './weekly-course-events-routing.module';
import { WeeklyCourseEventsComponent } from './weekly-course-events.component';
import { FullCalendarModule } from '@fullcalendar/angular';
import { MatCardModule } from '@angular/material/card';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [WeeklyCourseEventsComponent],
  imports: [
    CommonModule,
    WeeklyCourseEventsRoutingModule,
    SharedModule,
    MatCardModule,
    FullCalendarModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    FormsModule,
  ],
})
export class WeeklyCourseEventsModule {}
