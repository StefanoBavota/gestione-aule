import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ApiService } from '../services/api.service';
import {
  ICourse,
  IGroup,
  ILocation,
  ISupervisor,
  ITypology,
} from '../interfaces/response.interface';
import { IClassroom, IEvents } from '../interfaces/response.interface';
import { Observable, map, startWith } from 'rxjs';
import { MatAutocompleteSelectedEvent } from '@angular/material/autocomplete';
import { DashboardService } from './dashboard.service';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
  MatSnackBarConfig,
} from '@angular/material/snack-bar';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent implements OnInit {
  step: number = 0;
  showAccordionGroup: boolean = false;
  showAccordionClass: boolean = false;
  showAccordionEvent: boolean = false;

  groupsForm: FormGroup = new FormGroup({
    isCreationGroup: new FormControl('1'),
    groupId: new FormControl(''),
    name: new FormControl(''),
    description: new FormControl(''),
    link: new FormControl(''),
  });

  classForm: FormGroup = new FormGroup({
    isCreationClass: new FormControl('1'),
    classId: new FormControl(''),
    name: new FormControl(''),
    notes: new FormControl(''),
    icon: new FormControl(''),
    capacity: new FormControl(0),
    number_of_electrical_outlets: new FormControl(0),
    number_of_ethernet_ports: new FormControl(0),
    supervisor_id: new FormControl(0),
    group_id: new FormControl(0),
    location_id: new FormControl(0),
  });

  eventsForm: FormGroup = new FormGroup({
    isCreationEvent: new FormControl('1'),
    eventId: new FormControl(''),
    title: new FormControl(''),
    date: new FormControl(''),
    start: new FormControl(''),
    end: new FormControl(''),
    description: new FormControl(''),
    typology_id: new FormControl(0),
    supervisor_id: new FormControl(0),
    room_id: new FormControl(0),
    course_id: new FormControl(0),
  });

  groupsList: IGroup[] = [];
  classList: IClassroom[] = [];
  eventList: IEvents[] = [];
  typologyList: ITypology[] = [];
  supervisorList: ISupervisor[] = [];
  locationList: ILocation[] = [];
  courseList: ICourse[] = [];

  groupId: number | undefined = 0;
  classId: number | undefined = 0;
  eventId: number | undefined = 0;

  filteredGroup!: Observable<any[]>;
  filteredClass!: Observable<any[]>;
  filteredEvents!: Observable<any[]>;

  constructor(
    private apiService: ApiService,
    private dashboardService: DashboardService,
    private _snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.initialize();
    // event change
    this.radioChange(this.groupsForm, 'isCreationGroup');
    this.radioChange(this.classForm, 'isCreationClass');
    this.radioChange(this.eventsForm, 'isCreationEvent');

    // filters
    this.filterGroup();
    this.filterClass();
    this.filterEvents();
  }

  initialize() {
    this.getGroups();
    this.getClass();
    this.getEvents();
    this.getAllTypology();
    this.getAllSupervisor();
    this.getAllLocations();
    this.getAllCourse();
  }

  setStep(index: number) {
    this.step = index;
  }

  getGroups() {
    this.apiService.getGroups().subscribe((res) => {
      this.groupsList = res;
    });
  }

  getClass() {
    this.apiService.getAllClass().subscribe((res) => {
      this.classList = res;
    });
  }

  getEvents() {
    this.apiService.getAllEvents().subscribe((res) => {
      this.eventList = res;
    });
  }

  getAllTypology() {
    this.apiService.getAllTypology().subscribe((res) => {
      this.typologyList = res;
    });
  }

  getAllSupervisor() {
    this.apiService.getAllSupervisor().subscribe((res) => {
      this.supervisorList = res;
    });
  }

  getAllLocations() {
    this.apiService.getAllLocations().subscribe((res) => {
      this.locationList = res;
    });
  }

  getAllCourse() {
    this.apiService.getAllCourse().subscribe((res) => {
      this.courseList = res;
    });
  }

  clearFormGroup() {
    this.resetButton(this.groupsForm, 'isCreationGroup');
  }

  clearFormClass() {
    this.resetButton(this.classForm, 'isCreationClass');
  }

  clearFormEvent() {
    this.resetButton(this.eventsForm, 'isCreationEvent');
  }

  radioChange(formGroup: FormGroup, value: string) {
    switch (value) {
      case 'isCreationGroup':
        formGroup.get('isCreationGroup')?.valueChanges.subscribe((value) => {
          if (value === '1') {
            this.showAccordionGroup = false;
          } else {
            this.showAccordionGroup = true;
          }
        });
        break;
      case 'isCreationClass':
        formGroup.get('isCreationClass')?.valueChanges.subscribe((value) => {
          if (value === '1') {
            this.showAccordionClass = false;
          } else {
            this.showAccordionClass = true;
          }
        });
        break;
      case 'isCreationEvent':
        formGroup.get('isCreationEvent')?.valueChanges.subscribe((value) => {
          if (value === '1') {
            this.showAccordionEvent = false;
          } else {
            this.showAccordionEvent = true;
          }
        });
        break;
    }
  }

  groupSubmit() {
    if (this.groupsForm.valid) {
      let values = this.groupsForm.value;
      if (values.isCreationGroup === '1') {
        //POST
        let body = this.dashboardService.setBodyForGroup(values);
        this.apiService.newGroup(body).subscribe((response) => {
          this.openSnackBar('Creazione effettuata con successo');
          this.resetButton(this.groupsForm, 'isCreationGroup');
          this.initialize();
        });
      } else if (values.isCreationGroup === '2') {
        //PUT
        let body = this.dashboardService.setBodyForGroup(values);
        this.apiService.editGroup(body, this.groupId).subscribe((response) => {
          this.openSnackBar('Modifica effettuata con successo');
          this.resetButton(this.groupsForm, 'isCreationGroup');
          this.initialize();
        });
      }
    }
  }

  classSubmit() {
    if (this.classForm.valid) {
      let values = this.classForm.value;
      if (values.isCreationClass === '1') {
        //POST
        let body = this.dashboardService.setBodyForClass(values);
        this.apiService.newClass(body).subscribe((response) => {
          this.openSnackBar('Creazione effettuata con successo');
          this.resetButton(this.classForm, 'isCreationClass');
          this.initialize();
        });
      } else if (values.isCreationClass === '2') {
        //PUT
        let body = this.dashboardService.setBodyForClass(values);
        this.apiService.editClass(body, this.classId).subscribe((response) => {
          this.openSnackBar('Modifica effettuata con successo');
          this.resetButton(this.classForm, 'isCreationClass');
          this.initialize();
        });
      }
    }
  }

  eventsSubmit() {
    if (this.eventsForm.valid) {
      let values = this.eventsForm.value;
      if (values.isCreationEvent === '1') {
        //POST
        let body = this.dashboardService.setBodyForEvent(values);
        this.apiService.newEvent(body).subscribe((response) => {
          this.openSnackBar('Creazione effettuata con successo');
          this.resetButton(this.eventsForm, 'isCreationEvent');
          this.initialize();
        });
      } else if (values.isCreationEvent === '2') {
        //PUT
        let body = this.dashboardService.setBodyForEvent(values);
        this.apiService.editEvent(body, this.eventId).subscribe((response) => {
          this.openSnackBar('Modifica effettuata con successo');
          this.resetButton(this.eventsForm, 'isCreationEvent');
          this.initialize();
        });
      }
    }
  }

  resetButton(formGroup: FormGroup, value: string) {
    this.dashboardService.resetForm(formGroup, value);
  }

  // FILTRI GRUPPI
  filterGroup() {
    this.filteredGroup = this.groupsForm.controls['groupId'].valueChanges.pipe(
      startWith(''),
      map((value) => this._filterGroup(value || ''))
    );
  }

  private _filterGroup(value: string) {
    const filterValue = this._normalizeValue(value);
    return this.groupsList.filter((group) =>
      this._normalizeValue(group.name).includes(filterValue)
    );
  }

  onGroupSelected(event: MatAutocompleteSelectedEvent): void {
    const selectedGroup = event.option.value;

    const selectedGroupId = this.groupsList.find(
      (group) => group.name === selectedGroup
    )?.id;

    this.groupId = selectedGroupId;
    this.apiService.getGroupById(this.groupId).subscribe((res) => {
      if (res) {
        this.groupsForm.patchValue({
          name: res.name || '',
          description: res.description || '',
          link: res.link || '',
        });
      }
    });
  }

  // FILTRI CLASSI
  filterClass() {
    this.filteredClass = this.classForm.controls['classId'].valueChanges.pipe(
      startWith(''),
      map((value) => this._filterClass(value || ''))
    );
  }

  private _filterClass(value: string) {
    const filterValue = this._normalizeValue(value);
    return this.classList.filter((room) =>
      this._normalizeValue(room.name).includes(filterValue)
    );
  }

  onClassSelected(event: MatAutocompleteSelectedEvent): void {
    const selectedClass = event.option.value;

    const selectedClassId = this.classList.find(
      (room) => room.name === selectedClass
    )?.id;

    this.classId = selectedClassId;
    this.apiService.getClassById(this.classId).subscribe((res) => {
      if (res) {
        this.classForm.patchValue({
          name: res.name || '',
          notes: res.description || '',
          icon: res.link || '',
          capacity: res.capacity || 0,
          number_of_electrical_outlets: res.electricalOutlets || 0,
          number_of_ethernet_ports: res.ethernetPorts || 0,
          supervisor_id: res.supervisor_id || 0,
          group_id: res.group_id || 0,
          location_id: res.location_id || 0,
        });
      }
    });
  }

  // FILTIRI EVENTI
  filterEvents() {
    this.filteredEvents = this.eventsForm.controls['eventId'].valueChanges.pipe(
      startWith(''),
      map((value) => this._filterEvents(value || ''))
    );
  }

  private _filterEvents(value: string) {
    const filterValue = this._normalizeValue(value);
    return this.eventList.filter((event: IEvents) =>
      this._normalizeValue(event.name).includes(filterValue)
    );
  }

  provaaaa: number[] | undefined = [];
  onEventSelected(event: MatAutocompleteSelectedEvent): void {
    const selectedEvent = event.option.value;

    const selectedEventsId = this.eventList.find(
      (events: IEvents) => events.name === selectedEvent
    )?.id;

    this.eventId = selectedEventsId;
    this.apiService.getEventById(this.eventId).subscribe((res) => {
      if (res) {
        this.provaaaa = res.course_id;
        this.eventsForm.patchValue({
          title: res.name || '',
          date: res.date || '',
          start: res.startTime || '',
          end: res.endTime || '',
          description: res.description || '',
          typology_id: res.typology_id || 0,
          supervisor_id: res.supervisor_id || 0,
          room_id: res.room_id || 0,
          course_id: res.course_id || 0,
        });
      }
    });
  }

  private _normalizeValue(value: any) {
    return value.toLowerCase().replace(/\s/g, '');
  }

  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  openSnackBar(message: string) {
    const config = new MatSnackBarConfig();
    config.duration = 5000;
    config.horizontalPosition = this.horizontalPosition;
    config.verticalPosition = this.verticalPosition;

    this._snackBar.open(message, 'OK', config);
  }

  exportFile() {
    this.apiService.getFileCsv().subscribe((response: Blob) => {
      const blob = new Blob([response], { type: 'text/csv' });
      saveAs(blob, 'eventi.csv');
    });
  }
}
