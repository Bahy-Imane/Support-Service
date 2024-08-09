//package Support.Service.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "equipment_history")
//public class FailureHistory {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long historyId;
//
//    @ManyToOne
//    @JoinColumn(name = "equipment_id")
//    private Equipment equipment;
//
//    @Column
//    private LocalDateTime historyDate;
//
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "failure_id")
//    private Failure failure;
//
//
//}
