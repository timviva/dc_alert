package com.example.dcalert



class User {


    var name :String=""
    var email :String=""
    var CrimeDescription  :String=""
    var Id:String=""
    var Place:String=""
    var Date:String=""
    var Time:String=""


    constructor(
        name: String,
        email: String,
        CrimeDescription: String,
        Id: String,
        Place: String,
        Date: String,
        Time: String
    ) {
        this.name = name
        this.email = email
        this.CrimeDescription = CrimeDescription
        this.Id = Id
        this.Place = Place
        this.Date = Date
        this.Time = Time
    }
    constructor()
}