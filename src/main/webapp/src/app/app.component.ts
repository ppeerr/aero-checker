import { Component } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';
  result = '';

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
      'id',
      'number',
      'status',
      'date',
      'company'
    ];
  }

  private sayHello(): void {
    this.result = 'loading...';
    this.http.get(`/api/hello-world`).subscribe(response => this.result = response.text());
  }

  private fillDepartures(): void {
    // this.departures = [];
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
