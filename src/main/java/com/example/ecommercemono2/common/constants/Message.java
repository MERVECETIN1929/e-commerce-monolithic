package com.example.ecommercemono2.common.constants;

public class Message {
    public static class Category {
        public static String AlreadyExistName = "Category Name Already Exist";
        public static String NotExistId = "Category Is Not Exist";

    }

    public static class Brand {
        public static String AlreadyExistName = "Brand Name Already Exist";
        public static String NotExistId = "Brand Is Not Exist";

    }

    public static class CartItem {
        public static String NotExistId = "CartItem Is Not Exist";

    }

    public static class User {

        public static String NotExistId = "User Is Not Exist";
        public static String AlreadyExistEmail = "Email already exist";

    }

    public static class Cart {
        public static String NotExistId = "Cart Is Not Exist";

    }

    public static class Product {
        public static String NotExistId = "Product Is Not Exist";
        public static String  NoStock = "Product Is Not In Stock";

    }

    public static class Address {
        public static String NotExistId = "Address Is Not Exist";
        public static String ExistAddress = "Address Is Already Exist";

    }

    public static class UsersAddress {
        public static String NotExistId = "UserAddress Is Not Exist";
        public static String NotExistUsersAddressByUserIdAndAddressId = "UserAddress Is Not  Exist";

    }
    public static class Payment {
        public static String NotExistId = "Payment Is Not Exist";
        public static String ExistByCardNumber = "CardNumber Already  Exist";
        public static String PaymentNotExists="Payment Is Not Exist";
        public static String BalanceNotEnough="Balance Not Enough";
    }
}
