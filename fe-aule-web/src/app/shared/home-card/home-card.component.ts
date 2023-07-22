import { Component, Input, OnInit } from '@angular/core';
import { IGroup } from 'src/app/features/interfaces/response.interface';

@Component({
  selector: 'app-home-card',
  templateUrl: './home-card.component.html',
  styleUrls: ['./home-card.component.scss'],
})
export class HomeCardComponent implements OnInit {
  @Input() group: IGroup = { id: 0 };

  constructor() {}

  ngOnInit(): void {}
}
