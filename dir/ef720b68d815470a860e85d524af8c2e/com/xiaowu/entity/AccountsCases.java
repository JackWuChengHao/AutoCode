package com.xiaowu.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AutoCode
 * @since 2018-10-05
 */
public class AccountsCases implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String accountId;

    private String caseId;

    private LocalDateTime dateModified;

    private Boolean deleted;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "AccountsCases{" +
        "id=" + id +
        ", accountId=" + accountId +
        ", caseId=" + caseId +
        ", dateModified=" + dateModified +
        ", deleted=" + deleted +
        "}";
    }
}
