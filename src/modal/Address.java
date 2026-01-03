package modal;

public class Address extends BaseModal{

    private String houseNumber;
    private String street;
    private String city;
    private String pincode;

    public void setHouseNumber(String houseNumber){
        this.houseNumber = houseNumber;
    }
    public String getHouseNumber(){
        return this.houseNumber;
    }

    public void setStreet(String street){
        this.street = street;
    }
    public String getStreet(){
        return this.street;
    }

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }

    public void setPincode(String pincode){
        this.pincode = pincode;
    }
    public String getPincode(){
        return this.pincode;
    }
}
