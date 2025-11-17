import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  constructor() {}

  adminName: string = '';

  ngOnInit() {
    this.adminName = localStorage.getItem('adminName') || 'Admin';
  }
}
