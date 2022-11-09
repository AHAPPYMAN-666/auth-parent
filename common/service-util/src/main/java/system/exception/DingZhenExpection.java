package system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DingZhenExpection extends RuntimeException{
    private Integer Code;
    private String msg;
}
