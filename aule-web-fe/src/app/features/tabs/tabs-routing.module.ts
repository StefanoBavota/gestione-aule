import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsComponent } from './tabs.component';

const routes: Routes = [
  {
    path: '',
    component: TabsComponent,
    children: [
      {
        path: '',
        redirectTo: 'weekly-class',
        pathMatch: 'full',
        data: { queryParams: 'groupId' },
      },
      {
        path: 'weekly-class',
        loadChildren: () =>
          import('../weekly-class-events/weekly-class-events.module').then(
            (m) => m.WeeklyClassEventsModule
          ),
        data: { queryParams: 'groupId' },
      },
      {
        path: 'daily',
        loadChildren: () =>
          import('../daily-events/daily-events.module').then(
            (m) => m.DailyEventsModule
          ),
        data: { queryParams: 'groupId' },
      },
      {
        path: 'current',
        loadChildren: () =>
          import('../current-events/current-events.module').then(
            (m) => m.CurrentEventsModule
          ),
      },
      {
        path: 'weekly-course',
        loadChildren: () =>
          import('../weekly-course-events/weekly-course-events.module').then(
            (m) => m.WeeklyCourseEventsModule
          ),
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabsRoutingModule {}
