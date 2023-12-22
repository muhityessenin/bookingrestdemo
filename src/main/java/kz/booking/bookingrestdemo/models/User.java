package kz.booking.bookingrestdemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Getter
    @Column(name = "user_name")
    private String username;
    @Getter
    @Column(name = "user_password")
    private String password;
    @Column(name = "email")
    private String user_email;

}