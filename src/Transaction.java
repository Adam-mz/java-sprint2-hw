class Transaction{
    public String item_name;

    public int quantity;
    public int unit_price;


    public Transaction(String item_name , int quantity, int unit_price) {
        this.item_name = item_name;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

}