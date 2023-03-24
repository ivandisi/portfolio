package it.ivandisiro.portfolio.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class Skill {
    @PrimaryKey var uid: Long;
    @ColumnInfo(name = "skillname") var skillName: String = "";
    @ColumnInfo(name = "skillicon")  var skillIcon: String = "";

    constructor(skillName: String, skillIcon: String) {
        this.uid = System.currentTimeMillis();
        this.skillName = skillName;
        this.skillIcon = skillIcon;
    }
}