package com.ecommerce.hiBean;



/**
 * StoreItem entity. @author MyEclipse Persistence Tools
 */

public class StoreItem  implements java.io.Serializable {


    // Fields    

     private StoreItemId id;
     private Store store;
     private Item item;


    // Constructors

    /** default constructor */
    public StoreItem() {
    }

    
    /** full constructor */
    public StoreItem(StoreItemId id, Store store, Item item) {
        this.id = id;
        this.store = store;
        this.item = item;
    }

   
    // Property accessors

    public StoreItemId getId() {
        return this.id;
    }
    
    public void setId(StoreItemId id) {
        this.id = id;
    }

    public Store getStore() {
        return this.store;
    }
    
    public void setStore(Store store) {
        this.store = store;
    }

    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
   








}