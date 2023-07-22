import { Component, OnInit } from '@angular/core';
import { IDailyEventsResponse } from '../interfaces/response.interface';
import getDailyEvents from '../../../assets/mock/getDailyEvents.json';
import { MatDialog } from '@angular/material/dialog';
import { EventModalComponent } from 'src/app/shared/event-modal/event-modal.component';
import { IEvents } from '../interfaces/response.interface';
import { ApiService } from '../services/api.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-daily-events',
  templateUrl: './daily-events.component.html',
  styleUrls: ['./daily-events.component.scss'],
})
export class DailyEventsComponent implements OnInit {
  dailyEventsList: IDailyEventsResponse[] = [];
  dateRef = new Date();
  groupId: number = 0;

  constructor(
    private dialogRef: MatDialog,
    private apiService: ApiService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.groupId = params['groupId'];
    });

    this.getAllEvents(this.dateRef);
  }

  openDialog(eventId: number | undefined): void {
    this.dialogRef.open(EventModalComponent, {
      width: '600px',
      height: '600px',
      data: eventId,
    });
  }

  onDayClicked(day: Date) {
    this.dateRef = day;
    this.getAllEvents(this.dateRef);
  }

  getAllEvents(day: Date) {
    this.apiService
      .getDailyEventsByDate(this.groupId, day)
      .subscribe((res) => {
        this.dailyEventsList = res;
      });
  }
}
