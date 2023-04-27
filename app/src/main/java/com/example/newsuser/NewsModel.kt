package com.example.newsuser

class NewsModel {

    lateinit var title : String
    lateinit var img : String
    lateinit var key : String
    lateinit var description : String

    constructor(title: String, img: String,key:String, description: String) {
        this.title = title
        this.img = img
        this.key = key
        this.description = description
    }

    constructor(){

    }
}