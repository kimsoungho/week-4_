package com.example.week4.Entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass//멤버 변수 컬럼
@EntityListeners(AuditingEntityListener.class)//변경후 자동 기록

public class Timestamped {
    @CreatedDate // 최초 생성
    private LocalDateTime createdAt;

    @LastModifiedBy//마지박 변경 장소
    private LocalDateTime modifiedAt;
}
