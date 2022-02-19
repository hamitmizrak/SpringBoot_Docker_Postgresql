package com.hamitmizrak.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Log4j2

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

//JSON verisinde gözükmesi istenmeyen anahtarlar belirtilir.
@JsonIgnoreProperties(value = {"created_date,update_date"},allowGetters = true)
public class BaseEntityAudit {

    @Id
    @Column(name = "id", nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //kim ekledi
    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private String createdBy;

    //kim ne zaman oluşturdu
    @Column(name = "created_date", nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @CreatedDate
    private Date createdDate;

    //kim güncelledi
    @Column(name = "update_by", nullable = false)
    @LastModifiedBy
    private String updateBy;

    @Column(name = "update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;
}
