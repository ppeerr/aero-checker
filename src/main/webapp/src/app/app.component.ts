import { Component } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Aero checker';

  columns = [];

  departures : any[] = [];
  departuresByTime = "";
  arrivals : any[] = [];
  arrivalsByTime = "";

  constructor(private http: Http){
    this.fillDepartures();
    this.fillArrivals();
  }

  ngOnInit() {
    this.columns = [
      'number',
      'status',
      'date',
      'company'
    ];
  }

  private fillDepartures(): void {
    this.http.get(`/flight/pulkovo/departures`)
      .subscribe(response => {
        let resp = response.json();

        this.departures = resp.data;
        this.departuresByTime = resp.now;
      });
  }

  private fillArrivals(): void {
    this.arrivals = [];
    this.http.get(`/flight/pulkovo/arrivals`)
      .subscribe(response => {
        let resp = response.json();

        this.arrivals = resp.data;
        this.arrivalsByTime = resp.now;
      });
  }
}
