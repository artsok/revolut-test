#language: en
Feature: Transfer money to beneficiary

  @regress
  @6
  Scenario:  Transfer money to beneficiary
    * page is being opened "Tutorial Page"
    * user (click the button) "Skip"
    * page is being opened "Authorization Page"
    * user (fill the field) "PhoneNumber" "662266"
    * user (click the button) "Next"
    * page is being opened "PinCode Page"
    * user (entering passcode) "1111"
    * page is being opened "Main Activity"
    * user (click the button) "Purple Transfer"
    * user (choosing transfer type) "To bank account"
    * user (click the button) "Skip"
    * page is being opened "Bank Transfer"
    * user (selecting first beneficiary)
    * page is being opened "Transfer"
    * user (fill the field) "Amount" "2"
    * user (selecting balance) "USD"
    * user (click the button) "Continue"
    * page is being opened "Transfer speed"
    * user (click the button) "Send"
    * page is being opened "Operation State"
    * user (checking that transfer is successfull)
    * user (click the button) "Done"
    * page is being opened "Main Activity"




