import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WeeklyCourseEventsComponent } from './weekly-course-events.component';

const routes: Routes = [{ path: '', component: WeeklyCourseEventsComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WeeklyCourseEventsRoutingModule { }
