package team.java.auction.house.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "PHOTOS")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHOTO_ID", unique = true, nullable = false)
    private Long photoId;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;

    @Column(name = "PHOTO_NAME", nullable = false)
    private String photoName;

    @Column(name = "PATH", nullable = false)
    private String path;

    @Column(name = "ADDED_DATE")
    private Date addedDate;

    public PhotoEntity(String photoName, String path) {
        this();
        this.photoName = photoName;
        this.path = path;
    }

    private PhotoEntity() {
        this.addedDate = Date.valueOf(LocalDate.now());
    }
}
