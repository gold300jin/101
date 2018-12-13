package concurrent.yield;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Person implements Bridge {

    private String name;
    private String gender;


    @Override
    public void crossBridge()  {
        log.info("{} [{}] is cross bridge", name, gender);
    }
}
