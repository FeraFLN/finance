package com.ferafln.finance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="email_send")
public class EmailSend extends BaseEntity {

    private String sendFrom;
    private String sendTo;
    private String subject;
    private String text;
    private String sendCC;

}
