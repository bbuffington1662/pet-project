package Database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,   
  age INT NOT NULL,    
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "Pet")
public class Pet {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "name")
   private String name;

   @Column(name = "owner")
   private String owner;
   
   @Column(name = "species")
   private String species;
   
   @Column(name = "isBaby")
   private Boolean isBaby;
   
   @Column(name = "description")
   private String description;
   
   public Pet() {
   }

   public Pet(
		   String name, 
		   String owner, 
		   String species,
		   Boolean isBaby, 
		   String description) {
      this.name = name;
      this.owner = owner;
      this.species = species;
      this.isBaby = isBaby;
      this.description = description;
      //this.imagePath = imagePath;
   }

   public Pet(
		   Integer id,
		   String name, 
		   String owner, 
		   String species,
		   Boolean isBaby, 
		   String description) {
      this.id = id;
      this.name = name;
      this.owner = owner;
      this.species = species;
      this.isBaby = isBaby;
      this.description = description;
      //this.imagePath = imagePath;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getOwner() {
      return owner;
   }

   public void setOwner(String owner) {
      this.owner = owner;
   }
   
   public String getSpecies() {
      return species;
   }

   public void setSpecies(String species) {
      this.species = species;
   }
   
   public Boolean getIsBaby() {
      return isBaby;
   }

   public void setIsBaby(Boolean isBaby) {
      this.isBaby = isBaby;
   }
   
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   /*public String getImagePath() {
      return imagePath;
   }

   public void setImagePath(String imagePath) {
      this.imagePath = imagePath;
   }*/
   
   @Override
   public String toString() {
      return String.format("Name: %s<br/>Id: %d<br/>Owner: %s<br/>Species: %s<br/>Is a Baby: %b<br/>Description: %s", name, id, owner, species, isBaby, description);
   }
}