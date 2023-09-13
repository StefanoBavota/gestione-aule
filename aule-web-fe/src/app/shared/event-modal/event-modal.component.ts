import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { IEvents } from 'src/app/features/interfaces/response.interface';
import { ApiService } from 'src/app/features/services/api.service';

@Component({
  selector: 'app-event-modal',
  templateUrl: './event-modal.component.html',
  styleUrls: ['./event-modal.component.scss'],
})
export class EventModalComponent implements OnInit {
  eventId: number = 0;
  event: any = {};

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: number,
    private apiService: ApiService
  ) {}

  ngOnInit(): void {
    this.eventId = this.data;
    this.getEventById(this.eventId);
  }

  getEventById(eventId: number) {
    this.apiService.getEventById(eventId).subscribe((res) => {
      this.event = res;
    });
  }
}
