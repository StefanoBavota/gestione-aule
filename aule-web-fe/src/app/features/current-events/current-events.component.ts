import { Component, OnInit } from '@angular/core';
import { IDailyEventsResponse } from '../interfaces/response.interface';
import getCurrentEvents from '../../../assets/mock/getCurrentEvents.json';
import { MatDialog } from '@angular/material/dialog';
import { EventModalComponent } from 'src/app/shared/event-modal/event-modal.component';
import { IEvents } from '../interfaces/response.interface';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-current-events',
  templateUrl: './current-events.component.html',
  styleUrls: ['./current-events.component.scss'],
})
export class CurrentEventsComponent implements OnInit {
  currentEventsList: IEvents[] = [];
  dateRef = new Date();
  groupId: number = 0;

  constructor(
    private dialogRef: MatDialog,
    private route: ActivatedRoute,
    private apiService: ApiService
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.groupId = params['groupId'];
    });

    this.getAllEvents();
  }

  openDialog(eventId: number | undefined): void {
    this.dialogRef.open(EventModalComponent, {
      width: '600px',
      height: '600px',
      data: eventId,
    });
  }

  getAllEvents() {
    // this.currentEventsList = getCurrentEvents as unknown as IEvents[];
    this.apiService.getCurrentEvents(this.groupId).subscribe((res) => {
      this.currentEventsList = res;
    });
  }

  mapSpecificFields(obj: IEvents) {
    const { name, startTime, endTime, date, ...rest } = obj;

    const startDate = new Date(`${date}T${startTime}`);
    const endDate = new Date(`${date}T${endTime}`);

    const formattedStartDate = startDate
      .toISOString()
      .replace('Z', '')
      .replace('T', ' ');
    const formattedEndDate = endDate
      .toISOString()
      .replace('Z', '')
      .replace('T', ' ');

    return {
      ...rest,
      title: name,
      start: formattedStartDate,
      end: formattedEndDate,
    };
  }
}
