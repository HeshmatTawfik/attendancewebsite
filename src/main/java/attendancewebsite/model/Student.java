package attendancewebsite.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.Collection;


@Data
@NoArgsConstructor
@Entity(name = "student")
@Table(name = "student")
public class Student implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  @Column(name = "id")
    @Column(name = "studentID")
    private int id;
    @Column(name = "studentName")
    @NotBlank
    private String studentName;
    @Column(name = "pass")
    @NotBlank
    private String password;
    @Column(name = "authority")
    private String authority;
    @Column(name = "absenceCounter")
    private int absenceCounter;
    @Column(name = "absenceLevel")
    private String absenceLevel;

    @Autowired
    public static Student loginStudent = new Student();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
