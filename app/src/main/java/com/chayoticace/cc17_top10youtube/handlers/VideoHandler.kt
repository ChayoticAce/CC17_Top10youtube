package com.example.myfavoriteyoutubechannels.handlers

import com.example.myfavoriteyoutubechannels.models.YoutubeVideo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class VideoHandler {
    //initalize all need fields
    var database: FirebaseDatabase
    var youtubeVideosReference: DatabaseReference

    init {
        database = FirebaseDatabase.getInstance()
        youtubeVideosReference = database.getReference("youtube_video")
    }

    //create func
    fun create(youtubeVideo: YoutubeVideo): Boolean{
        val id = youtubeVideosReference.push().key
        youtubeVideo.id = id

        youtubeVideosReference.child(id!!).setValue(youtubeVideo)


        return true
    }

    //update func
    fun update(youtubeVideo: YoutubeVideo):Boolean {
        youtubeVideosReference.child(youtubeVideo.id!!).setValue(youtubeVideo)
        return true
    }

    //delete func
    fun delete(youtubeVideo: YoutubeVideo): Boolean {
        youtubeVideosReference.child(youtubeVideo.id!!).removeValue()
        return true
    }
}