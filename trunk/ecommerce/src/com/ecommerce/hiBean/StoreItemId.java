package com.ecommerce.hiBean;



/**
 * StoreItemId entity. @author MyEclipse Persistence Tools
 */

public class StoreItemId  implements java.io.Serializable {


    // Fields    

     private Integer storeId;
     private Integer itemId;
     private Integer itemNumber;


    // Constructors

    /** default constructor */
    public StoreItemId() {
    }

    
    /** full constructor */
    public StoreItemId(Integer storeId, Integer itemId, Integer itemNumber) {
        this.storeId = storeId;
        this.itemId = itemId;
        this.itemNumber = itemNumber;
    }

   
    // Property accessors

    public Integer getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getItemId() {
        return this.itemId;
    }
    
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemNumber() {
        return this.itemNumber;
    }
    
    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StoreItemId) ) return false;
		 StoreItemId castOther = ( StoreItemId ) other; 
         
		 return ( (this.getStoreId()==castOther.getStoreId()) || ( this.getStoreId()!=null && castOther.getStoreId()!=null && this.getStoreId().equals(castOther.getStoreId()) ) )
 && ( (this.getItemId()==castOther.getItemId()) || ( this.getItemId()!=null && castOther.getItemId()!=null && this.getItemId().equals(castOther.getItemId()) ) )
 && ( (this.getItemNumber()==castOther.getItemNumber()) || ( this.getItemNumber()!=null && castOther.getItemNumber()!=null && this.getItemNumber().equals(castOther.getItemNumber()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getStoreId() == null ? 0 : this.getStoreId().hashCode() );
         result = 37 * result + ( getItemId() == null ? 0 : this.getItemId().hashCode() );
         result = 37 * result + ( getItemNumber() == null ? 0 : this.getItemNumber().hashCode() );
         return result;
   }   





}