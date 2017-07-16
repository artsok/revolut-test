#language: en
Feature: Delete beneficiary

  @regress
  @4
  Scenario:  Delete beneficiary
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
    * user (delete first beneficiary in list) "DELETE"
    * user (checking that operation finished successfully)

  @regress
  @41
  Scenario:  Delete beneficiary with Cancel Operation
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
    * user (delete first beneficiary in list) "CANCEL"
    * user (checking that beneficiary remained in list)
