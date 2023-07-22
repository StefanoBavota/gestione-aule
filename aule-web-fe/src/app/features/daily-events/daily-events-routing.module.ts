import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DailyEventsComponent } from './daily-events.component';

const routes: Routes = [{ path: '', component: DailyEventsComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DailyEventsRoutingModule { }
