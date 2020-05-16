import { Component } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Aero checker v3';

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
    this.http.get(`/schedule/pulkovo/departures/earliest`)
      .subscribe(response => {
        let resp = response.json();

        this.departures = resp.data;
        this.departuresByTime = resp.now;
      });
  }

  private fillArrivals(): void {
    this.arrivals = [];
    this.http.get(`/schedule/pulkovo/arrivals/earliest`)
      .subscribe(response => {
        let resp = response.json();

        this.arrivals = resp.data;
        this.arrivalsByTime = resp.now;
      });
  }
}
