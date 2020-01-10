import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bike',
  templateUrl: './bike.component.html',
  styleUrls: ['./bike.component.css']
})
export class BikeComponent implements OnInit {

  selectedBike;

  Bike = [
    {
      name:'BMW',
      imgURL: 'https://cdn.pixabay.com/photo/2016/04/07/06/53/bmw-1313343_1280.jpg',
      details:`BMW unveiled their first electric motorcycle in June 2014.
      The Vision DC Roadster was the first of its kind from the BMW Motorrad brand and a bike
       that replaces  the boxer engine with batteries and an electric motor.`
    },
    {
      name:'FZ',
      imgURL:'https://cdn.pixabay.com/photo/2018/02/12/02/05/motorcycle-3147278_1280.jpg',
      details:`FZ unveiled their first electric motorcycle in June 2015.
      The Vision DC Roadster was the first of its kind from the BMW Motorrad brand and a bike
       that replaces  the boxer engine with batteries and an electric motor. `
    },
    {
      name:'Honda',
      imgURL:'https://cdn.pixabay.com/photo/2013/07/05/02/04/honda-143399__340.jpg',
      details:`Honda unveiled their first electric motorcycle in June 2017.
      The Vision DC Roadster was the first of its kind from the BMW Motorrad brand and a bike
       that replaces  the boxer engine with batteries and an electric motor. `
    },
    {
      name:'RoyalEnfield',
      imgURL:'https://cdn.pixabay.com/photo/2019/05/24/16/38/bullet-ride-4226666__340.jpg',
      details:`RoyalEnfield unveiled their first electric motorcycle in June 2018.
      The Vision DC Roadster was the first of its kind from the BMW Motorrad brand and a bike
       that replaces  the boxer engine with batteries and an electric motor. `
    },

  ];
  constructor() { 
  }
  selectBike(Bike) {
    this.selectedBike = Bike;
  }

  ngOnInit() {
  }
}
