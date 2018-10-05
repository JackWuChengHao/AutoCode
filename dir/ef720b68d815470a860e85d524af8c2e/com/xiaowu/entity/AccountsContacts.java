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
public class AccountsContacts implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String contactId;

    private String accountId;

    private LocalDateTime dateModified;

    private Boolean deleted;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
        return "AccountsContacts{" +
        "id=" + id +
        ", contactId=" + contactId +
        ", accountId=" + accountId +
        ", dateModified=" + dateModified +
        ", deleted=" + deleted +
        "}";
    }
}
