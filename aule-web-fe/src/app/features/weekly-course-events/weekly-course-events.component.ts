import { Component, OnInit, ViewChild } from '@angular/core';
import { CalendarOptions, EventClickArg } from '@fullcalendar/core';
import interactionPlugin from '@fullcalendar/interaction';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import listPlugin from '@fullcalendar/list';
import getWeeklyEvents from '../../../assets/mock/getWeeklyEvents.json';
import { FullCalendarComponent } from '@fullcalendar/angular';
import { ApiService } from '../services/api.service';
import { ICourse, IEvents } from '../interfaces/response.interface';
import { MatDialog } from '@angular/material/dialog';
import { EventModalComponent } from 'src/app/shared/event-modal/event-modal.component';

@Component({
  selector: 'app-weekly-course-events',
  templateUrl: './weekly-course-events.component.html',
  styleUrls: ['./weekly-course-events.component.scss'],
})
export class WeeklyCourseEventsComponent implements OnInit {
  @ViewChild('calendar') calendarComponent!: FullCalendarComponent;
  calendarOptions: CalendarOptions = {};

  weeklyEventsList: any = [];
  dateRef = new Date();

  selectedValue: number = 1;

  courseList: ICourse[] = [];

  constructor(
    private apiService: ApiService,
    private dialogRef: MatDialog
  ) {}

  ngOnInit(): void {
    this.getCourse();
    this.getEvents(this.selectedValue, this.dateRef);
    this.generateSchedule();
  }

  onClassSelected(courseId: number) {
    this.selectedValue = courseId;
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
    this.openDialog(+clickInfo.event._def.publicId);
  }

  onDayClicked(day: Date) {
    const calendarApi = this.calendarComponent.getApi();
    calendarApi.gotoDate(day);
    this.dateRef = day;
    this.getEvents(this.selectedValue, this.dateRef);
  }

  getCourse() {
    this.apiService.getAllCourse().subscribe((res) => {
      this.courseList = res;
    });
  }

  getEvents(courseId: number, selectedDay: Date) {
    this.weeklyEventsList = getWeeklyEvents;
    this.apiService
      .getEventsOfWeekByCourseId(courseId, selectedDay)
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
      const { name, start_time, end_time, date, ...rest } = obj;

      const startDate = new Date(`${date}T${start_time}`);
      const endDate = new Date(`${date}T${end_time}`);

      startDate.setUTCHours(start_time.split(':')[0], start_time.split(':')[1]);
      endDate.setUTCHours(end_time.split(':')[0], end_time.split(':')[1]);

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
