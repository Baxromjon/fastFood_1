//package ai.fl.demofoods.entity;
//
//import ai.fl.demofoods.entity.template.AbsEntity;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.ManyToOne;
//
///**
// * created by Baxromjon
// * 04.02.2022
// **/
//
//
//@EqualsAndHashCode(callSuper = true)
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Region extends AbsEntity {
//    @Column(nullable = false)
//    private String name;
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private Country country;
//}
