import { Component, OnInit } from '@angular/core';
import {  BambooTrigger } from '../../BambooTrigger';
import { NgModel } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-confpage',
  templateUrl: './confpage.component.html',
  styleUrls: ['./confpage.component.css']
})
export class ConfpageComponent implements OnInit {
  bambooTrigger = new BambooTrigger();
  
  constructor(public http : HttpClient) { }
  ngOnInit() {
  }
  f(){
  console.log(this.bambooTrigger.bambooServerUrl);
  console.log( this.bambooTrigger);
  this.http
  .post('http://localhost:8100/v1/bamboospecs/config', this.bambooTrigger)
  .subscribe();
        // this._commentService.postComment(this.message).subscribe(
        //    data => console.log(this.responseStatus = data),
        //    err => console.log(err),
        //    () => console.log('Request Completed')
        // ); 
        // this.status = true;
  }
}
