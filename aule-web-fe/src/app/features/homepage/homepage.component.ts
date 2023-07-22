import { Component, OnInit } from '@angular/core';
import { IGroup } from '../interfaces/response.interface';
import { Router } from '@angular/router';
import { ApiService } from '../services/api.service';

@Component({
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss'],
})
export class HomepageComponent implements OnInit {
  groupsList: IGroup[] = [];

  constructor(private router: Router, private apiService: ApiService) {}

  ngOnInit(): void {
    this.getGroups();
  }

  getGroups() {
    this.apiService.getGroups().subscribe((res) => {
      this.groupsList = res;
    });
  }

  onSelectGroup(groupId: number) {
    const urlTree = this.router.parseUrl('/tabs');
    urlTree.queryParams['groupId'] = groupId;
    this.router.navigateByUrl(urlTree);
  }
}
