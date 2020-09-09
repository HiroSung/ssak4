package CleaningServiceSung;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Review_table")
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long requestId;
    private String content;
    private String reviewDate;
    private String status;

    @PostPersist
    public void onPostPersist(){

        System.out.println("##### Review onPostPersist : " + getStatus());

        if("CleaningReviewed".equals(getStatus())) {

            ReviewCompleted reviewCompleted = new ReviewCompleted();
            BeanUtils.copyProperties(this, reviewCompleted);
            reviewCompleted.setRequestId(getRequestId());
            reviewCompleted.setStatus("ReviewCompleted");
            reviewCompleted.publishAfterCommit();
        }


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRequestId() {
        return requestId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }




}
