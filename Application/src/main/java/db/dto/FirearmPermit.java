package db.dto;

import java.util.Date;

public class FirearmPermit {
    private String firearmPermitId;
    private Date issueDate;
    private Date expirationDate;

    public String getFirearmPermitId() {
        return firearmPermitId;
    }

    public void setFirearmPermitId(String firearmPermitId) {
        this.firearmPermitId = firearmPermitId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
