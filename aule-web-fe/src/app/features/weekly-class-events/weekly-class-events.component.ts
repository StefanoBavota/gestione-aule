import { Component, OnInit, ViewChild } from '@angular/core';
import { CalendarOptions, EventClickArg } from '@fullcalendar/core';
import interactionPlugin from '@fullcalendar/interaction';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import listPlugin from '@fullcalendar/list';
import { FullCalendarComponent } from '@fullcalendar/angular';
import { ApiService } from '../services/api.service';
import { ActivatedRoute } from '@angular/router';
import { IClassroom, IEvents } from '../interfaces/response.interface';
import { MatDialog } from '@angular/material/dialog';
import { EventModalComponent } from 'src/app/shared/event-modal/event-modal.component';
@Component({
  selector: 'app-weekly-class-events',
  templateUrl: './weekly-class-events.component.html',
  styleUrls: ['./weekly-class-events.component.scss'],
})
export class WeeklyClassEventsComponent implements OnInit {
  @ViewChild('calendar') calendarComponent!: FullCalendarComponent;
  calendarOptions: CalendarOptions = {};

  weeklyEventsList: any = [];
  dateRef = new Date();

  selectedValue: number = 1;
  groupId: number = 0;

  classList: IClassroom[] = [];

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService,
    private dialogRef: MatDialog 
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.groupId = params['groupId'];
    });

    this.getClass(this.groupId);
    this.getEvents(this.selectedValue, this.dateRef);
    this.generateSchedule();
  }

  onClassSelected(classId: number) {
    this.selectedValue = classId;
    this.getEvents(this.selectedValue, this.dateRef);
  }

  generateSchedule() {
    this.calendarOptions = {
      plugins: [interactionPlugin, dayGridPlugin, timeGridPlugin, listPlugin],
      firstDay: 1,
      allDaySlot: false,
      initialView: 'timeGridWeek',
      initialEvents: this.weeklyEventsList,
      weekends: true,
      editable: false,
      selectable: false,
      selectMirror: false,
      dayMaxEvents: true,
      slotMinTime: '08:30:00',
      slotMaxTime: '21:00:00',
      slotLabelFormat: {
        hour: 'numeric',
        minute: '2-digit',
        omitZeroMinute: false,
      },
      height: 'auto',
      locales: [
        {
          code: 'it',
          buttonText: {
            today: 'Oggi',
          },
        },
      ],
      eventColor: '#f8bbd0',
      eventTextColor: 'black',
      eventBorderColor: 'black',
      eventClick: this.handleEventClick.bind(this),
    };
  }

  openDialog(eventId: number): void {
    this.dialogRef.open(EventModalComponent, {
      width: '600px',
      height: '600px',
      data: eventId,
    });
  }

  handleEventClick(clickInfo: EventClickArg) {
    // let eventInfo = clickInfo.event._def.extendedProps;
    this.openDialog(+clickInfo.event._def.publicId);
  }

  onDayClicked(day: Date) {
    const calendarApi = this.calendarComponent.getApi();
    calendarApi.gotoDate(day);
    this.dateRef = day;
    this.getEvents(this.selectedValue, this.dateRef);
  }

  getClass(groupId: number) {
    this.apiService.getClassByGroupId(groupId).subscribe((res) => {
      this.classList = res;
    });
  }

  getEvents(classId: number, selectedDay: Date) {
    this.apiService
      .getEventsOfWeekByClassId(classId, selectedDay)
      .subscribe((res) => {
        this.weeklyEventsList = this.mapSpecificFields(res);
        this.updateEventsInFullCalendar(this.weeklyEventsList);
      });
  }

  updateEventsInFullCalendar(events: any) {
    const calendarApi = this.calendarComponent.getApi();
    calendarApi.removeAllEvents();
    calendarApi.addEventSource(events);
  }

  mapSpecificFields(array: IEvents[]) {
    return array.map((obj: any) => {
      const { name, startTime, endTime, date, ...rest } = obj;

      const startDate = new Date(`${date}T${startTime}`);
      const endDate = new Date(`${date}T${endTime}`);

      startDate.setUTCHours(startTime.split(':')[0], startTime.split(':')[1]);
      endDate.setUTCHours(endTime.split(':')[0], endTime.split(':')[1]);

      const formattedStartDate = `${startDate.toISOString().slice(0, 19)}`;
      const formattedEndDate = `${endDate.toISOString().slice(0, 19)}`;

      return {
        ...rest,
        title: name,
        start: formattedStartDate,
        end: formattedEndDate,
      };
    });
  }
}
