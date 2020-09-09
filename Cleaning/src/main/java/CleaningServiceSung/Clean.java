package CleaningServiceSung;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Clean_table")
public class Clean {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String status;
    private Long requestId;
    private String cleanDate;
    private String reviewDate;

    @PostPersist
    public void onPostPersist(){

        if("CleaningComplete".equals(getStatus())) {

            CleaningConfirmed cleaningConfirmed = new CleaningConfirmed();
            BeanUtils.copyProperties(this, cleaningConfirmed);

            cleaningConfirmed.setRequestId(getRequestId());
            cleaningConfirmed.setStatus("CleaningCompleted");
            cleaningConfirmed.setCleanDate(getCleanDate());
            cleaningConfirmed.publishAfterCommit();
        }

        else if("ReviewComplete".equals(getStatus())) {
            CleaningReviewed cleaningReviewed = new CleaningReviewed();
            BeanUtils.copyProperties(this, cleaningReviewed);

            cleaningReviewed.setRequestId(getRequestId());
            cleaningReviewed.setStatus("ReviewCompleted");
            cleaningReviewed.publishAfterCommit();
        }


    }


    @PrePersist
    public void onPrePersist(){
        //CleanService

    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRequestId() {
        return requestId;
    }
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getCleanDate() {
        return cleanDate;
    }
    public void setCleanDate(String cleanDate) {
        this.cleanDate = cleanDate;
    }

    public String getReviewDate() {
        return reviewDate;
    }
    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }




}
