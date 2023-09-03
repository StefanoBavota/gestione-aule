import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {
  IGroup,
  IDailyEventsResponse,
  ICourse,
  IClassroom,
  IEvents,
  ISupervisor,
  ILocation,
  ITypology,
} from '../interfaces/response.interface';
@Injectable()
export class ApiService {
  indexPath: string = 'http://localhost:8080/api';
  constructor(private http: HttpClient) {}

  //TEST
  login(body: any) {
    return this.http.post<any>(`${this.indexPath}/auth/login`, body);
  }

  //DONE
  getClassByGroupId(groupId: number) {
    const params = new HttpParams().set('groupId', groupId.toString());
    return this.http.get<IClassroom[]>(`${this.indexPath}/rooms`, { params });
  }

  //DONE
  getEventsOfWeekByClassId(classId: number, selectedDay: Date) {
    let params = new HttpParams()
      .set('classId', classId.toString())
      .set('selectedDay', selectedDay.toISOString().slice(0, 10));

    return this.http.get<IEvents[]>(`${this.indexPath}/events/rooms-current`, {
      params,
    });
  }

  //DONE
  getEventsOfWeekByCourseId(courseId: number, selectedDay: Date) {
    let params = new HttpParams()
      .set('courseId', courseId.toString())
      .set('selectedDay', selectedDay.toISOString().slice(0, 10));

    return this.http.get<IEvents[]>(`${this.indexPath}/events/course-current`, {
      params,
    });
  }

  //DONE
  getDailyEventsByDate(groupId: number, selectedDay: Date) {
    let params = new HttpParams()
      .set('groupId', groupId.toString())
      .set('selectedDay', selectedDay.toISOString().slice(0, 10));
    return this.http.get<IDailyEventsResponse[]>(
      `${this.indexPath}/rooms/get-room-events`,
      { params }
    );
  }

  //DONE
  getCurrentEvents(groupId: number) {
    let params = new HttpParams().set('groupId', groupId.toString());
    return this.http.get<IEvents[]>(`${this.indexPath}/events/next-events`, {
      params,
    });
  }

  //DONE
  getGroups() {
    return this.http.get<IGroup[]>(`${this.indexPath}/groups`);
  }

  //DONE
  getAllClass() {
    return this.http.get<IClassroom[]>(`${this.indexPath}/rooms`);
  }

  //DONE
  getAllCourse() {
    return this.http.get<ICourse[]>(`${this.indexPath}/courses`);
  }

  //DONE
  getAllSupervisor() {
    return this.http.get<ISupervisor[]>(`${this.indexPath}/supervisors`);
  }

  //DONE
  getAllLocations() {
    return this.http.get<ILocation[]>(`${this.indexPath}/locations`);
  }

  //DONE
  getAllTypology() {
    return this.http.get<ITypology[]>(`${this.indexPath}/typologies`);
  }

  //DONE
  getAllEvents() {
    return this.http.get<IEvents[]>(`${this.indexPath}/events`);
  }

  //DONE
  getFileCsv() {
    const url = `${this.indexPath}/events/export-csv`;
    return this.http.get(url, { responseType: 'blob' });
  }

  //DONE
  getGroupById(groupId: number | undefined) {
    return this.http.get<IGroup>(`${this.indexPath}/groups/${groupId}`);
  }

  //DONE
  getClassById(classId: number | undefined) {
    return this.http.get<IClassroom>(`${this.indexPath}/rooms/${classId}`);
  }

  //DONE
  getEventById(eventId: number | undefined) {
    return this.http.get<IEvents>(`${this.indexPath}/events/${eventId}`);
  }

  //DONE
  newGroup(body: any) {
    return this.http.post<IGroup>(`${this.indexPath}/groups`, body);
  }

  //DONE
  editGroup(body: any, groupId: number | undefined) {
    return this.http.put<IGroup>(`${this.indexPath}/groups/${groupId}`, body);
  }

  //DONE
  newClass(body: any) {
    return this.http.post<IClassroom>(`${this.indexPath}/rooms`, body);
  }

  //DONE
  editClass(body: any, classId: number | undefined) {
    return this.http.put<IClassroom>(
      `${this.indexPath}/rooms/${classId}`,
      body
    );
  }

  //DONE
  newEvent(body: any) {
    return this.http.post<IEvents>(`${this.indexPath}/events`, body);
  }

  //DONE
  editEvent(body: any, eventId: number | undefined) {
    return this.http.put<IEvents>(`${this.indexPath}/events/${eventId}`, body);
  }
}
