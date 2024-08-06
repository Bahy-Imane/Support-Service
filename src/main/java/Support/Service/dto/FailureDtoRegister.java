package Support.Service.dto;


import Support.Service.enu.FailureStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FailureDtoRegister {

    private FailureStatus status;
    private String note;
}
