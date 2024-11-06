package dasturlash.uz.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {
    private String id;

    @NotBlank(message = "Name required")
    @Size(min = 2,max = 255,message = "Name must be between 2 and 255 in length")
    private String name;

    @NotBlank(message = "Model required")
    @Size(min = 2, max = 255, message = "Model must be between 2 and 255 in length")
    private String model;

    @NotNull
    @Min(1900)
    private int year;
}
