package tests;

import constants.ITestConstants;
import objects.Address;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.ITestData;
import utils.PropertyReader;

public class AddressTest extends BaseTest implements ITestData, ITestConstants {

    @Test(description = "Check that address can be updated", dataProvider = "Update address", dataProviderClass = ITestData.class)
    public void checkAddressUpdatedTest(String address, String city, String state, String zipCode, String country,
                                        String mobilePhone, String addressAlias) {
        Address changingAddress = new Address(address, city, state, zipCode, country, mobilePhone, addressAlias);
        authenticationSteps
                .signIn(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        myAddressesSteps
                .updateAddress(changingAddress.getAddressAlias(), changingAddress);
        Assert.assertEquals(myAddressesSteps.getAddress(changingAddress.getAddressAlias()), changingAddress.getAddress());
        Assert.assertEquals(myAddressesSteps.getMobilePhone(changingAddress.getAddressAlias()), changingAddress.getMobilePhone());
    }

    @Test(description = "Check that created address can be selected as delivery address")
    public void checkNewAddressCanBeSelectedAsDeliveryAddressTest() {
        Address newAddress = new Address(ADDRESS, CITY, STATE, ZIP_CODE, COUNTRY, MOBILE_PHONE, getRandomChar());
        authenticationSteps
                .signIn(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        myAddressesSteps
                .createNewAddress(newAddress);
        homeSteps
                .addProductToCart(PRINTED_CHIFFON_DRESS_PRODUCT);
        shoppingCartAddressSteps
                .goToShoppingCartAddressPageAndSelectDeliveryAddress(newAddress.getAddressAlias());
        Assert.assertEquals(shoppingCartAddressSteps.getSelectedDeliveryAddress(), newAddress.getAddressAlias());
    }
}