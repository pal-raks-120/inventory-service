package com.springpal.retail.domain.repo;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name ="products")
@Data //@Getter,@Setter,@RequiredArgsConstructor,@ToString,@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GenerationType.Auto for hibernate validation will asks for seq say like here product_seq in fluway db migration so this change is done
    private Long productId;

    @Column(nullable = false,unique = true)
    @NotEmpty(message = "Product code is required")
    private String code;

    @NotEmpty(message = "Product name is required")
    @Column(nullable = false)
    private String name;

    private String description;

  //  @Column(name="image_url") no need to provide as hibernate automatically take care of it
    private String imageUrl;

    @NotNull(message = "Product price is required")
    @DecimalMin("0.1")
    @Column(nullable = false)
    private BigDecimal price;
}
