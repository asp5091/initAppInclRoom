package com.personal_project.initproject.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestEntity (
    var testA : String,
    var testB : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}