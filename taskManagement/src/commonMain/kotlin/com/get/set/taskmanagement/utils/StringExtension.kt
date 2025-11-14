package com.get.set.taskmanagement.utils

fun String.getInitial(): String {
    if(this.contains(" ")) {
        val split = this.split(" ")
         return "${split[0].first()}${split[1].first()}";
    }else{
        return "SCC"
    }
}

fun String.greetings(): String {
   return if(this.contains(" ")) "Hello ${this.split(" ").first()}" else "Hello $this"
}