package fr.codecake.airbnb_clone_back.listing.domain;

import fr.codecake.airbnb_clone_back.sharedkernel.domain.AbstractAuditingEntity;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "listing_picture")
public class ListingPicture extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "listingPictureSequenceGenerator")
    @SequenceGenerator(name = "listingPictureSequenceGenerator", sequenceName = "listing_picture_generator", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "listing_fk", referencedColumnName = "id")
    private Listing listing;

    @Lob
    @Column(name = "file", nullable = false)
    private byte[] file;

    @Column(name = "file_content_type")
    private String fileContentType;

    @Column(name = "cover")
    private boolean isCover;

    public void setId(long id) {
        this.id = id;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public boolean isCover() {
        return isCover;
    }

    public void setCover(boolean cover) {
        isCover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListingPicture that = (ListingPicture) o;
        return isCover == that.isCover && Arrays.equals(file, that.file) && fileContentType.equals(that.fileContentType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fileContentType, isCover);
        result = 31 * result + Arrays.hashCode(file);
        return result;
    }

    @Override
    public String toString() {
        return "ListingPicture{" +
                "id=" + id +
                ", listing=" + listing +
                ", file=" + Arrays.toString(file) +
                ", fileContentType='" + fileContentType + '\'' +
                ", isCover=" + isCover +
                '}';
    }

    @Override
    public Long getId() {
        return null;
    }
}
