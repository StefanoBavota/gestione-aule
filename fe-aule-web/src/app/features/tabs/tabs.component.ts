import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.scss'],
})
export class TabsComponent implements OnInit {
  navLinks: { label: string; link: string; index: string }[];
  activeLink?: string;
  groupId: number = 0;

  constructor(private router: Router, private route: ActivatedRoute) {
    this.navLinks = [
      {
        label: 'Settimanali Aula',
        link: './weekly-class',
        index: 'weekly-class',
      },
      {
        label: 'Giornalieri',
        link: './daily',
        index: 'daily',
      },
      {
        label: 'Attuali',
        link: './current',
        index: 'current',
      },
      {
        label: 'Settimanali Corso',
        link: './weekly-course',
        index: 'weekly-course',
      },
    ];

    this.activeLink = this.router.url.split('/').pop()?.split('?')[0] ?? this.router.url.split('/').pop();
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.groupId = params['groupId'];
    });
  }

  setActiveLink(inedx: string) {
    this.activeLink = inedx;
  }
}
