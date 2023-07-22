import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { IEvents, IGroup } from '../interfaces/response.interface';

@Injectable({
  providedIn: 'root',
})
export class DashboardService {
  constructor() {}

  setBodyForGroup(obj: IGroup) {
    return {
      name: obj.name,
      description: obj.description,
      link: obj.link,
    };
  }

  setBodyForClass(obj: any) {
    return {
      name: obj.name,
      capacity: obj.capacity,
      description: obj.notes,
      link: obj.icon,
      electricalOutlets: obj.number_of_electrical_outlets,
      ethernetPorts: obj.number_of_ethernet_ports,
      location_id: obj.location_id,
      supervisor_id: obj.supervisor_id,
      group_id: obj.group_id,
    };
  }

  setBodyForEvent(obj: IEvents) {
    return {
      name: obj.title,
      date: obj.date,
      start_time: obj.start,
      end_time: obj.end,
      description: obj.description,
      typology_id: obj.typology_id,
      supervisor_id: obj.supervisor_id,
      room_id: obj.room_id,
      course_id: obj.course_id,
    };
  }

  resetForm(formGroup: FormGroup, value: string) {
    formGroup.reset();
    switch (value) {
      case 'isCreationGroup':
        formGroup.get('isCreationGroup')?.patchValue('1');
        formGroup.get('isCreationGroup')?.updateValueAndValidity({
          emitEvent: false,
          onlySelf: true,
        });
        break;
      case 'isCreationClass':
        formGroup.get('isCreationClass')?.patchValue('1');
        formGroup.get('isCreationClass')?.updateValueAndValidity({
          emitEvent: false,
          onlySelf: true,
        });
        break;
      case 'isCreationEvent':
        formGroup.get('isCreationEvent')?.patchValue('1');
        formGroup.get('isCreationEvent')?.updateValueAndValidity({
          emitEvent: false,
          onlySelf: true,
        });
        break;
    }
  }
}
