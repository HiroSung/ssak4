package CleaningServiceSung;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="DashBoardView_table")
public class DashBoardView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long requestId;
        private Integer price;
        private String customerName;
        private String status;
        private String cleanerName;
        private String reviewDate;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getRequestId() {
            return requestId;
        }

        public void setRequestId(Long requestId) {
            this.requestId = requestId;
        }
        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }
        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public String getCleanerName() {
            return cleanerName;
        }

        public void setCleanerName(String cleanerName) {
            this.cleanerName = cleanerName;
        }
        public String getReviewDate() {
            return reviewDate;
        }

        public void setReviewDate(String reviewDate) {
            this.reviewDate = reviewDate;
        }

}
