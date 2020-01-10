import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  selected;
  cars=[
    {
      name:"BNW",
      imageURL:'https://cdn.pixabay.com/photo/2016/02/13/13/11/cuba-1197800__340.jpg',
      details:'awsome'
    },
    {
      name:"car",
      imageURL:'https://cdn.pixabay.com/photo/2012/05/29/00/43/car-49278__340.jpg',
      details:'awsome'
    },
    {
      name:"bike",
      imageURL:'https://cdn.pixabay.com/photo/2016/11/22/23/44/buildings-1851246__340.jpg',
      details:'awsome'
    }
  ];
  constructor() { }
  selectedcar(car){
    this.selectedcar=car;
  }
  ngOnInit() {
  }

}
