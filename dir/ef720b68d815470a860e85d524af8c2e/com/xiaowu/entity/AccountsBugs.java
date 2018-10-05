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
public class AccountsBugs implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String accountId;

    private String bugId;

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

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
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
        return "AccountsBugs{" +
        "id=" + id +
        ", accountId=" + accountId +
        ", bugId=" + bugId +
        ", dateModified=" + dateModified +
        ", deleted=" + deleted +
        "}";
    }
}
