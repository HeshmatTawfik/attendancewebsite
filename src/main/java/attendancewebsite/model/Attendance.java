package attendancewebsite.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity(name = "attendance")
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendanceId")
    private int id;
    @Column(name = "attendanceDate")
    private String date;
    @Column(name = "studentId")
    private int studentId;
    @Column(name = "attendanceState")
    private int attendanceState;
    @Column(name = "subjectName")
    private String subjectName;


}
