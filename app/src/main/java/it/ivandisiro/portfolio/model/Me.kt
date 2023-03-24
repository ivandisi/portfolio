package it.ivandisiro.portfolio.model

import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
class Me {
    @PrimaryKey var uid: Long;
    @ColumnInfo(name = "name") var name: String = "";
    @ColumnInfo(name = "surname") var surname: String = "";
    @ColumnInfo(name = "nationality") var nationality: String = "";
    @ColumnInfo(name = "job") var job: String = "";
    @ColumnInfo(name = "url") var url: String = "";
    @ColumnInfo(name = "aboutme") var aboutMe: String = "";
    @ColumnInfo(name = "linkedin") var linkedin: String = "";
    @ColumnInfo(name = "github") var github: String = "";
    @ColumnInfo(name = "playstore") var playstore: String = "";
    @ColumnInfo(name = "stackoverflow") var stackoverflow: String = "";
    @Ignore var skills: List<Skill> = ArrayList<Skill>();

    constructor() {
        this.uid = System.currentTimeMillis();
    }

}