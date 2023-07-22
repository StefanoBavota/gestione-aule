import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { TabsRoutingModule } from './tabs-routing.module';


import { TabsComponent } from './tabs.component';
import { MatTabsModule } from '@angular/material/tabs';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [TabsComponent],
  imports: [
    CommonModule,
    TabsRoutingModule,
    SharedModule,
    FormsModule,
    MatTabsModule,
    RouterModule
  ]
})
export class TabsModule {}
