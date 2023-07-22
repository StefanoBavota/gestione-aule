import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { DateAdapter } from '@angular/material/core';
import { DatePicker, DayItem } from 'date-pickle';
@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss'],
})
export class CalendarComponent implements OnInit {
  private dp!: DatePicker;
  dayItems!: DayItem[];
  year!: number;
  month!: string;

  @Input() dateRef!: Date;
  @Input() lang = 'en-US';
  @Input() todayLabel = 'Today';

  @Output() dayClicked = new EventEmitter<Date>();

  constructor(private dateAdapter: DateAdapter<Date>) {}

  ngOnInit() {
    this.initDatePicker();
  }

  private initDatePicker(): void {
    this.dp = new DatePicker(this.dateRef);
    const immediate = true;
    this.dp.onItemsChange((items) => {
      this.dayItems = items;
      this.updateYearMonth(items[15]);
    }, immediate);
  }

  onDayItemClick(dayItem: DayItem) {
    if (dayItem.isDisabled) {
      return;
    }

    this.dayClicked.emit(dayItem.date);
    this.dp.selected = dayItem.date;
  }

  onPreviousMonth() {
    this.dp.prev();
    this.updateYearMonth(this.dayItems[15]);
  }

  onNextMonth() {
    this.dp.next();
    this.updateYearMonth(this.dayItems[15]);
  }

  onSetToday() {
    this.dp.now();
    this.dp.selected = new Date();

    this.dayClicked.emit(this.dp.selected);
  }

  private updateYearMonth(item: DayItem): void {
    this.year = item.date.getFullYear();
    this.month = this.monthIndexToName(item.date);
  }

  private monthIndexToName(date: Date): string {
    const formatter = new Intl.DateTimeFormat(this.lang, { month: 'long' });
    return this.capitalize(formatter.format(date));
  }

  private capitalize(word: string): string {
    return word[0].toUpperCase() + word.slice(1);
  }
}
