export interface IEvents {
  id?: number;
  title?: string;
  start?: Date;
  end?: Date;
  description?: string;
  date?: string;
  supervisor?: ISupervisor;
  room?: IClassroom;
  courses?: ICourse[];
  typology?: ITypology;
  name?: string;
  start_time?: string;
  end_time?: string;
  typology_id?: number;
  supervisor_id?: number;
  room_id?: number;
}

export interface IClassroom {
  id?: number;
  name?: string;
  capacity?: number;
  description?: string;
  link?: string;
  electricalOutlets?: number;
  ethernetPorts?: number;
  supervisor_id?: number;
  group_id?: number;
  location_id?: number;
}

export interface ICourse {
  id: number;
  name: string;
}

export interface ITypology {
  id?: number;
  name?: string;
}

export interface ISupervisor {
  id?: number;
  name?: string;
  email?: string;
}

export interface ILocation {
  id?: number;
  place?: string;
  building?: string;
  floor?: string;
}

export interface IGroup {
  id: number;
  name?: string;
  description?: string;
  link?: string;
}

export interface IDailyEventsResponse {
  id?: number;
  name?: string;
  capacity?: number;
  description?: string;
  icon?: string;
  number_of_electrical_othlets?: number;
  number_of_ethernet_ports?: number;
  events?: IEvents[];
}
