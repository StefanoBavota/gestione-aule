import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WeeklyClassEventsComponent } from './weekly-class-events.component';

const routes: Routes = [{ path: '', component: WeeklyClassEventsComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WeeklyClassEventsRoutingModule { }
