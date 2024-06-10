package jp.te4a.spring.boot.myapp13_v2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserBean {
    @Id
    private String username;
    @JsonIgnore
    private String password;
    @Column(name = "Role_id",nullable = true)
    private Byte roleId;
}
