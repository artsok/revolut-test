#language: en
Feature: Edit beneficiary

  @regress
  @5
  Scenario:  Edit beneficiary
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
    * user (edit first beneficiary in list)
    * page is being opened "Choose country and currency"
    * user (click the button) "Next"
    * page is being opened "Fill into account details"
    * user (fill the field) "Mobile phone (optional)" "+79117556228"
    * user (click the button) "Next"
    * page is being opened "Address details"
    * user (click the button) "Save"
    * page is being opened "Operation State"
    * user (checking that beneficiary successfully changed)
    * user (click the button) "Done"
    * page is being opened "Bank Transfer"