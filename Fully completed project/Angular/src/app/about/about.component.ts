import { Component, OnInit } from '@angular/core';
import 'jarallax';
declare var jarallax: any;
@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  constructor() { }

  ngOnInit() {

  }

  // tslint:disable-next-line: use-lifecycle-interface
  ngAfterViewInit() {
    jarallax(document.querySelectorAll('.parallel'), {
      speed: 0.2
    });
  }

}
