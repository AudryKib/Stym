package org.ItSolutions.StymBackEnd.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "Stem_Folder")
@Getter
@Setter
@Builder
public class Stem_Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StemId")
    private Integer stemId;

    @Column(name = "Name")
    private String name;

    @Column(name = "CreationDate")
    @CreationTimestamp
    private Date creationDate;



    @Column(name = "NumberofTracks")
    private int numberOfTracks;

    @Column(name = "Stem")
    private String stym;

    @Column(name = "ArtWork")
    private String artWork;

    @Column(name = "Description")
    private String description;

    @OneToOne(mappedBy = "stemFolder")
    private Stem_MP3 stemmp3;

    public Stem_Folder() {
    }

    public Stem_Folder(Integer stemId, String name, Date creationDate, int numberOfTracks, String stym, String artWork, String description, Stem_MP3 stemmp3) {
        this.stemId = stemId;
        this.name = name;
        this.creationDate = creationDate;
        this.numberOfTracks = numberOfTracks;
        this.stym = stym;
        this.artWork = artWork;
        this.description = description;
        this.stemmp3 = stemmp3;
    }
}
