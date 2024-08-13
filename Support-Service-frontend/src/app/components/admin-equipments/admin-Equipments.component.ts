// import { Component, OnInit } from '@angular/core';
// import { EventService } from '../../services/event.service';
// import { Event } from '../../interface/event';
// import { CommonModule } from '@angular/common';
// import * as console from "node:console";
//
// @Component({
//   selector: 'app-admin-allevents',
//   standalone: true,
//   imports: [CommonModule],
//   templateUrl: './admin-Equipments.component.html',
//   styleUrl: './admin-Equipments.component.css'
// })
//
// export class AdminEquipmentsComponent implements OnInit {
//   allEvents:Event[] = [];
//   constructor(private eventService: EventService) {}
//   ngOnInit(): void {
//     this.eventService.getAllEvents().subscribe({
//       complete(): void {
//       },
//       next: (res: Event[]) => {
//         this.allEvents = res;
//       },
//       error: (err) => console.error('Error fetching events:', err)
//     });
//   }
//
//   deleteEvent(id:number){
//     this._EventService.deleteEvent(id).subscribe({
//       next:(_res)=>{
//         this._EventService.getAllEvents().subscribe({
//           next: (res) => {
//             this.allEvents = res;
//           },
//         });
//       }
//     });
//   }
// }
