package br.com.coderbank.customerportal.entity;

import br.com.coderbank.customerportal.enuns.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.UUID;

@Entity
@Data
@Table(name = "CB_CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column
    private String email;

    @Column
    private Integer age;

    @Column
    private String address;

    @Column
    private Status status;

    @Column
    private String createdByUser;

    @Column
    @CreationTimestamp
    private String createdDateAndTime;

    @Column
    private String editedByUser;

    @Column
    @UpdateTimestamp
    private String editedDateAndTime;
}
