package customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
Nome da coluna   #  Tipo de dados  Comprimento  Não nulo  Auto Incrementar  Padrão  Descrição
---------------------------------------------------------------------------------------------
CustomerId       1  INTEGER        [NULL]       true      false             [NULL]  [NULL]
FirstName        2  NVARCHAR       [NULL]       true      false             [NULL]  [NULL]
LastName         3  NVARCHAR       [NULL]       true      false             [NULL]  [NULL]
Company          4  NVARCHAR       [NULL]       false     false             [NULL]  [NULL]
Address          5  NVARCHAR       [NULL]       false     false             [NULL]  [NULL]
City             6  NVARCHAR       [NULL]       false     false             [NULL]  [NULL]
State            7  NVARCHAR       [NULL]       false     false             [NULL]  [NULL]
Country          8  NVARCHAR       [NULL]       false     false             [NULL]  [NULL]
PostalCode       9  NVARCHAR       [NULL]       false     false             [NULL]  [NULL]
Phone           10  NVARCHAR       [NULL]       false     false             [NULL]  [NULL]
Fax             11  NVARCHAR       [NULL]       false     false             [NULL]  [NULL]
Email           12  NVARCHAR       [NULL]       true      false             [NULL]  [NULL]
SupportRepId    13  INTEGER        [NULL]       false     false             [NULL]  [NULL]
*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer customerId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String company;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @Column
    private String postalCode;

    @Column
    private String phone;

    @Column
    private String fax;

    @Column(nullable = false)
    private String email;

    @Column
    private String supportRepId;

}
