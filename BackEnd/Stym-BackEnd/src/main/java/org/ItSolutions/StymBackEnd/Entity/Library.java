package org.ItSolutions.StymBackEnd.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@Table(name="Library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LibraryId")
    private Integer libraryId;

    @Column(name = "Name")
    private String name;

    @Column(name = "CreationDate")
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "LastAccessdate")
    @UpdateTimestamp
    private Date lastAccessDate;

    @Column(name = "Accountid")
    private Integer accountId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "library")
    private Set<Stem_MP3> Stems;

    @ManyToOne
    @JoinColumn(name ="accountid", referencedColumnName = "userid",nullable = false, insertable = false, updatable = false)
    private Account account;

    public Library(Integer libraryId, String name, Date creationDate, Date lastAccessDate, Integer accountId, Set<Stem_MP3> stems, Account account) {
        this.libraryId = libraryId;
        this.name = name;
        this.creationDate = creationDate;
        this.lastAccessDate = lastAccessDate;
        this.accountId = accountId;
        Stems = stems;
        this.account = account;
    }

    public Library() {;
    }
}
